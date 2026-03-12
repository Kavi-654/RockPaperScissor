# 🪨📄✂️ Rock Paper Scissor - Android Compose

A modern, interactive Rock Paper Scissors game built using **Jetpack Compose**. This project showcases a complete user flow, custom animations, and clean architecture.



## ✨ Features
* **Full Navigation Flow:** Home ➔ Language ➔ Profile ➔ Rules ➔ Gameplay.
* **Profile Customization:** Save your nickname and choose between Male/Female avatars.
* **Shared State:** Uses a single ViewModel to carry user data across all screens.
* **Animated UI:** Smooth button scaling and color transitions using `animateColorAsState`.
* **Interactive Rules:** A step-by-step guide before you start the game.

## 📸 Screenshots


| Home Screen | Language Screen | ProfileScreen | Profile Selection Screen | Play Button | Rules Screen | Game Screens |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |:---: |:---: |
| <img src="screenshots/home.png.png" width="200" /> | <img src="screenshots/language.png" width="200" /> | <img src="screenshots/profile.png" width="200" /> | <img src="screenshots/profile_1.png" width="200" /> | <img src="screenshots/start.png" width="200" /> | <img src="screenshots/rules_1.png" width="200" /> | <img src="screenshots/rules_2.png" width="200" /> | <img src="screenshots/ps_1.png" width="200" /> | <img src="screenshots/ps_2.png" width="200" /> | <img src="screenshots/ps_3.png" width="200" /> |  <img src="screenshots/ps_4.png" width="200" /> | 

---

## 🛠️ Tech Stack
- **Language:** Kotlin
- **UI Framework:** Jetpack Compose (Material 3)
- **Navigation:** Jetpack Navigation Compose
- **Architecture:** MVVM (Model-View-ViewModel)
- **Dependency Management:** Version Catalog (`libs.versions.toml`)

---

## 🏗️ Project Structure
```text
com.example.rockpaperscissor
├── navigation
│   ├── Screens.kt          # Route definitions (Sealed Class)
│   └── AppNavigation.kt    # NavHost & Navigation Logic
├── ui.screens
│   ├── HomeScreen.kt       # Welcome screen with animations
│   ├── LanguageChoose.kt   # Language selection logic
│   ├── ProfileScreen.kt    # User info & Avatar selection
│   ├── RulesScreen.kt      # Interactive rules dialog
│   └── GameScreen.kt       # Core game engine UI
├── viewmodel
│   └── GameViewModel.kt    # Handling game logic & StateFlow
