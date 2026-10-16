# Adaire Scan Rebuild Initial Backlog

**Status:** preparation in progress

## Preparation

### RB-0 Approve rebuild charter

**Status:** done

**Owner:** Product Owner and human principal

**Done when:** Product objective, initial scope, exclusions, authority, and entry gate are approved.

### RB-1 Approve product requirements

**Status:** review

**Owner:** Product Owner

**Done when:** User, outcome, format sequence, platform boundary, acceptance criteria, and product exclusions are approved.

### RB-2 Resolve blocking architecture decisions

**Status:** review

**Owner:** Architect with Security, QA, UX/UI, and mobile input

**Done when:** ADQ-01 through ADQ-09 have accepted ADRs and ADQ-10 is either accepted or explicitly deferred until private distribution.

### RB-3 Establish governed delivery controls

**Status:** not started

**Owner:** Orchestrator

**Done when:** Work states, review gates, supervision mode, evidence locations, Definition of Done, and escalation path are recorded for this repository.

## Walking skeleton

### RB-4 Scaffold the package and example

**Owner:** Mobile implementation

**Depends on:** RB-0, RB-1, RB-2, RB-3

**Done when:** The selected toolchain produces a clean Android package and minimal example with no scanner behavior or unnecessary dependency.

### RB-5 Implement the Android QR walking skeleton

**Owner:** Mobile implementation

**Done when:** A synthetic QR scan produces the approved typed result, cancellation completes once, and no payload appears in logs, storage, network traffic, or default diagnostics.

### RB-6 Verify the walking skeleton

**Owner:** QA with Security and UX/UI

**Done when:** Automated, clean-host, emulator, physical-device, payload-safety, and basic accessibility evidence is recorded against one immutable candidate.

## Capability completion

### RB-7 Add EAN-13 and Code 128

### RB-8 Add filtering, permissions, concurrency, and lifecycle recovery

### RB-9 Complete accessibility and private-evaluation documentation

### RB-10 Complete specialist reviews and Product Owner acceptance

No item after RB-3 is authorised for implementation until the preparation entry gate passes.
