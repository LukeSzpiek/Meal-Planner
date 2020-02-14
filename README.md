# Minimal JavaFX AndroidApp

A minimal working android app written in JavaFX.

## Prerequisites

* Java 8

## Commands

To run the desktop development version:
./gradlew run

To install the Android APK directly onto Android device:
./gradlew androidInstall

For the above command to work correctly, you must enable debugging on your phone - you can find how to do this by following this link:



## Crashes on phone

You may run into the situation where your app runs perfectly on your development machine, but when you install a version onto your device, it opens up to a black screen.

In this case, you will want to install 'adb', a tutorial of which can be found here: https://www.youtube.com/watch?v=vr0GLIufzkM

Then, connect your computer to your phone via USB, and type in your UNIX terminal 'adb logcat'.

If correctly install, you should see a log of device information.

Then, carry out the action that causes the black screen in your code. This could be on launch, or a crash later on in your program.

When the program crashes, the log will be displayed in your terminal.
