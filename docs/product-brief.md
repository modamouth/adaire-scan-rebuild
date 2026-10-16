# Adaire Scan Rebuild Product Brief

**Status:** approved

**Approved:** 2026-10-16 by the human principal

## Product problem

Flutter developers need a narrow Android Barcode and QR integration whose behavior is predictable across success, cancellation, permission, concurrency, and lifecycle conditions. The integration must avoid hidden payload handling and unsupported compatibility claims.

## Primary user

An authorised Flutter developer integrating a privately supplied scanner package into an Android host application.

## End-user outcome

A person can open a native scanner, understand how to align an approved barcode, control the torch where available, leave the scanner clearly, and return to the host application with a truthful outcome.

## Product principles

- Small public API before broad capability.
- Explicit outcomes instead of message parsing.
- Strict format requests instead of silent broadening.
- Inert decoded data with no automatic action.
- No logging, persistence, analytics, or network transmission of decoded values.
- Accessibility behavior is part of the contract.
- Evidence must match the exact source and artifact tested.
- Compatibility claims remain bounded to executed evidence.

## First increment

The first implementation increment is an Android QR walking skeleton. It proves clean-host integration, native presentation, typed outcomes, exactly-once completion, synthetic scanning, and a reproducible private test artifact before EAN-13 and Code 128 are added.

## Approved implementation shape

Adaire Scan uses a hybrid plugin architecture. Flutter and Dart provide the consumer-facing contract and example integration. Native Kotlin provides the Android scanner, CameraX lifecycle, decoder integration, permissions, concurrency, torch, native interface, and accessibility behavior. This does not broaden the product beyond Android or authorise implementation before the remaining entry gates pass.

## Resolved preparation decisions

- Android API 24 is the configuration floor; runtime support remains subject to executed evidence.
- Flutter 3.47.7, Dart 3.13.5, JDK 17, SDK 36, Gradle 9.3.1, Android Gradle Plugin 9.1.0, and Kotlin 2.4.0 form the verified scaffold baseline.
- The private package identity is `adaire_scan` under `com.adairetech.adaire_scan` at initial version `0.1.0-dev.1`.
- The example is a minimal verification and integration harness, not a separately supported application.

Private signing and distribution remain deferred under ADR 0011 until external evaluation is considered.

## Product acceptance criteria

The QR walking skeleton is product-acceptable only when an authorised Flutter developer can integrate it into a clean Android host from the approved guide, scan a synthetic QR value, distinguish every implemented terminal outcome, and complete or leave the scanner without a hang or duplicate result.

No acceptance statement may imply EAN-13, Code 128, iOS, public distribution, production reliability, or Android compatibility beyond the executed evidence.
