# OmniSocial Lite — Requirements Checklist

Status vocabulary: Planned, In progress, Implemented, Verified, Blocked, Not supported. A feature is not complete until its implementation and relevant tests are verified.

## A. Product and platform
- [ ] Android-only first release.
- [ ] Native Kotlin application using Jetpack Compose.
- [ ] WebView prohibited.
- [ ] Minimum Android version and device matrix fixed during M0 technical validation.
- [ ] Lightweight startup, memory use, storage use, and network use.
- [ ] Bengali and English UI.
- [ ] Light, dark, and system theme.
- [ ] Accessible labels, scalable text, and touch targets.

## B. Account and authorization
- [ ] Official Facebook authorization and supported APIs only.
- [ ] Never ask the user to enter a Facebook password into OmniSocial Lite.
- [ ] Use official authorization flow where applicable.
- [ ] Store tokens only when required, with consent and Android Keystore-backed protection.
- [ ] Provide disconnect/logout and local credential deletion.
- [ ] Request minimum supported permissions.
- [ ] Document every requested permission and purpose.
- [ ] Re-check current Meta policies, API availability, app review, and permission requirements before implementation.

## C. Feed and content
- [ ] Show feed content only if an official API and approved permission make it available.
- [ ] View supported public or authorized post content.
- [ ] Display supported images and videos.
- [ ] Refresh and pagination where supported.
- [ ] Do not fabricate posts or search results.
- [ ] Clearly explain unsupported feed capabilities.

## D. Posting and engagement
- [ ] Text/photo/video publishing only if explicitly supported by current official APIs and granted permissions.
- [ ] Like/reaction, comment, and share only where officially supported.
- [ ] Respect post audience and privacy controls supported by the API.
- [ ] Show upload progress and actionable errors.
- [ ] Never silently claim an unsupported action succeeded.

## E. Profiles, friends, pages, groups, and search
- [ ] Profile information only where permitted by official APIs.
- [ ] Friends list and friend actions only where supported.
- [ ] Page/group discovery only where supported.
- [ ] Search only against supported official endpoints.
- [ ] No scraping, hidden endpoint use, or access-control circumvention.
- [ ] No fake fallback results.

## F. Messaging and notifications
- [ ] Messaging only through an official supported integration, if available to this app.
- [ ] Do not read/intercept other apps' notifications, SMS, OTPs, or private data.
- [ ] In-app notifications only from authorized sources.
- [ ] Explain messaging/API limitations clearly.

## G. Privacy and local data
- [ ] No project-owned backend server.
- [ ] No project-owned remote database.
- [ ] No analytics, tracking, advertising, or attribution SDK.
- [ ] No background collection.
- [ ] No contacts, location, microphone, camera, or storage permission unless a user-initiated feature strictly needs it.
- [ ] Local data inventory documented.
- [ ] Minimize local persistence; prefer memory-only state where practical.
- [ ] User-controlled cache limits and clear-cache action.
- [ ] Clear local app data/logout action.
- [ ] Android Keystore-backed protection for any retained sensitive token/secret.
- [ ] No secrets in source code, logs, crash reports, or analytics.
- [ ] Backups disabled for sensitive app data unless separately reviewed, explicit opt-in is implemented.
- [ ] Explain that Facebook's own servers may retain activity and this app cannot control Facebook retention.

## H. Data saver and performance
- [ ] Video autoplay off by default.
- [ ] Optional Wi-Fi-only media loading.
- [ ] Image quality/data saver setting where supported.
- [ ] Cache size visibility and clear action.
- [ ] Avoid unnecessary background work.
- [ ] Handle slow, metered, and interrupted connections.
- [ ] Measure startup, memory, APK size, and network behavior.

## I. Settings and diagnostics
- [ ] Theme and language settings.
- [ ] Permission and privacy explanations.
- [ ] Local storage/cache dashboard.
- [ ] App version and license notices.
- [ ] Safe diagnostics without personal data or secrets.

## J. Build, quality, and release
- [ ] Reproducible Gradle build.
- [ ] GitHub Actions debug APK workflow.
- [ ] Unit tests for state, storage, and privacy-sensitive logic.
- [ ] Static analysis/lint.
- [ ] Manifest permission audit.
- [ ] Dependency and secret scan.
- [ ] Install/launch/navigation smoke test on Android.
- [ ] Network inspection to confirm no project-owned telemetry/backend calls.
- [ ] Release signing handled securely; no keystore or passwords committed.
- [ ] APK artifact published only after successful checks.

## Explicit exclusions
- No scraping or unofficial/private Facebook API.
- No credential harvesting, OTP interception, notification spying, or other-app data collection.
- No manipulation of Facebook's own service.
- No promise to prevent Facebook from storing data on Facebook infrastructure.
- No fake or placeholder data presented as live social content.
