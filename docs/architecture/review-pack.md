# Requirements and Architecture Review Pack

**Status:** partially approved; remaining decisions ready for human review

**Prepared:** 2026-10-16

## Review purpose

This pack requests approval of the Product Owner requirements and the architecture decisions that block the Android QR walking skeleton. Approval completes RB-1 and RB-2 only. It does not authorise production implementation.

## Product Owner recommendation

Approve the [product brief](../product-brief.md) and [requirements](../requirements/rebuild-requirements.md) as the product baseline for the QR walking skeleton.

The baseline requires typed outcomes, strict QR-only behavior, exactly-once completion, clean-host integration, accessibility evidence, synthetic data, no payload retention or transmission, and evidence tied to one immutable candidate.

## Architect recommendations

| ADR | Recommendation | Important consequence or residual risk |
|---|---|---|
| [0002](../../decisions/0002-package-identity-and-layout.md) | Use one private `adaire_scan` Flutter plugin and minimal example | Package identity and private licensing label need human approval |
| [0003](../../decisions/0003-pin-android-toolchain.md) | Start with Flutter 3.47.7, Dart 3.13.5, JDK 17, SDK 23 to 36, then verify generated build versions in a toolchain-only spike | The versions remain provisional until the spike passes |
| [0004](../../decisions/0004-use-camerax-and-zxing-core.md) | Use CameraX 1.6.2 with ZXing Core 3.5.4 behind an internal decoder boundary | ZXing is in maintenance mode; dependency licences and future replacement risk need acceptance |
| [0005](../../decisions/0005-use-a-standard-flutter-plugin.md) | **Accepted:** use a Flutter and Dart interface with a native Kotlin scanner and Pigeon-generated typed transport | Generated sources become pinned, reviewed candidate inputs |
| [0006](../../decisions/0006-define-typed-scan-contract.md) | Use a sealed result family and deterministic redacted failures | The walking skeleton accepts QR only |
| [0007](../../decisions/0007-use-an-explicit-scan-state-machine.md) | Centralise scan lifecycle and exactly-once completion | State-transition and Android lifecycle tests are mandatory |
| [0008](../../decisions/0008-prohibit-runtime-data-egress.md) | Prohibit Internet permission, telemetry, persistence, and payload logging | Security must verify dependencies, manifest, runtime traffic, logs, and storage |
| [0009](../../decisions/0009-use-layered-synthetic-verification.md) | Use synthetic fixtures and layered evidence tied to one commit and artifact | OPPO Android 13 evidence does not establish broad compatibility |
| [0010](../../decisions/0010-define-android-accessibility-contract.md) | Treat native controls, TalkBack, host return, and nonvisual limitations as contract requirements | Independent nonvisual camera alignment remains limited and must be documented |
| [0011](../../decisions/0011-defer-private-release-signing.md) | Defer production signing and external distribution; use local test artifacts only | Licensing, evaluator, channel, signing custody, and risk remain later human gates |

## Why ML Kit is not recommended

ML Kit performs barcode processing on-device, but Google's terms and Android disclosure state that the SDK sends operational metrics and device or application information to Google. Selecting it would conflict with the approved prohibition on analytics. CameraX plus ZXing avoids that known SDK data flow and supports the required custom accessible interface, while accepting the documented ZXing maintenance risk.

## Decisions requested

The human principal should record whether they:

1. approve the Product Owner product brief and requirements;
2. approve ADRs 0002 through 0004 and 0006 through 0010; ADR 0005 is already accepted;
3. approve the ADR 0011 deferral for walking-skeleton work;
4. accept the ZXing maintenance and Apache 2.0 dependency risk for private evaluation; and
5. authorise RB-3 governed delivery-control preparation.

After those decisions, the Orchestrator may prepare RB-3. Production scaffolding and QR implementation remain blocked until RB-3 is approved and the charter entry gate is complete.

## Evidence sources

- [CameraX release notes](https://developer.android.com/jetpack/androidx/releases/camera)
- [ZXing repository](https://github.com/zxing/zxing)
- [ZXing Apache 2.0 licence](https://github.com/zxing/zxing/blob/master/LICENSE)
- [ML Kit terms and privacy](https://developers.google.com/ml-kit/terms)
- [ML Kit Android data disclosure](https://developers.google.com/ml-kit/android-data-disclosure)
