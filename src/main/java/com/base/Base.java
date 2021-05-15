package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base {
	
	public static AndroidDriver driver = null;
	public static Properties props = null;
	final String server = "http://localhost:4723/wd/hub";
	final String configFilePath = System.getProperty("user.dir") + "/src/main/resources/config.properties";
	
	public Base() {
		props = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(new File(configFilePath));
			props.load(fis);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@BeforeMethod
	public void setup() {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.UDID, props.get("udid"));
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, props.get("deviceName"));
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, props.get("platformName"));
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, props.get("platformVersion"));
		cap.setCapability("appPackage", props.get("appPackage"));
		cap.setCapability("appActivity", props.get("appActivity"));
		
		URL url = null;
		try {
			url = new URL(server);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		driver = new AndroidDriver(url,cap);
	}
	
	@AfterMethod
	public void tear() {
		driver.quit();
	}

}
