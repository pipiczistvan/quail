# Quail android client

This is kotlin based android client for quail server.

## Setup

To generate debug application run the following command:

 - `gradlew clean assembleDebug`

## Troubleshoot
1. The project can only build with JVM 1.8 so if the project does not compile in `IntelliJ IDEA` please make sure the below settings are applied:
    - `File/Settings/Build, Execution, Deployment/Build Tools/Gradle/Gradle JVM` is 1.8
    - `File/Project Structure/SDKs` remove any JDK other than 1.8
2. IntelliJ Idea does not see configure gradle in submodules.
    - Remove IntelliJ Idea configuration file: `${user.home}/.IntelliJIdea/config`
    - Execute `git clean -f -d` in project root directory.
    - Remove `.idea` and `.gradle` folders from project root directory.
    - Remove `${user.home}/.gradle` and `${user.home}/.m2` folders.
3. I get `ERROR: Cause: invalid type code: 00` in IntelliJ Idea.
    - Untick `Only sync active variant` in settings and retry sync.
4. I get `Unresolved reference: DaggerAppComponent`.
    - Run a `Build Project` to generate necessary Dagger files.