# ADR 0005 Use a standard Flutter plugin with generated transport

**Status:** proposed for human review

**Date:** 2026-10-16

**Owner:** Architect

## Proposed decision

Use one standard Flutter plugin with:

- a small public Dart API;
- internal Dart contract and validation;
- a Pigeon-generated Android host API for compile-time transport types;
- one Android implementation inside the same package; and
- no federated publication packages until another platform is authorised.

Pigeon generation must be pinned and reproducible. Generated files are committed and verified as part of the candidate.

## Alternatives

- Raw method-channel maps. Rejected because malformed keys and types are detected only at runtime.
- Federated plugin packages. Rejected because only Android is authorised.
- Platform view as the public API. Rejected because the product contract is an operation with one terminal outcome, not an embeddable camera component.

## Consequences

The public API remains independent from Android classes while transport mismatch risk is reduced. Code generation adds a build step and generated-file review obligation.

