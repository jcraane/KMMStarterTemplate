# Kotlin Mobile Multiplatform starter

## Starting with Xcode/AppCode

### AppCode

#### Prerequisites
- Make sure you have the AppCode Kotlin Multiplatform installed
- Cocoapods should be installed at least version -> `1.11.3`
- When the gradle build fails and Cocoapods tells you to make sure your terminal is in `export LANG=en_US.UTF-8` mode. Add it to `~/.profile`
  - When running zshell, add the following to `~/.zprofile`
    ```shell
    if [[ -z "$LC_ALL" ]]; then
      export LC_ALL='en_US.UTF-8'
    fi
    ```
  - Then RESTART AppCode to make the UTF-8 changes apply to the terminal AppCode is using

### Opening the iOS project
Open the `iosApp.xcworkspace` in AppCode/Xcode and you should be able to run it.

## Todo

Add logging library
