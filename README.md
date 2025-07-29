
# 📱 Taj Mahal – Restaurant Review Android App

**Taj Mahal** is a modern Android application developed in **Java**, enabling users to explore restaurant details and post reviews. Built as part of a professional training program at OpenClassrooms, it demonstrates key Android development concepts including MVVM architecture, custom UI components, simulated data API, and Jetpack ViewModel.

---

## 🧠 Features

- 🏛️ Display restaurant details (name, description, photo).
- ⭐ View and submit reviews with star ratings and comments.
- 📶 Data retrieved via a **fake API layer** simulating network interaction.
- 🔁 Uses **MVVM architecture** for separation of concerns.
- 🧪 Includes **instrumented tests** for critical UI flows.

---

## 📸 Screenshots

Visit the following link to browse screenshots of the Taj-Mahal application:  
🔗 [Taj-Mahal App Screenshots](assets/screenshots/)

---

## 🛠️ Tech Stack

| Layer | Technology |
|-------|------------|
| Language | Java |
| UI | Fragments, RecyclerView, ViewModel |
| Architecture | MVVM |
| API | Simulated with `RestaurantFakeApi` |
| Dependency Injection | Dagger/Hilt |
| Testing | JUnit, Espresso |
| Build | Gradle (KTS) |

---

## 📁 Project Structure

```
A039_TajMahal/
├── app/
│   └── src/
│       ├── main/
│       │   ├── java/com/openclassrooms/tajmahal/
│       │   │   ├── ui/                   # UI layer with Fragments and ViewModels
│       │   │   ├── domain/model/         # Data models (Restaurant, Review)
│       │   │   ├── data/service/         # Fake API service
│       │   │   ├── data/repository/      # Repository layer
│       │   │   ├── di/                   # Dependency injection module
│       │   │   └── utils/                # Utility classes
│       │   └── res/                      # XML layout, drawables, etc.
│       └── androidTest/                  # Instrumented UI tests
```

---

## ⚙️ Setup

### Prerequisites

- Android Studio
- JDK 17
- Android SDK (API 33+)

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/oliviermarteaux/A039_TajMahal.git
   ```

2. Open the project in **Android Studio**.

3. Sync Gradle and build the project:
   - Gradle files: `build.gradle.kts`, `settings.gradle.kts`

4. Run on emulator or physical device (API 33+).

---

## 🤝 Acknowledgments

- [OpenClassrooms Android Pathway](https://openclassrooms.com/fr/paths/527/projects/1635/143-mission---completez-une-interface-dynamique-en-mvvm)
- [Starter repository](https://github.com/OpenClassrooms-Student-Center/Compl-tez-une-interface-dynamique-en-MVVM.git)
- [Google Android Basics](https://developer.android.com/courses/android-basics-compose/course)
- JetBrains & Jetpack Compose Community
 
---

### 📄 License

This project is for educational and demonstration purposes. Not licensed for commercial use. For inquiries, please contact me.

---

_“From Space to Code” – a journey of reinvention and curiosity._