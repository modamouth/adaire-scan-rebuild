# Adaire Scan Rebuild Requirements

**Status:** proposed for review

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

