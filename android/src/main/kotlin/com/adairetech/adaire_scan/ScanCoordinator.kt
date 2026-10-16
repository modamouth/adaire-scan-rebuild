package com.adairetech.adaire_scan

internal enum class ScanState { IDLE, PRESENTING, SCANNING, COMPLETING, DETACHED }

internal class ScanCoordinator {
    var state: ScanState = ScanState.IDLE
        private set

    @Synchronized fun begin(): Boolean {
        if (state != ScanState.IDLE) return false
        state = ScanState.PRESENTING
        return true
    }

    @Synchronized fun markScanning() { if (state == ScanState.PRESENTING) state = ScanState.SCANNING }

    @Synchronized fun finish(): Boolean {
        if (state != ScanState.PRESENTING && state != ScanState.SCANNING) return false
        state = ScanState.COMPLETING
        state = ScanState.IDLE
        return true
    }

    @Synchronized fun detach(): Boolean {
        val active = state == ScanState.PRESENTING || state == ScanState.SCANNING
        state = ScanState.DETACHED
        return active
    }

    @Synchronized fun attach() { if (state == ScanState.DETACHED) state = ScanState.IDLE }
}
