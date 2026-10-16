# ADR 0008 Prohibit runtime data egress and retention

**Status:** proposed for Security and human review

**Date:** 2026-10-16

**Owners:** Security and Architect

## Proposed decision

- Do not declare Android Internet permission.
- Do not include analytics, telemetry, crash-reporting, remote-model, advertising, or backend SDKs.
- Do not log camera frames, decoded values, bounding boxes, raw native responses, or user-visible payloads.
- Do not persist decoded values in files, preferences, databases, caches, screenshots, or evidence.
- Use stable allowlisted diagnostic codes without arbitrary native text.
- Keep a decoded value in memory only until the host receives the explicit success result or the result is cleared.
- Test APKs use synthetic values only.

## Verification

Security must inspect the merged manifest, dependency graph, runtime logs, app storage, and network activity for each release candidate.

## Consequences

The package cannot provide analytics, remote diagnostics, payload history, or cloud-assisted decoding. Any future data egress requires a new human-authorised product and Security decision.

