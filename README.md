# Adaire Scan Rebuild

Adaire Scan Rebuild is a clean workspace for redesigning the Adaire Scan Barcode and QR capability without inheriting the legacy implementation structure or dependency graph.

The repository currently contains preparation documents only. Production implementation is intentionally blocked until the product boundary, requirements, architecture decisions, and walking-skeleton acceptance criteria are approved.

## Why rebuild

The legacy pilot established useful behavior and device evidence, but it also exposed the cost of repairing an existing multi-package structure while trying to establish a narrow, trustworthy Android scanning product. The rebuild will preserve validated requirements and lessons while making every code, dependency, and compatibility decision explicit.

The legacy repository at `/Users/luthando/adaire-scan` remains the evidence source. It is not a code template for this repository.

## Preparation documents

- [Rebuild charter](docs/rebuild-charter.md)
- [Product brief](docs/product-brief.md)
- [Rebuild requirements](docs/requirements/rebuild-requirements.md)
- [Architecture decision queue](docs/architecture/decision-queue.md)
- [Legacy evidence inventory](docs/migration/legacy-inventory.md)
- [Initial backlog](planning/backlog.md)
- [Decision record template](decisions/0000-template.md)

## Proposed delivery sequence

1. Approve product scope and exclusions.
2. Resolve blocking architecture decisions.
3. Build an Android QR walking skeleton.
4. Add EAN-13, Code 128, filtering, permissions, lifecycle, and accessibility behavior.
5. Complete clean-host, physical-device, privacy, security, and private-release evidence.

This sequence is a proposal until approved. It does not authorise public distribution, production release, or external commitments.

