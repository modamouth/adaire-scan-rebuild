# Adaire Scan Rebuild

This repository is the clean rebuild workspace for Adaire Scan.

## Current stage

The repository is in preparation. Do not add production implementation until the rebuild charter, product requirements, architecture decisions, and walking-skeleton acceptance criteria are approved.

## Governing boundaries

- Treat `/Users/luthando/adaire-scan` as legacy reference evidence, not a source tree to copy.
- Preserve provenance when a legacy behavior, requirement, fixture, or lesson informs the rebuild.
- Do not copy legacy implementation code without an explicit, recorded decision.
- Android is the approved first platform. iOS remains outside the initial rebuild unless separately approved.
- Public distribution, external commitments, biometrics, and unrelated scanner packages remain outside scope unless separately approved.
- Use synthetic barcode values in tests and evidence.
- Never log, persist, transmit, or include decoded values in default diagnostics or stringification.
- Human approval is required for licensing, distribution, risk acceptance, external commitments, and production release.

## Before implementation

Read:

1. `docs/rebuild-charter.md`
2. `docs/product-brief.md`
3. `docs/requirements/rebuild-requirements.md`
4. `docs/architecture/decision-queue.md`
5. `docs/migration/legacy-inventory.md`
6. `planning/backlog.md`

Confirm that the work item is approved and that its acceptance criteria and relevant architecture decisions are resolved.

## Completion discipline

Do not represent work as complete without executed evidence. Keep implemented, self-verified, independently reviewed, product accepted, privately distributable, and publicly released as separate states.
