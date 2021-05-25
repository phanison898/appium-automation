package com.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.base.Base;
import com.listeners.TestListener;

public class TestUtil extends Base {

	public static ExtentTest test = null;

	public TestUtil() {
		super();
		TestListener testListener = new TestListener();
		test = testListener.test;
	}

	private static String captureScreenshot() {
		TakesScreenshot ts = (TakesScreenshot) driver;
		String imagePath = System.getProperty("user.dir") + "/target/screenshots/" + System.currentTimeMillis()
				+ ".png";
		File dest = new File(imagePath);
		File src = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return imagePath;
	}

	public static void Log(String message) {
		test.log(Status.INFO, message);
	}

	public static void log(String message) {
		String path = captureScreenshot();
		test.log(Status.INFO, message, MediaEntityBuilder.createScreenCaptureFromPath(path).build());
	}
}
