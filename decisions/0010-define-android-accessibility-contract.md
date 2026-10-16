# ADR 0010 Define the Android accessibility contract

**Status:** accepted

**Approved:** 2026-10-16 by the human principal

**Date:** 2026-10-16

**Owners:** UX UI and Architect

## Proposed decision

Use a native Android Views scanner surface with CameraX `PreviewView` and standard accessible controls.

The scanner must provide:

- a visible Close control with a stable accessible name;
- a torch control whose label describes the available action and whose state is not communicated by colour alone;
- minimum 48 dp interactive targets;
- guidance naming the approved format and the nonvisual limitation of camera alignment;
- predictable TalkBack order;
- Android Back behavior equivalent to explicit cancellation;
- host focus restoration after completion; and
- text scaling without clipping essential controls.

The camera image itself is not represented as accessible content. Documentation must state that independent nonvisual alignment is limited and that host applications may need an assisted workflow.

## Consequences

Accessibility is an acceptance boundary, not example polish. UX/UI review and TalkBack evidence are mandatory for the walking skeleton.
