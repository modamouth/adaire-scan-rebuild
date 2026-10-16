# ADR 0007 Use an explicit scan state machine

**Status:** accepted

**Approved:** 2026-10-16 by the human principal

**Date:** 2026-10-16

**Owners:** Architect and QA

## Proposed decision

The Android implementation owns one process-local scan coordinator with these states:

- `idle`
- `presenting`
- `scanning`
- `completing`
- `detached`

Only `idle` may start a scan. Any invocation in another active state returns `busy` without presenting another camera surface. Every terminal path passes through one atomic completion function, releases CameraX and decoder resources, clears pending references, and returns to `idle` or `detached`.

Activity or engine detachment, permission denial, explicit Close, Android Back, presentation failure, background interruption, decoder failure, and success must each terminate exactly once. Late camera or decoder callbacks after completion are ignored.

## Consequences

Concurrency and lifecycle behavior become testable as state transitions rather than incidental callbacks. The implementation must include state-transition unit tests and Android lifecycle tests.
