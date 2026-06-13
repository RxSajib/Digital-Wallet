# Digital Wallet Application (Offline-Mock Architecture)

A modern, offline-first Android Digital Wallet application built with clean architecture principles, multi-module structure, and Jetpack Compose. This project simulates an enterprise-level mobile banking environment using reactive state streams and local mock data repositories instead of network-bound HTTP requests.


---

# 📸 Screenshots (Light)

<p align="center">
  <img src="https://github.com/RxSajib/Digital-Wallet/blob/development/screen/light/home.png?raw=true" width="250"/>
  <img src="https://github.com/RxSajib/Digital-Wallet/blob/development/screen/light/history.png?raw=true" width="250"/>
  <img src="https://github.com/RxSajib/Digital-Wallet/blob/development/screen/light/profile.png?raw=true" width="250"/>
</p>

# 📸 Screenshots (Dark)

<p align="center">
  <img src="https://github.com/RxSajib/Digital-Wallet/blob/development/screen/dark/home.png?raw=true" width="250"/>
  <img src="https://github.com/RxSajib/Digital-Wallet/blob/development/screen/dark/history.png?raw=true" width="250"/>
  <img src="https://github.com/RxSajib/Digital-Wallet/blob/development/screen/dark/profile.png?raw=true" width="250"/>
</p>


## 🏛 Architecture Overview

The project is strictly split into three core feature-agnostic modules to ensure a rigid separation of concerns, high testability, and isolated build compilation cycles:

```text
                           ┌────────────────────────────────────────┐
                           │          :presentation module          │
                           │   (Jetpack Compose UI & ViewModels)    │
                           └───────────────────┬────────────────────┘
                                               │
                                               ▼ Uses
                           ┌────────────────────────────────────────┐
                           │            :domain module              │
                           │   (Business Rules, Models, UseCases)   │
                           └───────────────────▲────────────────────┘
                                               │
                                               │ Implements
                           ┌───────────────────┴────────────────────┘
                           │             :data module               │
                           │  (Data Sources, Mappers, RepoImpl, DTOs)│
                           └────────────────────────────────────────┘

```

### 1. `:domain` Layer

The absolute core of the application logic. It is purely written in Kotlin and remains entirely isolated from any Android framework dependencies, databases, UI layers, or external SDK configurations.

* **`Model`**: Core domain data frames mapped explicitly to match UI entity specifications.
* **`Repository`**: Interface definitions that outline the contracts for data operations.
* **`UseCase`**: Isolated single-responsibility business interaction pillars executing data flow logic safely.

### 2. `:data` Layer

The infrastructure layer responsible for gathering data and translating it cleanly into structure frameworks mandated by the core business tier.

* **`Model (DTO)`**: Data Transfer Objects structured identically to target JSON contracts.
* **`Api`**: Simulated interface framework mimicking background network actions with controlled delays (this project its just a demo there have no actual api call).
* **`Data Sources`**: Static, robust inline mock configurations serving realistic asset profiles.
* **`Mapper`**: Unidirectional extension utility layers translating `UserDto` structures into target domain `User` entities safely.
* **`Repository Impl`**: The structural concrete implementation of the domain's repository contracts.

### 3. `:presentation` Layer

The visible user gateway layer rendering UI structures and holding context lifecycles safely.

* **`UI / Composables`**: Modular Jetpack Compose interfaces handling list distributions safely.
* **`ViewModels`**: Architecture Component state drivers holding screen properties inside `StateFlow` structures, consuming multi-module UseCase flows.

---

## 🛠 Tech Stack

* **Language**: 100% Kotlin
* **UI Engine**: Jetpack Compose (Declarative UI layout management)
* **Architecture**: Clean Architecture + MVVM (Model-View-ViewModel)
* **Modularization**: Multi-module configuration (`:presentation`, `:domain`, `:data`)
* **Asynchronous Flow**: Kotlin Coroutines & Advanced Reactive Streams (`StateFlow`, `SharedFlow`)
* **Dependency Injection**: Hilt / Dagger (Scoped dependency injection tree management)
* **Image Loading**: Coil (Platform contexts)

---

## 📦 Data Flow Architecture

Even though the app processes static mock structures internally, the data flow strictly respects professional, production-grade enterprise requirements:

1. **Trigger**: The presentation layer UI hooks into a lifecycle-aware state stream.
2. **Request**: The screen's `ViewModel` calls an explicit structural business `UseCase`.
3. **Execution**: The `UseCase` asks the `Repository` interface for localized models.
4. **Implementation**: The underlying `RepositoryImpl` fetches raw data from a simulated asynchronous `Api` layer data source.
5. **Mapping**: Raw `UserDto` payloads are passed through internal mapping classes to convert data frameworks into immutable pure domain `User` models before traveling backward to the UI layer.

```text
[UI Screen] ──(Observe State)──► [ViewModel] ──(Invoke)──► [UseCase]
                                                               │
                                                               ▼
[Data Source] ──► [UserDto] ──(Mapper)──► [User Model] ◄── [Repository]

```

---


## 📂 Project Directory Structure

```text
├── app
├── data
│   └── src/main/java/com/wallet/data
│       ├── api         # Simulated mock API engines with artificial network delay
│       ├── datasource  # Local hardcoded static mock lists and profiles
│       ├── mapper      # Extension functions converting DTOs -> Domain Models
│       ├── model       # JSON/DTO structured data classes (e.g., UserDto, WalletDto)
│       └── repository  # Concrete implementations of Domain Repository interfaces
│
├── domain
│   └── src/main/java/com/wallet/domain
│       ├── model       # Pure immutable business models used by UI and UseCases
│       ├── repository  # Abstract structural interface blueprints
│       └── usecase     # Single-responsibility business units (e.g., GetUserProfileUseCase)
│
└── presentation
    └── src/main/java/com/wallet/presentation
        ├── components  # Reusable UI widgets (e.g., WalletOverviewCard, NearbyMerchantsSection)
        ├── screens     # Root compose layouts (e.g., HomeScreen, ProfileScreen)
        └── viewmodel   # StateFlow view state management tracking Hilt ViewModels

```

---

## 🚀 Highlights & Advanced Implementations

### Edge-to-Edge System Architecture

The application runs full immersive window properties using `enableEdgeToEdge()`. Dynamic window offsets are handled gracefully inside custom topbars using specialized compose modifiers:

```kotlin
modifier = Modifier
    .statusBarsPadding()
    .windowInsetsPadding(WindowInsets.systemBars.only(WindowInsetsSides.Horizontal))

```

This guarantees UI components, titles, and custom notifications adjust padding automatically without being clipped by screen camera notches or system navigation bars during screen landscape rotations.

### Single-Scroll Flat Grid Mechanics

To achieve high-performance rendering across legacy devices, the Dashboard uses a single unified `LazyVerticalGrid` optimized with custom layout span configurations:

```kotlin
span = { GridItemSpan(maxLineSpan) }

```

This flattens complex view elements (Banners, Headers, and Horizontal rows) into one shared scroll context to avoid memory leaks or layout nesting issues.

---

## 📝 Key Engineering Assumptions

During the scoping and architectural design phases of this digital wallet application, the following engineering assumptions and structural constraints were established:

* **Bypassed Network Stack (Zero HTTP Overhead)**: The application assumes a completely offline, self-contained environment for architectural evaluation. The `Api` component does not open active network sockets or initialize Retrofit/Ktor clients; instead, it intercepts requests locally and pulls raw data arrays directly from the internal `Data Sources` collections, serving as a high-speed simulated server.
* **Simulated Async Latency**: To accurately mimic production-grade asynchronous behaviors, the local API wrapper forces thread switching using Kotlin Coroutine dispatchers (`Dispatchers.IO`) and manual delay sequences (`500ms` - `1500ms`). This allows the architecture to test transient UI states (Loading, Shimmer rendering, and Content Success transitions) without deploying an actual remote backend server.
* **Transient Memory State (In-Memory Isolation)**: The structural datasets declared inside the local data sources operate exclusively as static, read-only structures mirroring a finalized database snapshot. Any state updates, toggle preferences, or interactive changes performed in the presentation UI layer are isolated strictly within the active `ViewModel` memory space and do not write back or alter the underlying mock arrays.
* **Production-Grade APK Footprint Optimization**: To guarantee a highly lightweight and optimized compilation size, no heavy visual media assets (such as vendor logos or promo banners) are bundled inside the app's local drawable or raw asset paths. Instead, all graphic payloads are hosted remotely and streamed on-demand from production CDNs (*Picsum / Unsplash*) using the **Coil** image loading library.
* **Single-Activity Architecture Enforced**: In strict alignment with modern Android development standards, the application eliminates legacy XML layouts and multiple activity weights. The single `MainActivity` serves purely as an entry-point viewport container to mount the root Jetpack Compose canvas and establish the Hilt dependency graph.



## ⏱️ Development Time Breakdown (Time Spent)

The design, modular isolation, and code implementation of this project took approximately **18.0 Hours** of active development time, segmented as follows:

| Development Phase | Key Tasks Executed | Time Spent |
| :--- | :--- | :--- |
| **Architectural Setup** | Multi-module Gradle routing configuration, Hilt dependency tree setups, and `.gitignore` safety mapping. | `2.5 Hours` |
| **Domain Layer Formulation** | Modeling pure data structures, declaring use-case bounds, and defining repository abstract contracts. | `3.0 Hours` |
| **Data Simulation Engineering** | Constructing static Data Sources, writing unidirectional model mappers, and designing the coroutine-based simulated network API latency wrapper. | `4.5 Hours` |
| **Presentation Componentry** | Drafting Jetpack Compose layout engines, flattening the custom `LazyVerticalGrid` spans, and resolving landscape window inset bugs. | `6.0 Hours` |
| **Testing & Review** | Recomposition performance checks, layout tracking across multiple screen sizes, and documentation compilation. | `2.0 Hours` |
| **Total Estimated Effort** | | **`18.0 Hours`** |


## 🛠 Setup & Run Instructions

1. Clone this repository to your local directory machine:
```bash
git clone https://github.com/RxSajib/Digital-Wallet

```


2. Open the project folder structure inside **Android Studio**.
3. Let Gradle sync and download relevant project files automatically.
4. Select the `:app` configuration task layer and click **Run** to launch the mock application on an emulator or a connected physical test device.
