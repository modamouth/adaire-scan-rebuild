# Adaire Scan Rebuild Charter

**Status:** draft for human and Product Owner approval

**Prepared:** 2026-10-16

## Purpose

Prepare and deliver a clean Adaire Scan implementation that provides a small, stable, privacy-conscious Android Barcode and QR integration for Flutter developers.

The rebuild will use validated legacy behavior as evidence while avoiding automatic inheritance of legacy source, package structure, dependencies, metadata, and compatibility claims.

## Proposed outcome

An authorised Flutter developer can integrate the rebuilt package into a clean Android host, scan the approved synthetic barcode formats, handle every terminal outcome without parsing messages, and evaluate the package privately using documented and reproducible steps.

## Proposed initial scope

- one Flutter package with one Android implementation;
- QR as the walking-skeleton format;
- EAN-13 and Code 128 after the walking skeleton passes;
- typed success, cancellation, permission-denied, unavailable, busy, and failure outcomes;
- strict requested-format filtering;
- exactly-once completion and lifecycle recovery;
- explicit accessible exit, torch behavior, guidance, and result handling;
- synthetic fixtures, automated tests, a minimal example host, and private test APKs; and
- clean-host and OPPO CPH2207 Android 13 evidence.

## Proposed exclusions

- iOS implementation or compatibility claims;
- Credit Card, ID, Passport, fingerprint, face-recognition, or other scanner packages;
- biometrics;
- backend services, cloud storage, analytics, or payload transmission;
- automatic opening or execution of decoded values;
- public publication, public support, or production-reliability claims;
- real personal, payment, identity, employee, or customer data; and
- copying legacy implementation code without an approved exception.

## Authority

- Product Owner owns product meaning, scope, priority, and acceptance.
- Orchestrator owns decomposition, routing, sequencing, dependencies, evidence flow, and process escalation.
- Architect owns technical coherence and architecture recommendations.
- Mobile implementation owns code inside approved decisions and scope.
- QA owns verification adequacy and readiness recommendations.
- Security owns payload-handling and security findings.
- UX/UI owns accessibility and usability findings.
- The human principal owns licensing, distribution, external commitments, risk acceptance, and production-release decisions.

## Entry gate for implementation

Implementation may begin only when:

- this charter and the product brief are approved;
- requirements are accepted;
- blocking architecture decisions are recorded;
- the walking-skeleton backlog item has measurable acceptance criteria;
- the Flutter, Dart, Android, Java, and Gradle ranges are selected; and
- the implementation and review supervision modes are recorded.

## Exit gate for rebuild preparation

Preparation is complete when every entry-gate item is either approved or explicitly escalated. Preparation completion does not mean the product is implemented or ready for evaluation.

