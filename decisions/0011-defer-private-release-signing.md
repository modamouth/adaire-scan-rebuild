# ADR 0011 Defer private release signing and distribution

**Status:** proposed deferral

**Date:** 2026-10-16

**Owners:** human principal and DevOps

## Proposed decision

During the walking skeleton, generate only local debug-signed or explicitly test-signed artifacts retained outside Git. Record each artifact hash and source commit.

Do not create, upload, share, or automate use of a production keystore. Do not distribute an artifact to an external evaluator until the human principal approves licensing, evaluator identity, delivery channel, support boundary, residual risk, and signing custody.

## Consequences

ADQ-10 does not block local walking-skeleton verification, but it remains a mandatory gate before private external distribution.
