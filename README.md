# Compose Tutorial Project

This project demonstrates advanced usage of Jetpack Compose in Android, including state management, derived state, interaction sources, and side effects.

## Features

- **LazyVerticalGrid**: Displays a grid of items with custom spacing and colors.
- **Form Validation**: Uses `derivedStateOf` to validate email and password fields in real-time.
- **Interaction Source Example**: Shows how to detect press interactions on UI elements.
- **LaunchedEffect Example**: Demonstrates side effects and timers in Compose.

## Structure

- `Advance/MyInteractionSource.kt`: Contains composable functions for form validation, interaction detection, and side effects.
- Main composable functions:
  - `MyInteractionSource`
  - `DerivatedStateExample`
  - `IsPressedInteractionExample`
  - `LaunchEffectExample`

## Getting Started

1. Clone the repository.
2. Open in Android Studio.
3. Ensure your Kotlin version matches the dependencies (preferably 2.2.0).
4. Build and run the app.

## Requirements

- Android Studio (Giraffe or newer)
- Kotlin 2.2.0
- Jetpack Compose

## License

This project is for educational purposes.
