package com.base.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.base.AndroidDriverManager;
import com.base.DriverManager;
import com.base.PlatformType;
import com.config.Config;

public class BaseTest {

	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	@Parameters({ "env" })
	@BeforeSuite
	public void beforeSuite(@Optional("local") String env) {
		Config.setEnv(env);
	}

	@Parameters({ "platform" })
	@BeforeMethod
	public void setup(@Optional("android") String platform) {
		Config.setPlatformName(platform);

		DriverManager driverManager = null;

		switch (Config.getPlatformName()) {
		case PlatformType.ANDROID:
			driverManager = new AndroidDriverManager();
			break;
		case PlatformType.IOS:
			break;
		default:
			driverManager = new AndroidDriverManager();
			break;
		}

		URL url = null;
		try {
			url = new URL(Config.getAppiumServerUrl());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		driverManager.init(url);
		driver.set(driverManager.get());
	}

	@AfterMethod
	public void quit() {
		driver.get().quit();
	}

	public WebDriver getDriver() {
		return driver.get();
	}

}
