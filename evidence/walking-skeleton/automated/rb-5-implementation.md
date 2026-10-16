# RB-5 Automated Implementation Evidence

**Work item:** RB-5

**Date:** 2026-10-16

**Executor:** Mobile implementation under Review supervision

**Candidate commit:** `9df8e20c31845590437872eb4a2748a85006313d`

**Candidate version:** `0.1.0-dev.1`

**Distribution status:** private verification only; not approved for distribution

**Synthetic-data assumption:** automated decoding used only `ADAIRE-SYNTHETIC-QR-V1`; the value is not retained in committed output

## Implemented boundary

- QR-only Dart request validation and sealed typed outcomes
- Pigeon 29.0.10 generated Dart and Kotlin transport with a reproducible redaction step
- CameraX 1.6.2 preview and image analysis
- ZXing Core 3.5.4 configured only for `QR_CODE`
- native Android scanner activity with Close, Back, permission, torch, interruption, and exactly-once completion paths
- explicit `idle`, `presenting`, `scanning`, `completing`, and `detached` coordinator states
- minimal example host with on-screen outcome display and result clearing

## Automated results

| Gate | Result |
|---|---|
| Pigeon regeneration using `dart run tool/generate_pigeon.dart` | Passed; generated success stringification and transport errors remain payload-redacted |
| Package `flutter analyze` | Passed, no issues |
| Package `flutter test` | Passed, 4 tests |
| Example `flutter analyze` | Passed, no issues |
| Example `flutter test` | Passed, 1 widget test |
| Native `:adaire_scan:testDebugUnitTest` | Passed, 3 tests covering state transitions, exactly-once completion, detach/reattach, and synthetic QR decoding |
| Debug APK build | Passed |
| Release APK build | Passed; debug-signed verification output only |
| Merged manifest inspection | Camera permission and Android application-scoped receiver permission only; no Internet or network-state permission |
| Release dependency inspection | No analytics, telemetry, Crashlytics, advertising, ML Kit, or Google Play services dependency found |
| Source inspection | No application logging, printing, persistence, network API, analytics, or telemetry code found |

## Transient artifacts

The APKs are not committed.

| Artifact | Bytes | SHA-256 |
|---|---:|---|
| Debug APK | 190430202 | `0acae6130e62dbe0db041ab8b0111d2b1f99dc93b0d93ee587ba08bc1f28b347` |
| Release APK, debug-signed | 44863012 | `53df454f261e487fd570a9bdc57a2c861d1ed711aadb52661856e95784324d33` |

## Limitations and required RB-6 evidence

- No emulator or physical-device runtime execution has been performed against this candidate.
- Camera presentation, permission recovery, Close, Back, concurrent invocation, background recovery, repeated scans, and torch behavior require runtime verification.
- TalkBack order, control announcements, target sizes, text scaling, and host focus restoration require UX/UI review.
- Logs, storage, screenshots, and network traffic require runtime Security inspection.
- Clean-host integration has not been executed.
- Architect, QA, Security, UX/UI, Product Owner, and human gates have not been recorded against this candidate.

This record supports `self_verified` only. It does not complete RB-5, RB-6, Rebuild Phase 2, product acceptance, distribution, or release.
