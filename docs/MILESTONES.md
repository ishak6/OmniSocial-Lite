# Delivery Plan — M0 to M11

Each milestone has an exit gate. A milestone is not complete until evidence (build, test, policy check, or device verification) is recorded.

| Milestone | Scope | Exit gate |
|---|---|---|
| M0 | Requirements, threat model, provider capability research, architecture, privacy data map | Requirements approved; official API feasibility and permissions documented; risks and exclusions agreed |
| M1 | Native Android project, Compose design system, navigation, accessibility, localization | Debug build succeeds; launch/navigation smoke tests pass; no WebView dependency |
| M2 | Privacy foundation: minimal manifest, local preferences, Keystore abstraction, cache controls | Permission audit, storage tests, secret/log review pass |
| M3 | Official authorization and account connection | Current provider policy/API verified; auth flow tested; no password collection |
| M4 | Feed and media viewing, only where officially supported | Real API data verified; pagination/error/empty states tested; unsupported paths clearly explained |
| M5 | Post creation and engagement, only where officially supported | Each action verified against approved endpoint/permission; no false-success UI |
| M6 | Profiles, friends, pages/groups, only where officially supported | Capability matrix and access tests pass |
| M7 | Search, only where officially supported | Real supported results; empty/error/rate-limit behavior tested |
| M8 | Messaging and notifications, only if officially available | Official capability and approval verified; privacy review passes |
| M9 | Data saver, cache limits, network/performance optimization | Network/cache measurements and low-connectivity tests pass |
| M10 | Settings, privacy dashboard, local-data controls, accessibility polish | User can inspect and clear local data; UI and permission tests pass |
| M11 | Full build, QA, security review, release APK and artifact | Clean CI build, test/lint/security gates, install/launch smoke test, release artifact verified |

## Pipeline policy
- Build and test each milestone as soon as implementation is introduced.
- Prepare the next milestone only when dependencies and interfaces are stable.
- Fix regressions before advancing past a failed exit gate.
- Do not mark provider-dependent features complete until official API access and permissions are confirmed.
- If a feature is unavailable under official APIs, present the limitation and obtain the owner's approval for an alternative or removal.
- Maintain requirement-to-test traceability through M11.
