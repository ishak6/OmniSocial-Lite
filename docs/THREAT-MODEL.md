# M0 Threat Model and Privacy Data Map

## Assets
- Provider access tokens and authorization state.
- User-selected media before upload.
- Minimal app preferences.
- Temporary cached media/content.
- User-visible account and content data returned by the provider.

## Trust boundaries
1. OmniSocial Lite Android process.
2. Android OS and Keystore.
3. Meta/Facebook official services and SDK/API.
4. GitHub Actions build environment.
5. User-selected local files/media.

## Threats and controls

| Threat | Control |
|---|---|
| Token leakage through logs or crash output | Redact secrets; no token logging; review logs and crash paths |
| Token theft from local storage | Minimize persistence; Keystore-backed encryption; erase on disconnect |
| Excessive permissions | No contacts/location/mic/camera permissions by default; system Photo Picker for selected uploads |
| Unwanted data retention | Memory-first design; bounded temporary cache; clear-data control; backup disabled for sensitive state |
| Hidden telemetry | No analytics/ad SDK; dependency audit; outbound network destination review |
| Fake content/action status | No mock live data; success only after confirmed provider response |
| Provider policy/API change | Capability gate and version review before feature release |
| CI secret exposure | No secrets in repository; GitHub Actions secrets only when required; least privilege |
| Cleartext network traffic | HTTPS only; cleartext disabled |
| Untrusted media or links | Platform-safe media handling; validate URLs; avoid arbitrary file execution |

## Data inventory

| Data | Location | Retention |
|---|---|---|
| Theme/language/data-saver preferences | App-private preferences | Until user clears app data |
| Provider token, if needed | Encrypted app-private storage with Keystore-protected key | Only while connected; delete on disconnect |
| Media/content cache | App cache directory | Bounded and clearable; temporary |
| User-selected upload | App cache/staging only as needed | Delete after upload/cancel |
| Feed/messages/profile content | Memory by default | No durable local copy unless a specific approved feature requires it and is disclosed |

## Explicit non-goals
- No collection of other apps' SMS, notifications, contacts, call logs, microphone, camera, or location.
- No background surveillance or stealth behavior.
- No own cloud account, database, telemetry, or content backend.
- No guarantee that Meta/Facebook will not retain data on its systems.
