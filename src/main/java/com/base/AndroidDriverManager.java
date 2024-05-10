package com.base;

import java.net.URL;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

import com.config.Config;
import com.config.Paths;

import io.appium.java_client.android.AndroidDriver;

public class AndroidDriverManager implements DriverManager {

	private AndroidDriver driver = null;

	@Override
	public void init(URL url) {

		MutableCapabilities caps = new MutableCapabilities();

		caps.setCapability("platformName", "Android");
		caps.setCapability("appium:automationName", "UiAutomator2");

		if (Config.getEnv().equals("local")) {

			caps.setCapability("appium:app", Paths.APP_PATH);
			caps.setCapability("appium:deviceName", "emulator-5554");
			caps.setCapability("appium:platformVersion", "9.0");

		} else if (Config.getEnv().equals("cloud")) {

			caps.setCapability("appium:app", "storage:filename=Android-MyDemoAppRN.1.3.0.build-244.apk");
			caps.setCapability("appium:deviceName", "Android GoogleAPI Emulator");
			caps.setCapability("appium:platformVersion", "12.0");

			MutableCapabilities sauceOptions = new MutableCapabilities();
			sauceOptions.setCapability("username", Config.getUsername());
			sauceOptions.setCapability("accessKey", Config.getAccessKey());
			sauceOptions.setCapability("build", "appium-build-YO9EI");
			sauceOptions.setCapability("name", "Smoke Testing");
			sauceOptions.setCapability("deviceOrientation", "PORTRAIT");
			caps.setCapability("sauce:options", sauceOptions);

		}

		driver = new AndroidDriver(url, caps);

	}

	@Override
	public WebDriver get() {

		return driver;
	}

}
