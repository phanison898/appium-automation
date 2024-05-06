package com.base;

import java.net.URL;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

import com.config.Config;

import io.appium.java_client.android.AndroidDriver;

public class AndroidDriverManager implements DriverManager {

	private AndroidDriver driver = null;

	@Override
	public void init(URL url) {
		
		MutableCapabilities caps = new MutableCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("appium:app", "storage:filename=Android-MyDemoAppRN.1.3.0.build-244.apk");
		caps.setCapability("appium:deviceName", "Android GoogleAPI Emulator");
		caps.setCapability("appium:platformVersion", "12.0");
		caps.setCapability("appium:automationName", "UiAutomator2");

		MutableCapabilities sauceOptions = new MutableCapabilities();
		sauceOptions.setCapability("username", Config.getUsername());
		sauceOptions.setCapability("accessKey", Config.getAccessKey());
		sauceOptions.setCapability("build", "appium-build-YO9EI");
		sauceOptions.setCapability("name", "Smoke Testing");
		sauceOptions.setCapability("deviceOrientation", "PORTRAIT");
		caps.setCapability("sauce:options", sauceOptions);

		driver = new AndroidDriver(url, caps);
	}

	@Override
	public WebDriver get() {

		return driver;
	}

}
