# ADR 0009 Use layered verification with synthetic fixtures

**Status:** proposed for QA review

**Date:** 2026-10-16

**Owner:** QA

## Proposed decision

Use independently generated synthetic fixtures with a versioned manifest containing format, non-sensitive fixture identifier, generator version, dimensions, and SHA-256 hash.

Verification layers are:

1. Dart contract and validation tests.
2. Generated transport tests.
3. Android state-machine and decoder unit tests.
4. Android instrumentation tests for activity, permission, lifecycle, and resource release.
5. Example widget tests.
6. Clean-host integration.
7. Emulator tests for deterministic platform behavior.
8. OPPO CPH2207 Android 13 physical checks for camera, torch, accessibility, and lifecycle.
9. Security inspection of manifest, dependencies, logs, storage, and network.

All mandatory evidence for a gate must identify one source commit and artifact hash. Legacy fixtures may be recreated from specifications but must not be copied until provenance and licence review passes.

## Consequences

The project gains reproducible evidence without retaining real values. Physical Android 13 evidence remains bounded and does not establish broad compatibility.

