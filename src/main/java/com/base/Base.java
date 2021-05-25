package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base {

	public static AndroidDriver<WebElement> driver = null;
	private Properties testConfig = null;
	private final String testConfigFilePath = System.getProperty("user.dir")
			+ "/src/main/resources/test-config.properties";

	public Base() {
		testConfig = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(new File(testConfigFilePath));
			testConfig.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@BeforeMethod
	public void setup() {
		launchDevice();
	}

	@AfterMethod
	public void tear() {
		driver.quit();
	}

	private void launchDevice() {
		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability(MobileCapabilityType.UDID, getTestConfigValue("udid"));
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, getTestConfigValue("deviceName"));
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, getTestConfigValue("platformName"));
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, getTestConfigValue("platformVersion"));
		cap.setCapability("appPackage", getTestConfigValue("appPackage"));
		cap.setCapability("appActivity", getTestConfigValue("appActivity"));

		URL url = null;
		try {
			url = new URL(getTestConfigValue("appium-server"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		driver = new AndroidDriver<WebElement>(url, cap);
	}

	private String getTestConfigValue(String key) {
		return testConfig.getProperty(key);
	}

}
