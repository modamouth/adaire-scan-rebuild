# Legacy Evidence Inventory

**Status:** initial inventory

The legacy repository is evidence, not an implementation template. Every migrated behavior requires a product or architecture decision. No item below authorises copying source code.

## Reusable evidence

| Evidence | Legacy reference | Proposed use |
|---|---|---|
| Typed terminal outcome meanings | Adaire Scan candidate `67b254bc49ee66fc2c06301a5b8569d2d1666d2b` and agentic ADR 0011 | Input to the new public contract ADR |
| QR, EAN-13, and Code 128 product hypothesis | Phase 2 requirement ADAIRE-BQR-001 | Proposed capability sequence |
| Synthetic fixture set and manifest approach | Legacy `flutter_barcode_qr_scanner/test/fixtures/v1` | Recreate or import only after provenance and licence review |
| OPPO CPH2207 Android 13 behavior | Phase 2 physical evidence | Initial representative-device baseline, not a compatibility claim |
| Cancellation, permission, concurrency, lifecycle, torch, and TalkBack scenarios | Phase 2 QA and UX/UI readiness records | Input to the rebuild verification matrix |
| Payload redaction and inert-result boundary | Phase 2 Security and architecture records | Input to security policy and acceptance criteria |
| Clean-host requirement | ADAIRE-BQR-001 | Required rebuild gate |

## Legacy elements not automatically carried forward

- package layout and multi-scanner suite structure;
- Gradle, Kotlin, Android Gradle Plugin, or Flutter versions;
- native scanning library choice;
- method-channel implementation;
- application ID, package name, version, ownership, and publishing metadata;
- example application design;
- iOS source or support claims;
- biometric placeholders;
- licences or dependency terms; and
- compatibility assumptions.

## Required migration reviews

Before reusing any legacy asset, dependency, fixture, text, or API shape, record:

- provenance and ownership;
- licence compatibility;
- whether it is evidence, specification, or source code;
- the approving role;
- the target location; and
- any modification required for the rebuild.

