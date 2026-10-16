package com.adairetech.adaire_scan

import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter
import kotlin.test.Test
import kotlin.test.assertEquals

class QrDecoderTest {
    @Test fun `decodes an independently generated synthetic QR value`() {
        val value = "ADAIRE-SYNTHETIC-QR-V1"
        val size = 240
        val matrix = QRCodeWriter().encode(value, BarcodeFormat.QR_CODE, size, size)
        val luminance = ByteArray(size * size) { index ->
            if (matrix[index % size, index / size]) 0 else 0xff.toByte()
        }

        assertEquals(value, QrDecoder().decode(luminance, size, size))
    }
}
