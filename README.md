# runtime-dependency
Gradle runtime dependency demo for Firefox for Android

This project has two modules:

1. An Android app that reads a file from the sdcard.
1. A simple module that defines an artifact with the file to read by the Android app.

The simple module does not do anything and does not depend on the Android module.

The Android module depends on the simple module only for creating a build task `pushOmnijar`.

## Usage

```
./gradlew installWithOmnijar
```
This installs the debug android version of the Android app, pushes the file to the sdcard and restarts the Android app.

```
./gradlew pushOmnijar
```
Update the file to be read and restarts the Android app.
