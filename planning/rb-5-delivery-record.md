# RB-5 Android QR Walking Skeleton Delivery Record

**Status:** in_progress

**Authorised:** 2026-10-16 by the human principal

**Starting baseline:** `1057d03a8193cd89979f9d979c0c06884ca8ab33`

**Owner:** Mobile implementation under Review supervision

**Reviewers:** Architect, QA, Security, UX/UI, Product Owner, and Scrum Master / Orchestrator

## Authorised scope

- QR only;
- the typed outcomes approved in ADR 0006;
- Pigeon-generated Flutter and Kotlin transport;
- CameraX 1.6.2 and ZXing Core 3.5.4;
- native Android scanner interaction;
- explicit state and exactly-once completion;
- permission, cancellation, busy, lifecycle, torch, and accessibility behavior required by the walking skeleton; and
- the minimum example and test changes needed to verify the increment.

Existing exclusions and human-only licensing, distribution, risk, external-commitment, and release decisions remain unchanged.

## Acceptance criteria

1. The Dart API accepts only a non-empty QR request and returns a sealed typed outcome without message parsing.
2. Pigeon transport rejects null, unknown, contradictory, or malformed native outcomes as a deterministic payload-free failure.
3. CameraX presents one native Android scanner surface and ZXing is configured for QR only.
4. Success, Close, Android Back, permission denial, unavailable camera, concurrent invocation, and unexpected failure complete exactly once.
5. Camera and pending references are released on completion, activity detachment, engine detachment, and background interruption; late callbacks are ignored.
6. Decoded content is inert and absent from logs, persistence, diagnostics, evidence, and network traffic.
7. The merged manifest has no Internet permission and the dependency graph contains no analytics or telemetry SDK.
8. Close and torch controls meet the accepted accessibility contract and the example restores a predictable host state.
9. Automated checks and Android builds pass before an immutable candidate is nominated for RB-6.

## Implementation sequence

1. Add pinned Pigeon, CameraX, and ZXing dependencies.
2. Define and generate the transport schema.
3. Implement Dart validation, typed outcomes, and redacted diagnostics.
4. Implement the Kotlin coordinator, decoder boundary, scanner activity, and plugin lifecycle.
5. Update the example as a synthetic private verification harness.
6. Add contract, state, decoder, and widget tests.
7. Run analysis, tests, builds, manifest and dependency checks, then freeze a candidate.

## Evidence plan

Store automated evidence under `evidence/walking-skeleton/automated/`. RB-6 will add emulator, physical-device, security-runtime, accessibility, clean-host, and final review records. Evidence must identify the exact commit and APK SHA-256 and must not retain decoded values, frames, secrets, APKs, or raw diagnostics.

## Stop and escalate

Stop affected work for scope expansion, non-QR formats, dependency or contract changes outside accepted ADRs, data egress, unresolved security or accessibility risk, production credentials, distribution, public claims, or release decisions.
