# Adaire Scan Rebuild Product Brief

**Status:** Product Owner final draft for human approval

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

## Decisions still required

- Approve the first supported Android API range.
- Approve the Flutter and Dart toolchain range.
- Approve package name, organisation namespace, version, and licence metadata.
- Approve whether the example host is purely a verification harness or a maintained sample application.
- Confirm the private distribution and signing approach before any external evaluation.

## Product acceptance criteria

The QR walking skeleton is product-acceptable only when an authorised Flutter developer can integrate it into a clean Android host from the approved guide, scan a synthetic QR value, distinguish every implemented terminal outcome, and complete or leave the scanner without a hang or duplicate result.

No acceptance statement may imply EAN-13, Code 128, iOS, public distribution, production reliability, or Android compatibility beyond the executed evidence.
