### Appium Automation Framework

![](https://img.shields.io/github/languages/code-size/phanison898/appium-automation?style=flat-square)
![](https://img.shields.io/github/last-commit/phanison898/appium-automation?style=flat-square)
![](https://img.shields.io/github/languages/top/phanison898/appium-automation?style=flat-square)
![](https://img.shields.io/github/license/phanison898/appium-automation?style=flat-square)

---

#### 🚥 About

Appium-TDD-Framework designed and developped for automating mobile applications on both Android and iOS platforms using Java programming language. This framework leverages the power of Appium, an open-source tool for automating mobile applications, to provide a robust and scalable testing solution.

---

#### 📜 Tools

- Programming Language  : Java
- Test Framework        : TestNG
- Built Tool            : Maven
- Desing Pattern        : Page Object Model (POM)
- Extras                : Configured to automate local emulator (for android) as well as `Sauce Labs` cloud android device

---

#### ⛔ Pre-requisites

1. **Appium** installation
   - Install Node.js if not already installed
   - Install appium and appium-doctor using npm
   - Install UIAutomator2 driver using appium
---

#### ✅ How to make use of this repo?

1. Clone the repository
   ```bash
   git clone https://github.com/phanison898/appium-automation.git
   ```
2. CD into cloned directory
   ```bash
   cd /appium-automation
   ```
3. Create .env file with following key value pairs

   ```bash
       SAUCE_USERNAME=<your_sauce_labs_username>
       SAUCE_ACCESS_KEY=<your_sauce_labs_access_key>
       SAUCE_URL=<your_sauce_labs_appium_server_url>
   ```

4. Run the Maven command and start the automation

   ```bash
       mvn clean test -Denvironment=cloud
       or
       mvn clean test -Denvironment=local # if you have setup emulator
   ```
---
