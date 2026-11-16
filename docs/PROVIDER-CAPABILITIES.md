# Official Facebook API Capability Assessment

Research date: 2026-11-16. Preliminary assessment from public Meta developer documentation; this is not a guarantee of approval. Re-check current API versions, app mode, permissions, and review requirements before implementation.

## Findings

| Desired capability | Public official documentation indicates | Project decision |
|---|---|---|
| Login and basic identity | Facebook Login can provide basic profile fields such as name and profile picture after user authorization. Additional fields require permissions. | Candidate for M3; request minimum scope only. |
| Read a person's complete News Feed | Graph API access is permission-scoped. The Post reference describes limited access to a user's posts with the user_posts permission; this is not equivalent to unrestricted access to the complete ranked News Feed. | Do not promise a full Facebook home feed. Verify exact supported use case and app review before implementation. |
| Read a managed Page feed | Page Feed supports reading Page-owned content subject to Page roles/tasks and permissions such as pages_read_engagement and pages_read_user_content. Public content access has separate feature requirements. | Candidate only for Pages the user is authorized to manage or approved public Page access. |
| Publish to a Page | Page Feed publishing requires Page access and relevant Page tasks/permissions such as CREATE_CONTENT and pages_manage_posts. | Candidate only after Page authorization and Meta approval. |
| Personal friends list | No general unrestricted friends directory is promised by Facebook Login. | Do not promise a full friends list; investigate exact approved endpoint only if needed. |
| Personal Messenger inbox | Messenger Platform docs are Page-centric, with Page access tokens, webhooks, permissions, and App Review requirements. | Not included in a no-backend first release unless Meta documents a supported serverless path for the exact use case. |
| Page messaging | Messenger Platform supports Page messaging under specific Page and app requirements. | Requires separate feasibility and privacy review; may require a webhook service, conflicting with no-own-server requirement. |
| Search | Search access is endpoint- and permission-specific. | No universal Facebook-wide people/post/group search promised. Verify each search type separately. |

## Consequences for scope
1. OmniSocial Lite can be a native, privacy-first shell and client for explicitly supported official functions.
2. It cannot honestly claim to reproduce all Facebook Lite features using public APIs alone.
3. A full personal News Feed, personal Messenger inbox, unrestricted friends list, and universal search are not assumed available.
4. If the user requires those features inside the app, first identify a current official API path and its approval requirements. If none exists, offer an approved alternative such as opening the official Facebook app/site externally, or remove the feature with user approval.
5. Never scrape Facebook pages, automate the consumer UI, use private endpoints, extract app secrets, or bypass permissions.

## Official references
- Graph API overview: https://developers.facebook.com/docs/graph-api/overview/
- Graph API getting started and permissions: https://developers.facebook.com/docs/graph-api/get-started/
- Post reference and user_posts conditions: https://developers.facebook.com/docs/graph-api/reference/v2.9/post
- Page Feed requirements: https://developers.facebook.com/docs/graph-api/reference/page/feed/
- Messenger Platform quick start and app roles/review: https://developers.facebook.com/docs/messenger-platform/getting-started/quick-start/

## M0 blockers
- Owner must create/configure a Meta Developer App if official login is to be tested.
- Exact use cases and required permissions must be selected.
- Any required Advanced Access/App Review must be approved by Meta.
- Until resolved, provider-dependent features remain blocked/not supported, not implemented.
