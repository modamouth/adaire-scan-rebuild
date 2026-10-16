# RB-4 Scaffold Verification

**Work item:** RB-4

**Date:** 2026-10-16

**Executor:** Mobile implementation under Review supervision

**Candidate commit:** `eafdcde0ca8b364a678bbf68ad511cbd16a9cc70`

**Candidate version:** `0.1.0-dev.1`

**Distribution status:** private verification only; not approved for distribution

**Synthetic-data assumption:** no barcode value, camera frame, or user data was used because RB-4 contains no scanner behavior

## Environment

- macOS 26.6.2, Darwin arm64
- Flutter 3.47.7 stable, framework `abaf9c5237`
- Dart 3.13.5
- JDK 17.0.20.1
- Android compile SDK 36, target SDK 36, minimum SDK 24
- Gradle 9.3.1
- Android Gradle Plugin 9.1.0
- Kotlin Android plugin 2.4.0
- Gradle wrapper SHA-256: `16caeaf66d57a0d1d2087fef6a97efa62de8da69afa5b908f40db35afc4342da`

## Commands and results

| Gate | Command | Result |
|---|---|---|
| Package dependencies | `flutter pub get` | Passed; lockfile updated without `plugin_platform_interface` |
| Package analysis | `flutter analyze` | Passed, no issues |
| Package test | `flutter test` | Passed, 1 test |
| Example analysis | `flutter analyze` in `example/` | Passed, no issues |
| Example widget test | `flutter test` in `example/` | Passed, 1 test |
| Native test lifecycle | `./gradlew test` in `example/android/` with the pinned JDK and SDK | Passed; no native behavior exists, so native unit-test tasks contained no test sources |
| Debug build | `flutter build apk --debug --no-pub` | Passed |
| Release build | `flutter build apk --release --no-pub` | Passed; debug-signed verification artifact only |
| Manifest inspection | Android build-tools 36 `aapt dump permissions` on both APKs | No Internet or camera permission; only the generated application-scoped dynamic-receiver permission |
| Dependency inspection | Gradle `releaseRuntimeClasspath` search | No CameraX, ZXing, analytics, or telemetry dependency found |

## Artifact observations

The APKs are transient verification outputs and are not committed.

| Artifact | Bytes | SHA-256 |
|---|---:|---|
| Debug APK | 150291624 | `caa0f82e9dbb6820e83ac87efc4cefbb77f937a9be82e7a107bf4276e17b26c2` |
| Release APK, debug-signed | 42987826 | `9873a94c200e046bb1bf3ca0b47af6e5fb06f5d43244e0cfdcfefb8bab0ac687` |
| Package `pubspec.lock` | not applicable | `a2ae92f928d60d2390a7291ddd8f516941fe88d5abd70056fc17098e593e3c67` |
| Example `pubspec.lock` | not applicable | `49d9cc601c4bbdf9e4a5f3fe02a4e57d22190daa6caa4da9f233a760143581c0` |

## Scope findings

- The repository contains one Flutter plugin and one Android example.
- The namespace is `com.adairetech.adaire_scan`; the example application ID is `com.adairetech.adaire_scan_example`.
- The package exports no runtime operation. The Kotlin plugin only registers and detaches.
- Flutter's generated raw method-channel example was removed because ADR 0005 requires generated transport for the later runtime contract.
- The generated development Internet manifests, platform-version behavior, integration-test plugin, Cupertino dependency, and application-owned NDK declaration were removed as unnecessary for RB-4.
- No legacy implementation source or asset was copied.

## Limitations and residual debt

- This evidence establishes scaffold buildability, not QR behavior, runtime API 24 support, device compatibility, accessibility, payload safety at runtime, or clean-host integration.
- The release APK uses debug signing and is not distributable. Signing remains deferred under ADR 0011.
- Gradle reports the Flutter toolchain's transitional built-in-Kotlin compatibility flags and Kotlin plugin use as deprecated for a future AGP 10 migration. The accepted AGP 9.1.0 and Kotlin 2.4.0 baseline still builds successfully.
- No emulator or physical-device execution was required or performed for RB-4.
