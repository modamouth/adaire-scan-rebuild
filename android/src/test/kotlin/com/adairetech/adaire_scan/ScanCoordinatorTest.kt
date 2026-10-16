package com.adairetech.adaire_scan

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ScanCoordinatorTest {
    @Test fun `only idle begins and completion occurs once`() {
        val coordinator = ScanCoordinator()
        assertTrue(coordinator.begin())
        assertFalse(coordinator.begin())
        coordinator.markScanning()
        assertEquals(ScanState.SCANNING, coordinator.state)
        assertTrue(coordinator.finish())
        assertFalse(coordinator.finish())
        assertEquals(ScanState.IDLE, coordinator.state)
    }

    @Test fun `detach blocks until reattached`() {
        val coordinator = ScanCoordinator()
        assertTrue(coordinator.begin())
        assertTrue(coordinator.detach())
        assertFalse(coordinator.begin())
        coordinator.attach()
        assertTrue(coordinator.begin())
    }
}
