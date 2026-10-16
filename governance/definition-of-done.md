# Rebuild Definition of Done

**Status:** proposed for human approval

An item is done only when all applicable conditions are satisfied and recorded.

## Every item

- The implementation matches an approved requirement and backlog item.
- Architecture and public contracts conform to accepted ADRs.
- Automated checks covering changed behavior pass.
- Evidence identifies the exact source baseline, environment, command or method, result, and limitations.
- No known regression or unresolved blocking review remains.
- Security-relevant dependency, input, output, permission, storage, logging, and network effects are reviewed.
- User-facing behavior is reviewed for usability and accessibility.
- Relevant integration and operator documentation is current.
- Temporary substitutes are removed or tracked with an owner and blocking gate.
- Status distinguishes implementation, self-verification, specialist review, Product Owner acceptance, private distribution approval, and release.

## QR walking skeleton

- Every approved criterion in the requirements is evidenced against one immutable candidate.
- Architect, QA, Security, UX/UI, and Product Owner approvals identify that candidate.
- Clean-host integration succeeds without undocumented repository knowledge.
- The Android example builds from the recorded pinned toolchain.
- QR success and every implemented terminal outcome complete exactly once.
- No decoded value appears in retained logs, diagnostics, default stringification, files, preferences, databases, evidence screenshots, or network traffic.
- The merged manifest has no Internet permission and the dependency graph contains no analytics or telemetry SDK.
- Emulator and OPPO CPH2207 Android 13 evidence is complete, with compatibility claims limited to executed coverage.
- No release, distribution, or production-readiness claim exceeds its separately approved gate.
