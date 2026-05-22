<h1 align="center">Goon Manager</h1>

<p align="center">
  <a href="https://github.com/OTKUSteyler/GoonManager/releases/"><img alt="Releases" src="https://img.shields.io/github/v/release/kmmiio99o/ShiggyManager?style=flat-square"></a>
  <a href="https://github.com/kmmiio99o/ShiggyManager/blob/main/LICENSE"><img alt="License" src="https://img.shields.io/badge/license-MIT-blue?style=flat-square"></a>
  <a href="https://github.com/kmmiio99o/ShiggyManager/issues"><img alt="Issues" src="https://img.shields.io/github/issues/kmmiio99o/ShiggyManager?style=flat-square"></a>
</p>

<p align="center">
  A fast, friendly, and focused Android mod manager for Discord — rebranded for the GoonCord community from Wintry.
</p>

---

## ✨ Why Goon Manager?

Goon Manager makes installing and managing Discord mods simple and safe. It's built from the ground up by Aliucord Team with reliability and UX in mind, and changed to work with new versions by Wintry Team:
- Clean, GoonCord-branded UI and icons
- Safe vector handling to avoid runtime inflation issues
- Fast install/update workflows
- forked by a lazy dev as an running joke mod

---

## 🚀 Quick Start

<p><strong>Download & run</strong> — get a released APK from Releases and install with:</p>

Get newest apk from [release list](https://github.com/OTKUSteyler/GoonManager/releases/tag/v1.1.3) and install it.

<p><strong>Build from source</strong> — clone and assemble:</p>

```GoonManager/README.md#L411-418
git clone https://github.com/OTKUSteyler/GoonManager.git
cd GoonManager
./gradlew :app:assembleDebug
```

APK output: `app/build/outputs/apk/debug/app-debug.apk`.

---

## ⚙️ Features

- One-tap install, update, or remove of supported mods
- About screen with contributors and "fun facts"
- Safe vector drawable usage (vector groups + scale/translate)
- Customizable branding via resources (colors, icons, strings)

---

## 🎨 Customization & Theming

You can fully tailor the appearance:

- App name: edit `app/src/main/res/values/strings.xml` — ensure the UI uses `@string/app_name`.
- Icons: swap `app/src/main/res/drawable/ic_rounded_shiggy.xml` and `ic_discord_shiggy.xml` with your vector or PNG.
- Colors: use `colors.xml` to apply a new palette.
- Glyph sizing: vector drawables support `<group android:scaleX="" android:scaleY="" android:translateX="" android:translateY="">`. To center an element after scaling, compute translation as:

```GoonManager/README.md#L419-426
translate = (viewportSize - (viewportSize * scale)) / 2
# Example for viewport 256 and scale 0.7 -> translate = 38.4
```

If you see a missing space in the name (e.g., `GoonManager`), search for usages of `@string/shiggy` — that key intentionally contains the compact brand name. Prefer `@string/app_name` for UI labels that expect "Goon Manager".

---

## 🧩 Troubleshooting

- Vector inflation errors:
  - Check `adb logcat` for FATAL EXCEPTION and the drawable path.
  - Validate vector XML: no unsupported attributes, proper `pathData`.
  - If issues persist, consider a `layer-list` reference to the launcher icon or a PNG fallback.

---

## 🤝 Contributing

We love contributions! Here's how to help:

1. Fork the repository.
2. Create a branch:
```GoonManager/README.md#L427-430
git checkout -b feat/my-cool-feature
```
3. Make your changes, run tests and build:
```ShiggyManager/README.md#L431-434
./gradlew :app:assembleDebug
```
4. Open a PR describing:
   - What you changed
   - Why it helps
   - Screenshots if UI changes

Please keep PRs focused and document behavior changes.

---

## 🙌 Code of Conduct

Be kind and constructive. Treat everyone with respect. If you want to adopt a formal Code of Conduct, add a `CODE_OF_CONDUCT.md` at the root and link to it here.

---

## 📝 Release Notes & Changelog

We keep a concise changelog in the release notes. Please add meaningful entries for user-facing changes and breaking updates.

---

## 🧾 License

Goon Manager is open source under the OSL License. See `LICENSE` for details.

---

## 💬 Contact & Support

- Repo: https://github.com/kmmiio99o/ShiggyManager
- Issues & feature requests: https://github.com/kmmiio99o/ShiggyManager/issues
- For community chat, check the in-app "[Support Server](https://discord.gg/nQykFF9Ud6)" link or the repo description.

---

<p align="center">
  <strong>Made with ❤️ for the GoonCord community — keep it playful, keep it safe.</strong>
</p>

![OTKUSteyler](https://count.getloli.com/@OTKUSteyler?name=OTKUSteyler&theme=miku&padding=7&offset=0&align=top&scale=1&pixelated=1&darkmode=1)
