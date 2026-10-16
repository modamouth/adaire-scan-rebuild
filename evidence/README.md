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

Commit concise text or machine-readable summaries, not APKs, camera frames, decoded payloads, real personal data, secrets, keystores, generated build directories, or raw diagnostic archives.

Every evidence record must state the work item, source commit, candidate version, artifact SHA-256 when applicable, environment, method or command, synthetic-data assumption, result, limitations, reviewer or executor, and date.
