# ADR 0003 Pin the initial Android toolchain

**Status:** accepted with open amendment

**Approved:** 2026-10-16 by the human principal

**Date:** 2026-10-16

**Owner:** Architect

## Context

The rebuild needs one reproducible toolchain. Compatibility must be established by execution rather than inherited from the legacy repository or described as latest.

## Proposed decision

- Flutter 3.47.7 stable
- Dart 3.13.5 supplied by that Flutter SDK
- JDK 17
- Android compile SDK 36
- Android target SDK 36
- Android minimum SDK 23
- No NDK unless a selected dependency proves it necessary
- Gradle, Android Gradle Plugin, and Kotlin versions generated or required by Flutter 3.47.7, then pinned after a clean scaffold build and dependency-resolution check

The proposed minimum SDK is 23 because the selected CameraX baseline requires API 23 or later. This configuration boundary is not yet a compatibility claim; support still requires emulator and physical-device evidence.

## Verification condition

Before acceptance, a toolchain-only spike must create an empty plugin and example, run analysis and tests, build debug and release APKs, and record every resolved version and checksum. No scanner dependency or production behavior belongs in that spike.

## Verification result

The authorised disposable spike passed package and example analysis, generated tests, and Android debug and release builds. It resolved Android Gradle Plugin 9.1.0, Kotlin 2.4.0, and Gradle 9.3.1 with JDK 17, compile SDK 36, and target SDK 36.

Flutter 3.47.7 defines API 24 as its default supported minimum. When the disposable example was changed to API 23, Flutter automatically restored `flutter.minSdkVersion`, resolving to API 24. The plugin library can declare API 23, but the selected Flutter example and host baseline cannot truthfully establish API 23 support.

The Architect recommends amending the approved minimum from API 23 to API 24. This material compatibility change requires human approval before ADR 0003 verification can close.

## Consequences

The project can begin from already available, previously exercised Flutter and JDK installations while refusing unverified broad compatibility claims.

## Residual risk

The build emitted an SDK XML version warning indicating that the installed Android command-line tooling and SDK metadata generations differ. Both builds passed, but the command-line tooling should be aligned or the warning explicitly accepted before RB-4.

The generated example declares Flutter's NDK version even though the empty plugin has no native dependency. RB-4 must verify whether this declaration can be removed without affecting the build, consistent with the no-unnecessary-NDK decision.

## Evidence

- [Flutter Android build configuration](https://docs.flutter.dev/deployment/android)
- [Toolchain spike evidence](../evidence/toolchain/2026-10-16-spike.md)
