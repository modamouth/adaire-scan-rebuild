# Delivery Worklogs

Worklogs are the durable communication channel for active rebuild work. They record progress, evidence handoffs, blockers, and role requests without turning provisional notes into approvals or decisions.

## When to write

Add an entry when:

- an authorised item enters `in_progress`;
- the implementation owner reaches a material checkpoint;
- evidence is produced or becomes stale;
- work is handed to another role;
- a reviewer requests a correction or records a blocker;
- a correction is completed and returned for review; or
- the item changes state.

Routine command output and minute-by-minute activity do not belong here. Store durable verification results under `evidence/` and lasting architecture or product decisions in their authoritative decision or requirements documents.

## Entry format

Append entries in date and time order. A reconstructed historical entry may omit the time when no reliable timestamp exists. Do not invent timestamps. Do not rewrite earlier entries except to correct an objective error, and identify any such correction.

```markdown
### YYYY-MM-DD HH:MM TZ | role | event

- State: previous -> current, or unchanged
- Summary: concise factual progress note
- Evidence: links to committed evidence or `pending`
- Handoff: receiving role and requested action, or `none`
- Blockers: explicit blockers, or `none`
- Next: next bounded action
```

Allowed event labels are `authorisation`, `start`, `checkpoint`, `self-verification`, `handoff`, `review`, `correction`, `blocker`, `acceptance`, and `state-change`.

## Authority and evidence

- A worklog entry is a progress record, not an approval.
- Review decisions belong in candidate-bound files under `evidence/**/reviews/`.
- A reviewer records only their own role decision.
- `approved`, `changes_requested`, and `blocked` decisions must identify the exact candidate commit and applicable artifact hash.
- Human-only licensing, distribution, risk acceptance, external commitment, and release decisions cannot be inferred from a worklog or specialist approval.
- Decoded barcode values, camera frames, personal data, secrets, APKs, and raw diagnostic archives must not be committed.

## Ownership

The implementation owner records implementation checkpoints and outgoing handoffs. Each receiving role records its review outcome. The Scrum Master / Orchestrator reconciles the worklog, review records, evidence register, and backlog state at each gate.
