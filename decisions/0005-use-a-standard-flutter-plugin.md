# ADR 0005 Use a standard Flutter plugin with generated transport

**Status:** accepted

**Date:** 2026-10-16

**Owner:** Architect

**Approved by:** human principal on 2026-10-16

## Decision

Use one standard Flutter plugin with:

- a small public Dart API;
- internal Dart contract and validation;
- a Pigeon-generated Android host API for compile-time transport types;
- one Android implementation inside the same package; and
- no federated publication packages until another platform is authorised.

The Flutter and Dart layer is the consumer-facing integration contract, not the scanner implementation. Kotlin owns the Android camera pipeline, decoder integration, permissions, lifecycle and concurrency control, torch behavior, native scanner interface, and Android accessibility behavior.

The Android scanner should maintain an internal Kotlin boundary that can be tested without Flutter transport and could support a native Android adapter later. A native Android application or separately distributed Android library is not part of the current product scope.

Pigeon generation must be pinned and reproducible. Generated files are committed and verified as part of the candidate.

## Alternatives

- Raw method-channel maps. Rejected because malformed keys and types are detected only at runtime.
- Federated plugin packages. Rejected because only Android is authorised.
- Platform view as the public API. Rejected because the product contract is an operation with one terminal outcome, not an embeddable camera component.

## Consequences

The public API remains independent from Android classes while transport mismatch risk is reduced. Code generation adds a build step and generated-file review obligation.

Flutter applications receive an idiomatic Dart API while camera-sensitive behavior remains in the Android runtime where CameraX and lifecycle APIs are native. This decision does not authorise iOS, Kotlin Multiplatform, React Native, Capacitor, backend services, or production implementation.
