package com.base.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.base.AndroidDriverManager;
import com.base.DriverManager;
import com.base.PlatformType;
import com.config.Config;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {

	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public static AppiumDriverLocalService service = null;

	@Parameters({ "env" })
	@BeforeSuite
	public void beforeSuite(@Optional("local") String env) {

		env = System.getProperty("env") != null ? System.getProperty("env") : env;

		Config.setEnv(env);

		if (Config.getEnv().equals("local")) {

			AppiumServiceBuilder builder = new AppiumServiceBuilder();
			builder.withIPAddress("127.0.0.1");
			builder.usingPort(4723);

			service = AppiumDriverLocalService.buildService(builder);

			service.start();

		}
	}

	@AfterSuite
	public void afterSuite() {
		if (service != null) {
			service.stop();
		}
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
