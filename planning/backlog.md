# Adaire Scan Rebuild Initial Backlog

**Status:** RB-5 self-verified; RB-6 runtime and specialist verification pending

**Phase map:** [Adaire Scan Rebuild Delivery Phases](../docs/delivery-phases.md)

The `RB-*` identifiers in this backlog remain the authoritative units for authorisation, ownership, evidence, and completion. Phase membership does not grant implementation authority.

## Preparation

### RB-0 Approve rebuild charter

**Status:** done

**Owner:** Product Owner and human principal

**Done when:** Product objective, initial scope, exclusions, authority, and entry gate are approved.

### RB-1 Approve product requirements

**Status:** done

**Owner:** Product Owner

**Done when:** User, outcome, format sequence, platform boundary, acceptance criteria, and product exclusions are approved.

### RB-2 Resolve blocking architecture decisions

**Status:** done

**Owner:** Architect with Security, QA, UX/UI, and mobile input

**Done when:** ADQ-01 through ADQ-09 have accepted ADRs and ADQ-10 is either accepted or explicitly deferred until private distribution.

### RB-3 Establish governed delivery controls

**Status:** done

**Owner:** Orchestrator

**Done when:** Work states, review gates, supervision mode, evidence locations, Definition of Done, and escalation path are recorded for this repository.

**Authorised:** 2026-10-16 by the human principal

**Prepared:** [delivery controls](../governance/delivery-controls.md), [Definition of Done](../governance/definition-of-done.md), and [evidence register](../evidence/README.md)

**Accepted:** 2026-10-16 by the Scrum Master / Orchestrator after QA review

### RB-3A Verify the selected toolchain

**Status:** done

**Owner:** Architect and DevOps

**Evidence:** [2026-10-16 toolchain spike](../evidence/toolchain/2026-10-16-spike.md)

**Outcome:** Architect adopted API 24 after Product Owner consultation. DevOps verified the resolved toolchain and removed the redundant application-owned NDK declaration. QA approved the technical result after record corrections. The remaining SDK XML warning is tracked as non-blocking toolchain debt.

## Walking skeleton

### RB-4 Scaffold the package and example

**Status:** done

**Owner:** Mobile implementation

**Authorised:** 2026-10-16 by the human principal

**Reviewers:** Architect, DevOps, and QA

**Evidence plan:** Record source revision, package version, toolchain, commands, dependency boundary, analysis, tests, debug and release builds, artifact hashes, limitations, and role decisions under `evidence/walking-skeleton/automated/` and `evidence/walking-skeleton/reviews/`.

**Candidate:** `eafdcde0ca8b364a678bbf68ad511cbd16a9cc70`

**Evidence:** [scaffold verification](../evidence/walking-skeleton/automated/rb-4-scaffold.md) and [role reviews](../evidence/walking-skeleton/reviews/rb-4-role-reviews.md)

**Depends on:** RB-0, RB-1, RB-2, RB-3

**Done when:** The selected toolchain produces a clean Android package and minimal example with no scanner behavior or unnecessary dependency.

### RB-5 Implement the Android QR walking skeleton

**Status:** self_verified

**Owner:** Mobile implementation

**Authorised:** 2026-10-16 by the human principal

**Supervision:** Review

**Delivery record:** [RB-5 delivery record](rb-5-delivery-record.md)

**Progress log:** [RB-5 worklog](worklogs/RB-5.md)

**Candidate:** `9df8e20c31845590437872eb4a2748a85006313d`

**Automated evidence:** [RB-5 implementation evidence](../evidence/walking-skeleton/automated/rb-5-implementation.md)

**Specialist reviews:** [pending candidate-bound reviews](../evidence/walking-skeleton/reviews/rb-5/README.md)

**Done when:** A synthetic QR scan produces the approved typed result, cancellation completes once, and no payload appears in logs, storage, network traffic, or default diagnostics.

### RB-6 Verify the walking skeleton

**Status:** ready for governed verification against the RB-5 candidate

**Owner:** QA with Security and UX/UI

**Done when:** Automated, clean-host, emulator, physical-device, payload-safety, and basic accessibility evidence is recorded against one immutable candidate.

## Capability completion

### RB-7 Add EAN-13 and Code 128

**Status:** deferred until the QR walking skeleton passes

### RB-8 Add filtering, permissions, concurrency, and lifecycle recovery

**Status:** deferred until the QR walking skeleton passes

### RB-9 Complete accessibility and private-evaluation documentation

**Status:** blocked on the QR candidate

### RB-10 Complete specialist reviews and Product Owner acceptance

**Status:** blocked on RB-6 and RB-9

No item after RB-3 is authorised for implementation until the preparation entry gate passes.
