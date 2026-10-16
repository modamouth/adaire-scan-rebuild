# ADR 0002 Define package identity and repository layout

**Status:** proposed for human review

**Date:** 2026-10-16

**Owner:** Architect

## Context

The rebuild needs an identity that does not inherit contradictory legacy publishing metadata or imply public availability.

## Proposed decision

- Dart package name: `adaire_scan`
- Android namespace: `com.adairetech.adaire_scan`
- Initial version: `0.1.0-dev.1`
- Pub publication: disabled with `publish_to: none`
- Licence field: private and unlicensed for redistribution until the human principal records a licensing decision
- Layout: one standard Flutter plugin at the repository root, one minimal `example/` verification host, `docs/`, `decisions/`, `test/`, and platform tests under `android/`

Do not create separate packages for platform interface, Android implementation, fixtures, or the example until evidence demonstrates a real maintenance boundary.

## Alternatives

- Reuse the legacy package name. Rejected because it risks confusing rebuilt and legacy candidates.
- Start with a federated multi-package layout. Rejected because only Android is authorised and the extra publication boundaries provide no current value.

## Consequences

The first repository structure remains small. A future rename or public publication requires a separate compatibility and licensing decision.

## Residual risk

The human principal must confirm the final package name, namespace, and licensing label before acceptance.

