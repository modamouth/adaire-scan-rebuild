# Architecture Decision Queue

**Status:** blocking decisions accepted and toolchain verified

The following decisions block or materially shape implementation. Each accepted decision must be recorded as an ADR in `decisions/`.

| ID | Decision | Why it matters | Blocks |
|---|---|---|---|
| ADQ-01 | Package identity, namespace, and repository layout | Prevents later publication and integration contradictions | Project scaffold |
| ADQ-02 | Flutter, Dart, Java, Gradle, Android Gradle Plugin, Kotlin, compile SDK, target SDK, and minimum SDK ranges | Defines the reproducible toolchain and compatibility boundary | Project scaffold |
| ADQ-03 | Native Android scanning library or platform API | Determines capability, licence, dependency, privacy, and maintenance risk | Scanner implementation |
| ADQ-04 | Plugin architecture and public Dart API | Accepted: Flutter and Dart interface with native Kotlin scanner implementation | Walking skeleton |
| ADQ-05 | Typed outcome and native transport envelope | Prevents ambiguous errors and message parsing | Walking skeleton |
| ADQ-06 | Activity, permission, concurrency, and lifecycle state model | Protects exactly-once completion and camera ownership | Walking skeleton |
| ADQ-07 | Logging, storage, network, and diagnostic policy | Establishes payload-safety controls | Any runtime code |
| ADQ-08 | Testing layers and synthetic-fixture strategy | Makes behavior reproducible without sensitive data | Verification implementation |
| ADQ-09 | Accessibility contract for scanner controls and host return | Defines required native and Flutter behavior | Scanner UI |
| ADQ-10 | Private signing, artifact retention, and distribution approach | Separates internal testing from authorised external evaluation | Private distribution |

## Decision records

- [ADR 0002](../../decisions/0002-package-identity-and-layout.md)
- [ADR 0003](../../decisions/0003-pin-android-toolchain.md)
- [ADR 0004](../../decisions/0004-use-camerax-and-zxing-core.md)
- [ADR 0005](../../decisions/0005-use-a-standard-flutter-plugin.md)
- [ADR 0006](../../decisions/0006-define-typed-scan-contract.md)
- [ADR 0007](../../decisions/0007-use-an-explicit-scan-state-machine.md)
- [ADR 0008](../../decisions/0008-prohibit-runtime-data-egress.md)
- [ADR 0009](../../decisions/0009-use-layered-synthetic-verification.md)
- [ADR 0010](../../decisions/0010-define-android-accessibility-contract.md)
- [ADR 0011](../../decisions/0011-defer-private-release-signing.md)

ADRs 0002 through 0010 are accepted. ADR 0011 is an accepted deferral for walking-skeleton work. ADR 0003 retains its toolchain verification condition.

## Decision criteria

Each ADR should record the context, considered options, evidence, consequences, rejected alternatives, security and accessibility effects, migration impact, and residual risk.
