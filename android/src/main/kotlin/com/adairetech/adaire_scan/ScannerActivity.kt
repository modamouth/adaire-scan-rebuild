package com.adairetech.adaire_scan

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.Camera
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicBoolean

class ScannerActivity : ComponentActivity() {
    private val completed = AtomicBoolean(false)
    private val executor = Executors.newSingleThreadExecutor()
    private val decoder = QrDecoder()
    private lateinit var previewView: PreviewView
    private lateinit var torchButton: Button
    private var cameraProvider: ProcessCameraProvider? = null
    private var camera: Camera? = null
    private var torchEnabled = false
    private var requestingPermission = false
    private val permissionRequest = registerForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
        requestingPermission = false
        if (granted) startCamera() else finishWith(TYPE_PERMISSION_DENIED)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() = finishWith(TYPE_CANCELLED)
        })
        buildInterface()
        if (!packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY)) {
            finishWith(TYPE_UNAVAILABLE)
            return
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            startCamera()
        } else {
            requestingPermission = true
            permissionRequest.launch(Manifest.permission.CAMERA)
        }
    }

    private fun buildInterface() {
        previewView = PreviewView(this).apply {
            contentDescription = "Camera preview for QR alignment"
            importantForAccessibility = android.view.View.IMPORTANT_FOR_ACCESSIBILITY_NO
        }
        val root = FrameLayout(this).apply { setBackgroundColor(Color.BLACK) }
        root.addView(previewView, FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))

        val controls = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER_HORIZONTAL
            setPadding(dp(16), dp(24), dp(16), dp(24))
            setBackgroundColor(0x99000000.toInt())
        }
        val guidance = TextView(this).apply {
            text = "Align one QR code inside the camera view. Camera alignment may require sighted assistance."
            setTextColor(Color.WHITE)
            textSize = 18f
            gravity = Gravity.CENTER
            importantForAccessibility = android.view.View.IMPORTANT_FOR_ACCESSIBILITY_YES
        }
        torchButton = Button(this).apply {
            text = "Turn torch on"
            contentDescription = "Turn torch on"
            minWidth = dp(48)
            minHeight = dp(48)
            isEnabled = false
            setOnClickListener { toggleTorch() }
        }
        val close = Button(this).apply {
            text = "Close scanner"
            contentDescription = "Close scanner"
            minWidth = dp(48)
            minHeight = dp(48)
            setOnClickListener { finishWith(TYPE_CANCELLED) }
        }
        controls.addView(guidance, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT).apply { bottomMargin = dp(12) })
        controls.addView(torchButton)
        controls.addView(close)
        root.addView(controls, FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.BOTTOM))
        setContentView(root)
        guidance.sendAccessibilityEvent(android.view.accessibility.AccessibilityEvent.TYPE_VIEW_FOCUSED)
    }

    private fun startCamera() {
        val future = ProcessCameraProvider.getInstance(this)
        future.addListener({
            if (completed.get()) return@addListener
            try {
                val provider = future.get()
                cameraProvider = provider
                val preview = Preview.Builder().build().also { it.surfaceProvider = previewView.surfaceProvider }
                val analysis = ImageAnalysis.Builder()
                    .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
                    .build()
                analysis.setAnalyzer(executor) { image ->
                    try {
                        val value = decoder.decode(image)
                        if (value != null) runOnUiThread { finishWith(TYPE_SUCCESS, value) }
                    } finally {
                        image.close()
                    }
                }
                provider.unbindAll()
                camera = provider.bindToLifecycle(this, CameraSelector.DEFAULT_BACK_CAMERA, preview, analysis)
                torchButton.isEnabled = camera?.cameraInfo?.hasFlashUnit() == true
            } catch (_: Exception) {
                finishWith(TYPE_FAILURE)
            }
        }, ContextCompat.getMainExecutor(this))
    }

    private fun toggleTorch() {
        val activeCamera = camera ?: return
        if (!activeCamera.cameraInfo.hasFlashUnit()) return
        torchEnabled = !torchEnabled
        activeCamera.cameraControl.enableTorch(torchEnabled)
        torchButton.text = if (torchEnabled) "Turn torch off" else "Turn torch on"
        torchButton.contentDescription = torchButton.text
        ViewCompat.setStateDescription(torchButton, if (torchEnabled) "Torch on" else "Torch off")
    }

    override fun onStop() {
        super.onStop()
        if (!isChangingConfigurations && !requestingPermission && !isFinishing) finishWith(TYPE_INTERRUPTED)
    }

    private fun finishWith(type: String, value: String? = null) {
        if (!completed.compareAndSet(false, true)) return
        cameraProvider?.unbindAll()
        camera = null
        val data = Intent().putExtra(EXTRA_TYPE, type)
        if (type == TYPE_SUCCESS && !value.isNullOrEmpty()) data.putExtra(EXTRA_VALUE, value)
        setResult(if (type == TYPE_SUCCESS) Activity.RESULT_OK else Activity.RESULT_CANCELED, data)
        finish()
    }

    override fun onDestroy() {
        cameraProvider?.unbindAll()
        executor.shutdownNow()
        super.onDestroy()
    }

    private fun dp(value: Int): Int = (value * resources.displayMetrics.density).toInt()

    companion object {
        const val EXTRA_TYPE = "com.adairetech.adaire_scan.outcome"
        const val EXTRA_VALUE = "com.adairetech.adaire_scan.value"
        const val TYPE_SUCCESS = "success"
        const val TYPE_CANCELLED = "cancelled"
        const val TYPE_PERMISSION_DENIED = "permission_denied"
        const val TYPE_UNAVAILABLE = "unavailable"
        const val TYPE_FAILURE = "failure"
        const val TYPE_INTERRUPTED = "interrupted"
    }
}
