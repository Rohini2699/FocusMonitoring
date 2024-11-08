# Focus Monitoring Mini-App

## Overview
The Focus Monitoring Mini-App is a simplified Android application that simulates EEG-based focus score monitoring. It includes a simulated BLE (Bluetooth Low Energy) device scan and connection flow to demonstrate UI interactions and asynchronous programming. The app is developed using **Jetpack Compose**, **Kotlin Coroutines**, and adheres to **Clean Architecture** principles.

## Features
- **Real-time Focus Score Monitoring**: Updates a simulated focus score between 0 and 100 every 5 seconds.
- **Start/Stop Monitoring**: A button to toggle monitoring on and off.
- **Simulated BLE Interaction**: A basic flow to simulate BLE scanning and connecting to a device.
- **Responsive UI**: Built with Jetpack Compose for a modern, clean user experience.
- **Modular Architecture**: Follows Clean Architecture principles for better code organization and maintainability.

## Tech Stack
- **Kotlin**
- **Jetpack Compose** for declarative UI.
- **Kotlin Coroutines** for managing background tasks.
- **StateFlow** for reactive state management in ViewModel.
- **Material Design 3** for UI components and theming.


## How It Works
### BLE Simulation
- **BLE Scanning**: The app simulates a BLE device scan with a 3-second delay to mimic real scanning.
- **Connection State**: After scanning, the app simulates a successful BLE connection and displays a message.
- **Disconnection**: Users can simulate disconnecting from the BLE device.

### Focus Score Simulation
- The app generates a random focus score between 0 and 100 every 5 seconds to mimic real-time data updates.
- Users can start and stop the focus monitoring using the provided button.

## Usage
1. **Start/Stop Monitoring**:
   - Press the "Start Monitoring" button to begin monitoring.
   - Press "Stop Monitoring" to stop.
2. **BLE Simulation**:
   - Press "Start BLE Scan" to simulate scanning.
   - The button displays "Scanning..." during the simulation.
   - After connecting, press "Disconnect BLE" to reset the connection state.

## Installation and Setup
1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/focus-monitoring-mini-app.git
    ```
2. Open the project in **Android Studio**.
3. Ensure your `compileSdkVersion` and `targetSdkVersion` are set to **35**.
4. Build and run the app on an emulator or physical device.

## Permissions
Ensure that the following permissions are added in `AndroidManifest.xml` for BLE simulation:
```xml
<uses-permission android:name="android.permission.BLUETOOTH" />
<uses-permission android:name="android.permission.BLUETOOTH_ADMIN" />
<uses-permission android:name="android.permission.BLUETOOTH_CONNECT" />

