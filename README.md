# Adaire Scan Rebuild

Adaire Scan Rebuild is a clean workspace for redesigning the Adaire Scan Barcode and QR capability without inheriting the legacy implementation structure or dependency graph.

The rebuild charter, product requirements, blocking architecture decisions, governed delivery controls, and pinned toolchain are approved. RB-4 is the authorised scaffold increment. It establishes the Android-only Flutter plugin and example without scanner behavior.

The approved implementation shape is hybrid: a small Flutter and Dart package interface backed by a native Kotlin Android scanner. Flutter is the consumer integration layer, not the camera implementation.

RB-3 delivery controls are accepted and the toolchain is verified with Android API 24 as the configuration floor. Scanner behavior remains separately gated under RB-5.

## Why rebuild

The legacy pilot established useful behavior and device evidence, but it also exposed the cost of repairing an existing multi-package structure while trying to establish a narrow, trustworthy Android scanning product. The rebuild will preserve validated requirements and lessons while making every code, dependency, and compatibility decision explicit.

The legacy repository at `/Users/luthando/adaire-scan` remains the evidence source. It is not a code template for this repository.

## Preparation documents

- [Rebuild charter](docs/rebuild-charter.md)
- [Product brief](docs/product-brief.md)
- [Rebuild requirements](docs/requirements/rebuild-requirements.md)
- [Architecture decision queue](docs/architecture/decision-queue.md)
- [Requirements and architecture review pack](docs/architecture/review-pack.md)
- [Legacy evidence inventory](docs/migration/legacy-inventory.md)
- [Initial backlog](planning/backlog.md)
- [Decision record template](decisions/0000-template.md)

## Approved delivery sequence

1. Approve product scope and exclusions. Completed.
2. Approve product requirements and blocking architecture decisions. Completed.
3. Scaffold the package and Android example. Completed under RB-4.
4. Build an Android QR walking skeleton.
5. Add EAN-13, Code 128, filtering, permissions, lifecycle, and accessibility behavior.
6. Complete clean-host, physical-device, privacy, security, and private-release evidence.

RB-4 authorises the empty package scaffold only. It does not authorise scanner behavior, public distribution, production release, or external commitments.
