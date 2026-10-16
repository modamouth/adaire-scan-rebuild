package com.adairetech.adaire_scan

import android.app.Activity
import android.content.Intent
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.embedding.engine.plugins.activity.ActivityAware
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
import io.flutter.plugin.common.PluginRegistry
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume

class AdaireScanPlugin : FlutterPlugin, ActivityAware, AdaireScanHostApi, PluginRegistry.ActivityResultListener {
    private var activityBinding: ActivityPluginBinding? = null
    private var pending: Continuation<NativeScanReply>? = null
    private val coordinator = ScanCoordinator()

    override fun onAttachedToEngine(binding: FlutterPlugin.FlutterPluginBinding) {
        AdaireScanHostApi.setUp(binding.binaryMessenger, this)
    }

    override fun onDetachedFromEngine(binding: FlutterPlugin.FlutterPluginBinding) {
        AdaireScanHostApi.setUp(binding.binaryMessenger, null)
        detachWithOutcome()
    }

    override suspend fun scan(request: NativeScanRequest): NativeScanReply {
        if (request.formats != listOf("qr")) return NativeScanReply(NativeOutcomeType.FAILURE, code = "presentation_failed")
        val activity = activityBinding?.activity ?: return NativeScanReply(NativeOutcomeType.UNAVAILABLE, code = "no_activity")
        if (!activity.packageManager.hasSystemFeature("android.hardware.camera.any")) {
            return NativeScanReply(NativeOutcomeType.UNAVAILABLE, code = "no_camera")
        }
        if (!coordinator.begin()) return NativeScanReply(NativeOutcomeType.BUSY)
        return suspendCancellableCoroutine { continuation ->
            pending = continuation
            continuation.invokeOnCancellation {
                if (pending === continuation) {
                    pending = null
                    coordinator.finish()
                }
            }
            try {
                activity.startActivityForResult(Intent(activity, ScannerActivity::class.java), REQUEST_SCAN)
                coordinator.markScanning()
            } catch (_: RuntimeException) {
                complete(NativeScanReply(NativeOutcomeType.FAILURE, code = "presentation_failed"))
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?): Boolean {
        if (requestCode != REQUEST_SCAN) return false
        val type = data?.getStringExtra(ScannerActivity.EXTRA_TYPE)
        val reply = when (type) {
            ScannerActivity.TYPE_SUCCESS -> {
                val value = data.getStringExtra(ScannerActivity.EXTRA_VALUE)
                if (resultCode == Activity.RESULT_OK && !value.isNullOrEmpty()) {
                    NativeScanReply(NativeOutcomeType.SUCCESS, value = value, format = "qr")
                } else NativeScanReply(NativeOutcomeType.FAILURE, code = "decode_failed")
            }
            ScannerActivity.TYPE_PERMISSION_DENIED -> NativeScanReply(NativeOutcomeType.PERMISSION_DENIED)
            ScannerActivity.TYPE_UNAVAILABLE -> NativeScanReply(NativeOutcomeType.UNAVAILABLE, code = "no_camera")
            ScannerActivity.TYPE_FAILURE -> NativeScanReply(NativeOutcomeType.FAILURE, code = "camera_start_failed")
            ScannerActivity.TYPE_INTERRUPTED -> NativeScanReply(NativeOutcomeType.FAILURE, code = "interrupted")
            else -> NativeScanReply(NativeOutcomeType.CANCELLED)
        }
        complete(reply)
        return true
    }

    private fun complete(reply: NativeScanReply) {
        if (!coordinator.finish()) return
        val continuation = pending ?: return
        pending = null
        continuation.resume(reply)
    }

    override fun onAttachedToActivity(binding: ActivityPluginBinding) {
        activityBinding = binding
        coordinator.attach()
        binding.addActivityResultListener(this)
    }

    override fun onDetachedFromActivityForConfigChanges() = detachActivity()
    override fun onReattachedToActivityForConfigChanges(binding: ActivityPluginBinding) = onAttachedToActivity(binding)
    override fun onDetachedFromActivity() = detachActivity()

    private fun detachActivity() {
        activityBinding?.removeActivityResultListener(this)
        activityBinding = null
        detachWithOutcome()
    }

    private fun detachWithOutcome() {
        if (!coordinator.detach()) return
        val continuation = pending ?: return
        pending = null
        continuation.resume(NativeScanReply(NativeOutcomeType.UNAVAILABLE, code = "activity_detached"))
    }

    private companion object { const val REQUEST_SCAN = 4815 }
}
