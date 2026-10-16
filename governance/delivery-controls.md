# Governed Delivery Controls

**Status:** accepted by Scrum Master / Orchestrator

**Prepared:** 2026-10-16

**Reviewed:** 2026-10-16 by QA

## Scope

These controls govern the Android QR walking skeleton. They do not authorise EAN-13, Code 128, iOS, public distribution, production release, backend services, analytics, payload transmission, or external commitments.

## Work states

Every backlog item moves through `not_started`, `ready`, `in_progress`, `self_verified`, `specialist_review`, `product_acceptance`, and `done`. `blocked` and `cancelled` are explicit terminal or paused states. Implementation, review, acceptance, private distribution, and release must never be collapsed into one status.

## Supervision

- Frontend/mobile implementation operates in **Review** supervision.
- The implementation owner may make routine code decisions inside accepted requirements and ADRs.
- Material contract, dependency, privacy, accessibility, compatibility, or scope changes require the relevant owner and may require human approval.
- Developer autonomy is not evaluated or graduated during this increment.
- Human silence is not approval.

## Entry gate for implementation

Implementation may begin only when:

1. RB-1, RB-2, and RB-3 are done;
2. the toolchain verification condition in ADR 0003 passes or is explicitly revised;
3. the exact work item, acceptance criteria, owner, reviewer set, and evidence plan are recorded;
4. no blocking escalation is open; and
5. the human principal explicitly authorises the implementation increment.

## Required reviews

Before the QR walking skeleton may be called complete:

- Architect approves architectural conformance;
- QA approves test coverage and evidence adequacy;
- Security approves dependency, manifest, log, storage, and network findings;
- UX/UI approves accessibility and scanner interaction evidence;
- Product Owner approves product acceptance; and
- the human principal decides any risk acceptance, private distribution, external commitment, or release question.

Review records must name the candidate commit and, when applicable, artifact SHA-256. A role may block within its mandate. Disagreements use the source team's conflict and escalation protocols.

## Evidence rules

- Store durable evidence under `evidence/` using the locations defined in [evidence/README.md](../evidence/README.md).
- Use synthetic payloads only.
- Do not retain decoded values, camera frames, real personal data, secrets, keystores, APKs, or transient build output in Git.
- Record commands, environment versions, source commit, artifact hash, result, reviewer, date, limitations, and missing coverage.
- Evidence from another commit is stale unless an impact assessment explicitly proves it remains applicable.

## Escalation

Stop affected work and request a human decision for scope expansion, external commitments, licensing or distribution changes, security-risk acceptance, production credentials, public release, exhausted retry limits, or unresolved cross-role conflict. Unaffected authorised work may continue.

## Change control

Accepted requirements and ADRs are baselines. Material deviation requires a new or superseding decision record. Corrections that do not change meaning may be reviewed with the affected work item.
