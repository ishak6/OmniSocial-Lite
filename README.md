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

## Project status
- [x] Repository verified: ishak6/OmniSocial-Lite
- [x] Product direction and privacy boundary documented
- [ ] Android implementation
- [ ] Official API capability and permission review
- [ ] Automated build and device testing
- [ ] Security and release verification

See docs/REQUIREMENTS.md, docs/ARCHITECTURE.md, and docs/MILESTONES.md.
