# Architecture Decision Queue

**Status:** open

The following decisions block or materially shape implementation. Each accepted decision must be recorded as an ADR in `decisions/`.

| ID | Decision | Why it matters | Blocks |
|---|---|---|---|
| ADQ-01 | Package identity, namespace, and repository layout | Prevents later publication and integration contradictions | Project scaffold |
| ADQ-02 | Flutter, Dart, Java, Gradle, Android Gradle Plugin, Kotlin, compile SDK, target SDK, and minimum SDK ranges | Defines the reproducible toolchain and compatibility boundary | Project scaffold |
| ADQ-03 | Native Android scanning library or platform API | Determines capability, licence, dependency, privacy, and maintenance risk | Scanner implementation |
| ADQ-04 | Plugin architecture and public Dart API | Establishes separation between Dart contract and Android implementation | Walking skeleton |
| ADQ-05 | Typed outcome and native transport envelope | Prevents ambiguous errors and message parsing | Walking skeleton |
| ADQ-06 | Activity, permission, concurrency, and lifecycle state model | Protects exactly-once completion and camera ownership | Walking skeleton |
| ADQ-07 | Logging, storage, network, and diagnostic policy | Establishes payload-safety controls | Any runtime code |
| ADQ-08 | Testing layers and synthetic-fixture strategy | Makes behavior reproducible without sensitive data | Verification implementation |
| ADQ-09 | Accessibility contract for scanner controls and host return | Defines required native and Flutter behavior | Scanner UI |
| ADQ-10 | Private signing, artifact retention, and distribution approach | Separates internal testing from authorised external evaluation | Private distribution |

## Decision criteria

Each ADR should record the context, considered options, evidence, consequences, rejected alternatives, security and accessibility effects, migration impact, and residual risk.

