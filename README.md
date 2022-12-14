# payback-app

Application under test: PAYBACK - Karte und Coupons

Build: 22.08.0900

Binary: .apk


# Environment:

Device: Xiaomi Redmi Note 9

Android Version: 10

Platform: Windows

# Tools:

Gradle - 7.1

Appium server - 1.22.3

Appium client - 8.2.0

TestNg - 6.14.3 - unit testing framework

Log4j - 2.18.0 - logger

Allure - 2.8.1 - reporting tool

Lombok - 1.18.24 - tool to simplify work with POJO

gson - 2.9.1 - tool to work with Json objects

# Environment Setup: Windows
The list of required tools:
- Java JDK (1.8); setup JAVA_HOME environment variable
- Node.js
- Appium (NB: installed via NPM, not desktop UI version)

 npm install -g appium-doctor

 npm install -g appium

- Android Studio (SDK tools); 

setup ANDROID_HOME and ANDROID_SDK_ROOT environment variables
add to PATH:
%ANDROID_SDK_ROOT%\tools
%ANDROID_SDK_ROOT%\platform-tools
%ANDROID_SDK_ROOT%\emulator
%ANDROID_SDK_ROOT%\tools\bin

# How it works:
1. Testing tool gets appium config from resources and starts appium server on localhost on any free port
2. Details of device and app under testing parsed from jsons in resources and after app create driver session
3. Main flow of test starts NOTE: credentials of user do not shared in Git for security reasons, it requires additional Credentials class with card number and user password
4. After test finished app quits driver session and stops appium server
5. App generates report

# Link to found interesting things (issues??)
[Issues](https://docs.google.com/document/d/1EpEOXUw3E9fok7wQhicyhxiPZvG34C1Jh6xJMuxFWfo/edit)

# Timeline

- 9/7/2022 12:00 + 3 GMT - Start
- 12:00 - 12:15 - Add dependencies to project
- 12:15 - 13:00 - Set up environment and tools (VPN, Android Studio, Charles, Install Certificates (fruitless due to SSL pinning) Appium Server, Appium GUI, Appium Inspector, Add all needed environment variables)
- 13:30 - 14:00 - Application manual testing
- 14:00 - 15:10 - Set Up of Appium server automated start (had issues with deps and appium js)
- 15:10 - 16:30 - Create appium session for device (had issues with virtual device set up so took real one)
- 16:30 - 17:06 - Created base test with static methods to get app and device info
- 17:06 - 18:10 - Added few pages and draft of test
- 9/7/2022 12:15 - 13:52  - Continue work with pages and test
- 13:52 - 14:26 - Adding logging and reporting
- 14:26 - 15:04 - Add retry analyzer and hide device and app to test data jsons
- 15:04 - 15:37 - Polishing code, finishing readme, filing found issues

# What to improve:
- Find root cause of issue with starting session on virtual device, original error "de.payback.client.android" cannot be started
- Get access to test version of app with disabled security policies and finish login flow
- Test code at all because without full access it's ony a draft of test
- Add support of CI
- Hide credentials to any DB
- Add test listeners on fail (attach logs, screenshots??? to report)

