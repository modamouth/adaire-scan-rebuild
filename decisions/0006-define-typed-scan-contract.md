# ADR 0006 Define the typed scan contract

**Status:** accepted

**Approved:** 2026-10-16 by the human principal

**Date:** 2026-10-16

**Owners:** Product Owner and Architect

## Proposed decision

Expose one asynchronous `scan` operation and a sealed Dart outcome family:

- `ScanSuccess`, containing an inert value and approved format;
- `ScanCancelled`;
- `ScanPermissionDenied`;
- `ScanUnavailable`, containing an allowlisted diagnostic code;
- `ScanBusy`; and
- `ScanFailure`, containing an allowlisted diagnostic code.

The walking skeleton accepts only QR. Empty or unsupported format requests fail before camera presentation. Success requires a non-empty value and an approved format. Unknown, null, contradictory, or malformed native responses become a deterministic payload-free failure.

Default `toString`, exceptions, diagnostics, equality helpers, and evidence must redact the decoded value.

## Consequences

Hosts can respond to terminal states without parsing messages. Adding EAN-13 or Code 128 later extends an approved format enum but does not change terminal outcome meaning.
