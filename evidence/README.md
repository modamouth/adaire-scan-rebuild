# Evidence Register

Evidence is organised by governed work item:

- `evidence/toolchain/` for the disposable toolchain spike;
- `evidence/walking-skeleton/automated/` for analysis and automated tests;
- `evidence/walking-skeleton/emulator/` for emulator checks;
- `evidence/walking-skeleton/device/` for physical-device checks;
- `evidence/walking-skeleton/security/` for dependency, manifest, log, storage, and network inspection;
- `evidence/walking-skeleton/accessibility/` for UX/UI and TalkBack review;
- `evidence/walking-skeleton/integration/` for independent clean-host integration; and
- `evidence/walking-skeleton/reviews/` for specialist and Product Owner decisions.

Active progress and role-to-role handoffs are recorded separately under `planning/worklogs/`. Worklogs do not constitute evidence approval. Review decisions are candidate-bound and remain `pending` until the named role completes its review.

Commit concise text or machine-readable summaries, not APKs, camera frames, decoded payloads, real personal data, secrets, keystores, generated build directories, or raw diagnostic archives.

Every evidence record must state the work item, source commit, candidate version, artifact SHA-256 when applicable, environment, method or command, synthetic-data assumption, result, limitations, reviewer or executor, and date.

## Recorded work

- RB-3A: [toolchain spike](toolchain/2026-10-16-spike.md) and [role reviews](toolchain/2026-10-16-role-reviews.md)
- RB-4: [scaffold verification](walking-skeleton/automated/rb-4-scaffold.md) and [role reviews](walking-skeleton/reviews/rb-4-role-reviews.md)
- RB-5: [automated implementation evidence](walking-skeleton/automated/rb-5-implementation.md), [progress and handoff log](../planning/worklogs/RB-5.md), and [pending candidate reviews](walking-skeleton/reviews/rb-5/README.md); runtime and specialist verification remain pending under RB-6
