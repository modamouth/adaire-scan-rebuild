# Adaire Scan Rebuild Requirements

**Status:** Product Owner final draft for human approval

## Approved product boundary

- Barcode and QR is the first rebuilt product.
- The initial platform is Android only.
- Distribution remains private only.
- The walking skeleton supports QR only.
- EAN-13 and Code 128 require a later gate after the walking skeleton passes.
- Legacy implementation code, biometrics, other scanner packages, iOS, backend services, analytics, payload transmission, public release, and external commitments are excluded.

## R1 Reproducible identity

Every candidate must identify its source commit, package version, toolchain, Android metadata, dependencies, build commands, artifact hash, and distribution status.

## R2 Typed terminal outcomes

The host must distinguish success, explicit cancellation, permission denial, scanner unavailability, concurrent invocation, and unexpected failure without parsing human-readable messages.

## R3 Bounded format support

The package must publish an explicit supported format set. Empty, unsupported, or mixed-invalid requests must not launch or silently broaden scanning.

## R4 Payload safety

Decoded content must be returned only as inert result data. It must not be logged, persisted, transmitted, placed in filenames, included in default stringification, or retained in evidence.

## R5 Exactly-once completion

Every scan attempt must complete once under success, cancellation, permission changes, busy state, presentation failure, backgrounding, activity detachment, engine detachment, and unexpected native results.

## R6 Android usability and accessibility

The scanner must provide an obvious accessible exit, meaningful control labels, adequate targets, non-colour state cues, truthful torch behavior, predictable host return, and documented nonvisual alignment limitations.

## R7 Clean-host integration

An independent developer must be able to integrate the candidate into a clean Flutter Android host using only approved documentation.

## R8 Evidence integrity

Automated, emulator, physical-device, accessibility, security, and integration evidence must identify the exact candidate and its limitations. Evidence from a different revision may not silently satisfy the current gate.

## R9 Compatibility restraint

The project may claim support only for environments established by executed evidence. Android 13 evidence does not establish the minimum supported Android version or broad device compatibility.

## R10 Release separation

Implementation, self-verification, independent review, product acceptance, private-distribution approval, and public release must remain distinct states.

## Walking skeleton acceptance criteria

1. A clean, pinned toolchain creates and builds the package and example reproducibly.
2. The public Dart API exposes typed QR success, explicit cancellation, permission denial, unavailability, busy, and unexpected failure outcomes.
3. The Android transport rejects malformed or contradictory results without exposing arbitrary native content.
4. A synthetic QR fixture decodes successfully on the approved emulator and OPPO CPH2207 Android 13.
5. Explicit Close, Android Back, first and repeated permission denial, recovery after permission grant, repeated scans, concurrent invocation, and background or foreground recovery each complete exactly once.
6. The QR-only request cannot broaden to another format.
7. Decoded content appears only in the explicit success result and is absent from logs, diagnostics, default stringification, files, preferences, databases, screenshots retained as evidence, and network traffic.
8. The package and test host declare no Internet permission and contain no analytics or telemetry SDK.
9. TalkBack identifies the exit and torch controls, announces state without relying on colour, and returns predictably to the host.
10. An independent clean host integrates from approved documentation without undocumented repository knowledge.
11. Architect, QA, Security, UX/UI, Product Owner, and required human gates are recorded against one immutable candidate.

## Later capability gate

EAN-13 and Code 128 may enter implementation only after all walking-skeleton criteria pass and the Product Owner approves the next increment. Their addition must not silently broaden QR requests or weaken the security and accessibility contract.
