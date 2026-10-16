# ADR 0012 Approve requirements, architecture, and toolchain spike

**Status:** accepted

**Date:** 2026-10-16

**Owner:** human principal

## Decision

The human principal approved the Product Owner product brief and requirements, ADRs 0002 through 0010, and the ADR 0011 private-signing and distribution deferral.

The human principal accepted the ZXing maintenance and Apache 2.0 dependency risk for private evaluation, authorised RB-3 governed delivery-control preparation, and authorised a toolchain-only spike.

## Boundary

The toolchain spike may generate and build an empty Android-only Flutter plugin and example in a disposable workspace. It may resolve standard scaffold dependencies and record versions, commands, hashes, results, and limitations. It may not add CameraX, ZXing, scanning behavior, production package code, external distribution, or release credentials.

Production scaffolding and QR implementation remain blocked until the rebuild entry gate passes.

## References

- [Product brief](../docs/product-brief.md)
- [Requirements](../docs/requirements/rebuild-requirements.md)
- [Architecture review pack](../docs/architecture/review-pack.md)
- [Delivery controls](../governance/delivery-controls.md)
