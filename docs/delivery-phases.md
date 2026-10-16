# Adaire Scan Rebuild Delivery Phases

**Status:** active delivery map

**Established:** 2026-10-16

**Owner:** Scrum Master / Orchestrator

## Purpose

This document groups the governed `RB-*` work items into roadmap phases. The work-item identifiers remain the authoritative units for authorisation, ownership, implementation state, evidence, review, and completion.

A phase name is a planning aid. Entering a phase, completing the preceding phase, or marking a work item `ready` does not authorise implementation. Every implementation increment still requires the entry gate in the [delivery controls](../governance/delivery-controls.md), including explicit human authorisation for the exact work item.

These rebuild phases are specific to the Adaire Scan rebuild. They are not the supervision or autonomy pilot phases used by the Agentic Dev Team governance repository.

## Phase map

| Rebuild phase | Work items | Current status | Outcome |
|---|---|---|---|
| Phase 0: Foundation and governance | RB-0, RB-1, RB-2, RB-3, RB-3A | Complete | Approved product boundary, architecture, controls, and verified toolchain |
| Phase 1: Buildable scaffold | RB-4 | Complete | Android-only Flutter plugin and example build reproducibly without scanner behavior |
| Phase 2: QR walking skeleton | RB-5, RB-6 | Awaiting RB-5 authorisation | One end-to-end QR path with typed outcomes, exactly-once completion, and governed evidence |
| Phase 3: Capability completion | RB-7, RB-8 | Deferred | Add approved barcode formats and complete operational edge-case behavior |
| Phase 4: Private-evaluation readiness | RB-9, RB-10 | Blocked | Complete accessibility, documentation, reviews, and Product Owner acceptance |
| Post-delivery distribution decision | No work items approved | Not defined or authorised | Decide whether any private distribution, external evaluation, or later public-release programme should exist |

## Phase 0: Foundation and governance

### Objective

Establish the product, authority, architecture, delivery controls, and executable toolchain before production implementation begins.

### Work items

- RB-0: approve the rebuild charter;
- RB-1: approve product requirements;
- RB-2: resolve blocking architecture decisions;
- RB-3: establish governed delivery controls; and
- RB-3A: verify the selected toolchain.

### Primary roles

Product Owner, Scrum Master / Orchestrator, Architect, DevOps, QA, Security, UX/UI, mobile implementation, and the human principal participate only where their mandates apply.

### Exit gate

- Product intent, scope, exclusions, and acceptance criteria are approved.
- Blocking ADRs are accepted or explicitly deferred.
- Supervision, evidence, review, escalation, and Definition of Done controls are recorded.
- The pinned Flutter, Dart, JDK, Android, Gradle, Android Gradle Plugin, and Kotlin baseline passes the authorised toolchain spike.

### Status

Complete. The authoritative records are the [rebuild charter](rebuild-charter.md), [product brief](product-brief.md), [requirements](requirements/rebuild-requirements.md), accepted [decisions](../decisions/), [delivery controls](../governance/delivery-controls.md), and [toolchain evidence](../evidence/toolchain/2026-10-16-spike.md).

## Phase 1: Buildable scaffold

### Objective

Create the smallest production repository structure that proves the approved Android-only Flutter and Kotlin baseline builds without introducing scanner behavior prematurely.

### Work item

- RB-4: scaffold the package and example.

### Primary roles

- Mobile implementation owns the scaffold.
- Architect reviews package structure and ADR conformance.
- DevOps reviews toolchain reproducibility and build outputs.
- QA reviews gate and evidence adequacy.
- Scrum Master / Orchestrator coordinates the work and state transition.

### Exit gate

- One `adaire_scan` Flutter plugin and one Android example exist.
- Package and example analysis and tests pass.
- Native Gradle verification and debug and release APK builds pass.
- Lockfiles and the Gradle wrapper are committed.
- No scanner operation, CameraX, ZXing, analytics, telemetry, Internet permission, or application-owned NDK declaration is introduced.
- Evidence and role decisions identify one immutable candidate.

### Status

Complete against candidate `eafdcde0ca8b364a678bbf68ad511cbd16a9cc70`. See the [RB-4 verification record](../evidence/walking-skeleton/automated/rb-4-scaffold.md) and [role reviews](../evidence/walking-skeleton/reviews/rb-4-role-reviews.md).

## Phase 2: QR walking skeleton

### Objective

Prove one narrow, end-to-end Android QR scan path before adding formats or broader operational behavior.

### Work items

- RB-5: implement the Android QR walking skeleton; and
- RB-6: verify the walking skeleton.

### Primary roles

- Mobile implementation owns code under Review supervision.
- Architect reviews architecture and typed-contract conformance.
- QA owns the verification strategy and evidence adequacy.
- Security reviews dependencies, permissions, payload handling, logs, storage, diagnostics, and network behavior.
- UX/UI reviews scanner interaction and accessibility.
- Product Owner performs product acceptance.
- Scrum Master / Orchestrator coordinates sequencing and gates.
- The human principal retains risk, licensing, distribution, external-commitment, and release decisions.

### Entry gate

- RB-4 is complete.
- RB-5 has recorded acceptance criteria, owner, reviewer set, evidence plan, and no blocking escalation.
- The human principal explicitly authorises RB-5 implementation.

### Exit gate

Every applicable walking-skeleton criterion in the [requirements](requirements/rebuild-requirements.md) and [Definition of Done](../governance/definition-of-done.md) is evidenced against one immutable candidate. This includes synthetic QR success, typed terminal outcomes, exactly-once completion, strict QR-only behavior, payload safety, manifest and dependency inspection, emulator and OPPO evidence, accessibility review, and clean-host integration.

### Status

RB-5 is `ready` but not authorised. RB-6 remains blocked on an RB-5 candidate. Phase 2 has therefore not started.

## Phase 3: Capability completion

### Objective

Extend the verified QR foundation without weakening its contract, privacy controls, or lifecycle guarantees.

### Work items

- RB-7: add EAN-13 and Code 128; and
- RB-8: add filtering, permission, concurrency, and lifecycle recovery behavior not completed by the walking skeleton.

### Entry gate

- Phase 2 passes its exit gate.
- Product Owner approves the next capability increment.
- Each work item receives explicit governed authorisation.

### Exit gate

- QR requests cannot silently broaden to another format.
- EAN-13 and Code 128 meet approved product and technical criteria.
- Empty, invalid, unsupported, concurrent, permission, background, foreground, detachment, and recovery paths complete deterministically and exactly once.
- Automated and runtime evidence remains tied to one immutable candidate.

### Status

Deferred. No Phase 3 implementation is authorised.

## Phase 4: Private-evaluation readiness

### Objective

Turn an implemented and verified scanner candidate into a product-accepted package that is ready for a separate human decision about private evaluation.

### Work items

- RB-9: complete accessibility and private-evaluation documentation; and
- RB-10: complete specialist reviews and Product Owner acceptance.

### Entry gate

- Required Phase 2 and Phase 3 capabilities are implemented and verified.
- One immutable candidate is nominated for final review.

### Exit gate

- Accessibility and integration documentation are complete.
- Architect, QA, Security, UX/UI, and Product Owner decisions identify the same candidate and artifacts.
- Known limitations, residual risks, supported environments, and unsupported claims are explicit.
- Product acceptance is recorded separately from distribution and release.

### Status

Blocked on the QR candidate and its verification evidence.

## Post-delivery distribution decision

Private distribution, external evaluation, public publication, production support, and public release are not an authorised rebuild phase. ADR 0011 defers signing and distribution.

If the human principal later chooses to consider distribution, the team must first define new work items, acceptance criteria, signing and artifact-retention controls, reviewer responsibilities, support boundaries, and explicit human gates. Completion of Phase 4 does not make distribution automatic.

## Phase transition rules

1. The Scrum Master / Orchestrator reports whether phase entry conditions are met.
2. The Product Owner confirms product scope and acceptance criteria where product meaning changes.
3. Required specialists record concerns, evidence requirements, and blocking decisions within their mandates.
4. The human principal provides any implementation, risk, licensing, distribution, external-commitment, or release authorisation reserved by governance.
5. The exact `RB-*` item moves through the work states defined in the delivery controls.
6. A phase is complete only when every included work item meets its applicable Definition of Done and durable evidence is linked from the backlog.
7. Completing one phase makes the next phase eligible for entry review; it does not authorise it.
