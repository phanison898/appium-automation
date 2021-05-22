package com.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.base.Base;
import com.listeners.TestListener;

public class TestUtil extends Base {

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

	public static void log(String message) {
		ExtentTest test = new TestListener().test.get();
		test.log(Status.PASS, message);

		String path = captureScreenshot();
		test.log(Status.INFO, (Markup) MediaEntityBuilder.createScreenCaptureFromPath(path));
	}
}
