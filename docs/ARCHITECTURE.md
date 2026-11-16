# Architecture — OmniSocial Lite

## High-level structure
Compose UI:
- Home / Feed
- Friends / Profiles
- Create
- Messages
- Menu / Settings

UI connects to feature ViewModels and domain use cases, then to a narrowly scoped authorized integration boundary. Provider traffic must use documented official SDKs/APIs only.

Local-only components:
- Preferences for non-sensitive UI settings.
- Encrypted token store only if an official authorization flow requires token persistence.
- Bounded media/cache storage for temporary content.
- Android Keystore for key protection.

## Runtime and data boundaries
- No OmniSocial Lite-operated backend, database, account system, telemetry endpoint, or remote storage.
- GitHub Actions is only a CI/build environment; it is not part of app runtime.
- Provider network traffic goes directly to documented official provider endpoints/SDKs.
- Never log access tokens, authorization codes, personal messages, or private profile data.
- Prefer memory-only state. Persist only settings and data strictly required for a feature.
- Cache is bounded, temporary, and user-clearable.
- Sensitive local values use Android Keystore-backed cryptography; no hardcoded secrets.
- Do not request broad storage access. Use Android's system photo picker for user-selected media if upload is supported.
- No background work unless explicitly enabled and documented.

## Authentication
- Use the official OAuth/SDK flow supported by the provider.
- Never collect provider passwords inside the app.
- Validate redirect/state according to the official SDK/flow.
- Request minimum permissions and handle denial/revocation.
- Disconnect and erase locally retained credentials on logout where supported.
- Never bypass app review, permission gates, or platform policy.

## Provider capability gate
Every social feature must pass these steps before implementation:
1. Identify the current official API/SDK endpoint and policy.
2. Confirm the feature is available to third-party apps.
3. Confirm required permissions and review/approval.
4. Confirm supported account types and limitations.
5. Implement only after capability is verified.
6. Add tests and a clear unavailable state when the provider does not expose the capability.

No mock feed/search/messages may be represented as real data.

## Security and privacy controls
- Minimize Android manifest permissions.
- Disable cleartext network traffic.
- Release builds must not be debuggable.
- Secrets are supplied through secure CI configuration or official app configuration; never commit private credentials.
- Pin and review dependency versions.
- Privacy review covers manifest, dependencies, logs, storage, backups, and outbound network destinations.

## Known limitation
Facebook retains control over its platform and data. OmniSocial Lite cannot guarantee deletion or non-retention on Facebook servers. A no-own-server design does not mean Facebook service itself is local or offline.
