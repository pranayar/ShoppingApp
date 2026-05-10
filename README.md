# Jetpack Compose Shopping App

## Project Overview
In this exercise, a mobile shopping application has been created using Kotlin and Jetpack Compose. The app allows users to view a list of products (mainly shoes), click on them and view detailed information, add them to a shopping cart and lastly view the cart and calculate the total cost. No database has been used, instead a simple in-memory list was implemented.

## Features
- Product listing in a grid layout
- Product detail screen with image(icons used for demo) and pricing
- Add to cart functionality
- Quantity management (+ / controls) −
- Dynamic cart with total price calculation
- Navigation between screens (Home, Detail, Cart)
- Modern UI using Jetpack Compose

## Technologies Used
- Kotlin
- Jetpack Compose
- Material 3 UI
- ViewModel (State Management)
- Navigation Compose

## Application Screens

### 1. Home Screen
The purpose of this is just to display a grid of products along with the images, names and prices. The users can then tap on any of the products to view more details.

### 2. Detail Screen
After clicking on a product on home screen, it shows the detail screen which contains information of a selected product such as the product image, name and price and the quantity selector.

### 3. Cart Screen
This screen shows all items in the cart and includes the product names, the quantity selected and the total price of all items.

## Project Structure
The project structure has a data model for the products, a view model which handles the logic as well as the state management. The UI has a reusable component which is ProductCard and 3 screens which are Home, detail and cart. Lastly the main activity final controls the navigation setup.

## How to Run the Project
1. Clone or download the project from GitHub (link: https://github.com/pranayar/ShoppingApp )
2. Open the project in Android Studio
3. Sync Gradle dependencies
4. Run the app on an emulator or Android device

## Screenshots

### 1. Home Screen
 <img width="558" height="1030" alt="image" src="https://github.com/user-attachments/assets/9e870e57-73f5-47c8-bafd-13fed8e9cb01" />

### 2. Detail Screen
 <img width="472" height="733" alt="image" src="https://github.com/user-attachments/assets/fb231f3e-8f38-43a8-9947-bfdd3e6eca68" />

### 3. Cart Screen
<img width="473" height="658" alt="image" src="https://github.com/user-attachments/assets/3b523e4e-c9ab-4468-ab6e-d46563cde5bc" />
<img width="573" height="1014" alt="image" src="https://github.com/user-attachments/assets/d940dccc-e44f-4139-aa81-6f4ada5bbe42" />

## GitHub Repository
The Github link is https://github.com/pranayar/ShoppingApp Android studio’s inbuilt commit features were used after linking the repo.

## Conclusion
This exercise demonstrates the use of Jetpack Compose to build a modern Android shopping application. It focuses on clean UI design, proper state management, and smooth user interaction without using a database.
 demonstrates the use of Jetpack Compose to build a modern Android shopping application. It focuses on clean UI design, proper state management, and smooth user interaction without using a database.

