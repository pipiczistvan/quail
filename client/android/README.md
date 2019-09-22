# Quail android client

This is kotlin based android client for quail server.

## Setup

To generate debug application run the following command:

 - `gradlew clean assembleDebug`

## Issues

The project can only build with JVM 1.8 so if the project does not compile in `IntelliJ IDEA` please make sure the below settings are applied:

 - `File/Settings/Build, Execution, Deployment/Build Tools/Gradle/Gradle JVM` is 1.8
 - `File/Project Structure/SDKs` remove any JDK other than 1.8
