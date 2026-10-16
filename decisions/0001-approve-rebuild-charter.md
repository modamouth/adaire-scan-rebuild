# ADR 0001 Approve the Adaire Scan rebuild charter

**Status:** accepted

**Date:** 2026-10-16

**Owners:** human principal and Product Owner

## Context

The legacy Adaire Scan pilot produced useful product, contract, accessibility, and device evidence, but the human principal chose a clean rebuild rather than continued debugging or extension of the existing source.

## Decision

Barcode and QR is the first rebuilt product. Initial delivery is Android only and private only. The walking skeleton supports QR first. EAN-13 and Code 128 require a later gate after the walking skeleton passes.

Legacy implementation code, biometrics, other scanner packages, iOS work, backend services, analytics, payload transmission, public release, and external commitments are not authorised.

The Product Owner may finalise product requirements. The Architect may prepare blocking architecture proposals for human review. This decision does not authorise production implementation.

## Consequences

The rebuild repository may progress through RB-1 and RB-2. RB-4 and later work remain blocked until requirements, architecture, and governed delivery controls pass their entry gates.

## References

- [Rebuild charter](../docs/rebuild-charter.md)
- [Product brief](../docs/product-brief.md)
- [Initial backlog](../planning/backlog.md)

