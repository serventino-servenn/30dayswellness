# 30 days Fitness app
A simple Android app built with Jetpack Compose as part of the [Android Basics with Compose Codelab.](https://developer.android.com/courses/pathways/android-basics-compose-unit-3-pathway-3).
The app displays a list of 30 daily fitness exercises. Each exercise is presented in a Material Design card with an expandable section that reveals more information.

## What I learned
- Applying Material Design in Compose
- Creating a custom theme with fonts and colors
- Implementing a Top App Bar
- Designing a scrollable list using LazyColumn,LazyVerticalGrid,etc
- Structuring data with Kotlin data classes
- Building interactive Material Cards
- Adding animations 
- Writing instrumented tests for UI components

## Screenshots 
<p align="center">
    <img src="https://github.com/user-attachments/assets/b344d69c-1aea-458c-828f-be362ca3446d" width="300"/>
   <img src="https://github.com/user-attachments/assets/fd56afd3-3b89-4348-947e-b6dd52ca8a78" width="300"/>
</p>


## Testing
The main test focuses on the functionality of the icon button inside each card.When clicked, the icon is expected to reveal additional content within the card.

Note:
The current test only assert the icon’s behavior, not the actual revealed content,because:

- Each card in the list displays similar UI components.

- Asserting specific card content would require assigning a unique identifier (e.g., testTag) to each card's dynamic content.

- This was intentionally left out to keep the UI code minimal and focused on Compose interaction patterns.

### Test verified behavior:

Clicking the icon changes the expanded/collapsed state.

The UI updates to reflect the state change via icon rotation or layout change.

## Getting started
1. Clone the repository
   ```bash
   git clone https://github.com/serventino-servenn/30dayswellness.git
    
2. Open project in Android Studio 
3. Run the app on an emulator or physical device 
