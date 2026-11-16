# OmniSocial Lite

A privacy-first, lightweight, native Android social client project.

## Confirmed product direction
- Kotlin + Jetpack Compose; no WebView.
- Official/authorized Facebook integration only. No scraping, private API reverse engineering, credential collection, or access-control bypass.
- No project-owned backend, database, analytics, tracking, or advertising SDK.
- Store only necessary user-approved app preferences and temporary cache locally.
- Protect locally retained secrets with Android Keystore-backed encryption.
- GitHub Actions is a build service, not an app runtime server.

## Important platform boundary
Facebook controls its own services and data. This app cannot prevent Facebook from storing account activity, posts, messages, or other information on Facebook systems. Features will be included only where current official APIs and granted permissions support them. Unsupported features must be clearly marked unavailable rather than simulated.

## Current implementation status
- [x] Repository verified: ishak6/OmniSocial-Lite
- [x] Product requirements, architecture, threat model, and milestone plan committed
- [x] Preliminary official API capability assessment committed
- [x] Native Compose project shell and 5-tab navigation committed
- [x] Minimal initial manifest: INTERNET only; cleartext traffic disabled; backup disabled
- [x] GitHub Actions build workflow committed
- [ ] CI build result verified
- [ ] Meta Developer App and exact permission/app-review requirements confirmed
- [ ] Live provider integration
- [ ] Device testing, security audit, and release APK

## Current UI behavior
The initial screens are a native UI shell only. They do not display fake feed items, fake search results, or pretend that login, posting, or messaging works. Provider-dependent features remain visibly unconnected until an official API path is confirmed.

See:
- docs/REQUIREMENTS.md
- docs/ARCHITECTURE.md
- docs/THREAT-MODEL.md
- docs/PROVIDER-CAPABILITIES.md
- docs/MILESTONES.md
