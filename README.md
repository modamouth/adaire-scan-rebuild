# Adaire Scan Rebuild

Adaire Scan Rebuild is a governed, clean-room rebuild of the Adaire Scan Barcode and QR capability. It is designed as a small, predictable, privacy-conscious Android integration for Flutter developers without inheriting the legacy implementation structure or dependency graph.

## Current status

**RB-4 is complete. RB-5 is ready but not authorised.**

The repository currently contains a verified Android-only Flutter plugin scaffold and minimal example application. It does not contain camera access, barcode decoding, scanner screens, or a callable scan API.

The RB-4 candidate is commit `eafdcde0ca8b364a678bbf68ad511cbd16a9cc70`. Package and example analysis, tests, native Gradle lifecycle, debug build, release build, manifest inspection, and dependency inspection passed against that candidate.

See the [RB-4 verification record](evidence/walking-skeleton/automated/rb-4-scaffold.md) and [role reviews](evidence/walking-skeleton/reviews/rb-4-role-reviews.md).

## Product boundary

The approved product shape is a hybrid plugin:

- Flutter and Dart provide the future consumer-facing contract and example integration.
- Native Kotlin will own the Android scanner, CameraX lifecycle, decoder integration, permissions, concurrency, torch, native interface, and accessibility behavior.
- QR is the first authorised format once RB-5 begins.
- EAN-13 and Code 128 remain gated until the QR walking skeleton passes.

The following remain excluded unless separately approved:

- iOS implementation or compatibility claims;
- legacy implementation code;
- biometrics and other scanner packages;
- backend services, analytics, telemetry, storage, or payload transmission;
- public distribution, public support, production release, or external commitments; and
- real personal, payment, identity, employee, or customer data in testing or evidence.

## RB-4 scaffold

The current scaffold establishes:

- package name `adaire_scan`;
- Android namespace `com.adairetech.adaire_scan`;
- private version `0.1.0-dev.1` with pub publication disabled;
- one Flutter plugin and one Android example host;
- Flutter 3.47.7 and Dart 3.13.5;
- JDK 17, compile and target SDK 36, and minimum SDK 24;
- Gradle 9.3.1, Android Gradle Plugin 9.1.0, and Kotlin 2.4.0;
- committed dependency lockfiles and Gradle wrapper; and
- no CameraX, ZXing, analytics, telemetry, Internet permission, or application-owned NDK declaration.

RB-4 intentionally exports no runtime operation. The accepted typed scan contract and generated Pigeon transport belong to RB-5.

## Repository layout

```text
android/       Android plugin registration shell
example/       Minimal Android verification host
lib/           Flutter package entry point
test/          Package scaffold tests
docs/          Charter, product, requirements, architecture, and migration records
decisions/     Architecture decision records
governance/    Delivery controls and Definition of Done
planning/      Governed delivery backlog
evidence/      Executed verification and role-review records
```

## Local verification

Use the pinned Flutter 3.47.7 toolchain and JDK 17 baseline.

```bash
flutter pub get
flutter analyze
flutter test

cd example
flutter pub get
flutter analyze
flutter test
flutter build apk --debug --no-pub
flutter build apk --release --no-pub
```

Generated APKs are private verification artifacts. They are ignored by Git, use no approved private-release signing process, and must not be distributed.

## Governance and evidence

Before changing implementation, read [AGENTS.md](AGENTS.md), the [rebuild charter](docs/rebuild-charter.md), [product brief](docs/product-brief.md), [requirements](docs/requirements/rebuild-requirements.md), [architecture queue](docs/architecture/decision-queue.md), [delivery controls](governance/delivery-controls.md), and [Definition of Done](governance/definition-of-done.md).

Implementation, self-verification, specialist review, product acceptance, private distribution, and public release are separate states. Evidence must identify the exact candidate commit and may not include decoded values, camera frames, real data, secrets, keystores, APKs, or transient build output.

The legacy Adaire Scan repository is an evidence source only. No legacy source, fixture, dependency, metadata, or behavior is carried forward without an explicit provenance and approval record.

## Delivery sequence

1. Rebuild charter and product scope: completed.
2. Product requirements and blocking architecture decisions: completed.
3. RB-3 delivery controls and toolchain verification: completed.
4. RB-4 package and Android example scaffold: completed.
5. RB-5 Android QR walking skeleton: awaiting explicit human authorisation.
6. RB-6 walking-skeleton verification: blocked on RB-5.
7. EAN-13, Code 128, broader lifecycle behavior, and private-evaluation readiness: deferred until the QR gate passes.
