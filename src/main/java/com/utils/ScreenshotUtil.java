package com.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.config.Paths;

/**
 * 
 * @author Phanison
 * @since 30/04/2024
 * @github_username phanison898
 * 
 **/

public class ScreenshotUtil {

	private WebDriver driver = null;

	public ScreenshotUtil(WebDriver driver) {

		this.driver = driver;
	}

	public String capture() {

		String relativePath = Paths.SCREENSHOTS_REL_DIR + "/ss_" + System.currentTimeMillis() + ".png";

		String absolutePath = Paths.REPORT_DIR + "/" + relativePath;

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(absolutePath);

		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return relativePath;

	}

	public String capture(String screenshotFileName) {

		String relativePath = Paths.SCREENSHOTS_REL_DIR + "/" + screenshotFileName + ".png";

		String absolutePath = Paths.REPORT_DIR + "/" + relativePath;

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(absolutePath);

		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return relativePath;
	}

}
