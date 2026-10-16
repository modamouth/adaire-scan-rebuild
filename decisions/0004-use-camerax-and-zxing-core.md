# ADR 0004 Use CameraX and ZXing Core for local scanning

**Status:** proposed for human and Security review

**Date:** 2026-10-16

**Owners:** Architect and Security

## Context

The product needs a custom accessible camera interface, strict format filtering, offline availability, and no analytics or runtime data egress.

ML Kit processes barcode inputs on-device, but its terms and Android disclosure documentation state that the SDK sends diagnostics and usage metrics to Google. That conflicts with the approved no-analytics boundary. Google Code Scanner also uses Google Play services and does not provide the required custom interface.

ZXing Core is Apache 2.0 and decodes locally, but its Java project is in maintenance mode. CameraX is actively maintained and provides lifecycle-aware camera preview and image analysis.

## Proposed decision

- Camera pipeline: stable CameraX 1.6.2 `Preview` and `ImageAnalysis`
- Decoder: ZXing Core 3.5.4
- Initial decoder configuration: QR only
- Later gated formats: EAN-13 and Code 128
- No `INTERNET` permission
- No ML Kit, Google Code Scanner, analytics, telemetry, remote model, or runtime download dependency
- Wrap the decoder behind an internal interface so it can be replaced without changing the public Dart API

## Alternatives

- Bundled ML Kit Barcode Scanning. Not selected because ML Kit sends usage and diagnostics metrics, which conflicts with the approved analytics prohibition.
- Google Code Scanner. Not selected because it uses a downloaded Play services component and does not meet the custom UI requirement.
- Direct Camera2. Not selected because it creates unnecessary lifecycle and device-compatibility work for the walking skeleton.

## Consequences

Scanning can work offline without payload or model transmission. The package accepts maintenance risk in ZXing Core and must contain strong decoder fixtures and an abstraction boundary.

## Residual risk

Security and the human principal must approve the dependency licences. QA must test decoder accuracy and CameraX behavior on the approved device range. Maintenance mode may require a future decoder replacement.

## Evidence

- [CameraX releases](https://developer.android.com/jetpack/androidx/releases/camera)
- [ZXing repository and maintenance status](https://github.com/zxing/zxing)
- [ZXing Apache 2.0 licence](https://github.com/zxing/zxing/blob/master/LICENSE)
- [ML Kit terms and privacy](https://developers.google.com/ml-kit/terms)
- [ML Kit Android data disclosure](https://developers.google.com/ml-kit/android-data-disclosure)

