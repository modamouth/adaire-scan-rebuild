# ADR 0003 Pin the initial Android toolchain

**Status:** accepted and verified

**Approved:** 2026-10-16 by the human principal

**Date:** 2026-10-16

**Owner:** Architect

## Context

The rebuild needs one reproducible toolchain. Compatibility must be established by execution rather than inherited from the legacy repository or described as latest.

## Decision

- Flutter 3.47.7 stable
- Dart 3.13.5 supplied by that Flutter SDK
- JDK 17
- Android compile SDK 36
- Android target SDK 36
- Android minimum SDK 24
- Gradle 9.3.1
- Android Gradle Plugin 9.1.0
- Kotlin Android plugin 2.4.0
- No application-owned NDK declaration unless a selected dependency proves it necessary

API 24 is the configuration floor established by the selected Flutter host baseline. It is not yet a runtime compatibility claim; support still requires emulator and physical-device evidence.

## Verification condition

Before acceptance, a toolchain-only spike must create an empty plugin and example, run analysis and tests, build debug and release APKs, and record every resolved version and checksum. No scanner dependency or production behavior belongs in that spike.

## Verification result

The authorised disposable spike passed package and example analysis, generated tests, and Android debug and release builds. It resolved Android Gradle Plugin 9.1.0, Kotlin 2.4.0, and Gradle 9.3.1 with JDK 17, compile SDK 36, target SDK 36, and minimum SDK 24.

Flutter 3.47.7 defines API 24 as its default supported minimum. When the disposable example was changed to API 23, Flutter automatically restored `flutter.minSdkVersion`, resolving to API 24. The plugin library can declare API 23, but the selected Flutter example and host baseline cannot truthfully establish API 23 support.

The Architect adopted API 24 under system-architecture authority after the Product Owner confirmed that it preserves the approved outcome and scope. No validated product need for API 23 exists.

DevOps removed the application-owned `ndkVersion` declaration and both builds passed. Flutter and the Android Gradle Plugin still select their internal native toolchain, which is distinct from an application-owned NDK requirement.

## Consequences

The project can begin from already available, previously exercised Flutter and JDK installations while refusing unverified broad compatibility claims.

## Residual risk

The first clean Gradle build per daemon emits an SDK XML version warning from resolved `com.android.tools:repository:32.1.0`, whose parser understands XML through version 3 while version 4 metadata is present. Command-line tools 23.0, analysis, tests, and both APK builds pass. QA classifies this as non-blocking DevOps toolchain debt to reassess on the next Flutter or Android Gradle Plugin upgrade.

API 24 runtime behavior remains unverified. The walking-skeleton test matrix must include an API 24 emulator before making a minimum-version support claim.

## Evidence

- [Flutter Android build configuration](https://docs.flutter.dev/deployment/android)
- [Toolchain spike evidence](../evidence/toolchain/2026-10-16-spike.md)
