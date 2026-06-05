# Notes App

## Overview

Notes App is an Android application built using Jetpack Compose and Room Database. The app allows users to create, search, view, delete, and restore notes while maintaining data persistence across app restarts.

---

## Features

* Create Notes
* View Note Details
* Search Notes in Real Time
* Swipe to Delete Notes
* Undo Delete using Snackbar
* Room Database Persistence
* Dark Mode Support
* Dynamic Colors (Android 12+)
* Database Migration Support

---

## Architecture

The application follows the MVVM architecture pattern.

```text
UI (Compose)
    ↓
ViewModel
    ↓
Repository
    ↓
DAO
    ↓
Room Database
```

### Layers

#### UI Layer

* TodoScreen
* DetailScreen
* Reusable Components

#### ViewModel Layer

* TodoViewModel
* State Management
* Business Logic

#### Data Layer

* TodoRepository
* TodoDao
* Room Database

---

## Technologies Used

* Kotlin
* Jetpack Compose
* Navigation Compose
* ViewModel
* Room Database
* Kotlin Flow
* Material 3

---

## Project Structure

```text
data/
 ├─ local/
 └─ repository/

navigation/

ui/
 ├─ components/
 ├─ screens/
 └─ theme/

viewmodel/
```

---

## How To Run

1. Clone the repository.
2. Open the project in Android Studio.
3. Sync Gradle files.
4. Run the application on an emulator or physical device.

---

## Future Improvements

* Edit Notes
* Note Categories
* Sorting and Filtering
* Cloud Backup
* User Authentication
