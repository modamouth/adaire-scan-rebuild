# ADR 0003 Pin the initial Android toolchain

**Status:** proposed with verification condition

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

## Consequences

The project can begin from already available, previously exercised Flutter and JDK installations while refusing unverified broad compatibility claims.

## Residual risk

Generated Android build versions may produce deprecation warnings or incompatibility. If so, the Architect must revise this proposal before RB-4.

## Evidence

- [Flutter Android build configuration](https://docs.flutter.dev/deployment/android)
