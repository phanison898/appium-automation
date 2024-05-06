package com.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.reports.ExtentTestManager;

/**
 * 
 * @author Phanison
 * @since 30/04/2024
 * @github_username phanison898
 * 
 **/

public class LoggerUtil {

	private WebDriver driver = null;

	public LoggerUtil(WebDriver driver) {

		this.driver = driver;
	}

	public void start(String message) {

		ExtentTestManager.getTest().info(message);
		consoleLog("Start", message);
	}

	public void end(String message) {

		ExtentTestManager.getTest().info(message);
		consoleLog("End", message);
	}

	public void info(String message) {

		ExtentTestManager.getTest().info(message);
		consoleLog("Info", message);
	}

	public void pass(String message) {

		ExtentTestManager.getTest().pass(message);
		consoleLog("Pass", message);
	}

	public void fail(String message) {

		ExtentTestManager.getTest().fail(message);
		consoleLog("Fail", message);
	}

	public void skip(String message) {

		ExtentTestManager.getTest().skip(message);
		consoleLog("Skip", message);
	}

	public void warning(String message) {

		ExtentTestManager.getTest().warning(message);
		consoleLog("Warning", message);
	}

	public void start(String message, boolean needScreenshot) {

		if (!needScreenshot) {
			start(message);
			return;
		}

		ExtentTestManager.getTest().info(message,
				MediaEntityBuilder.createScreenCaptureFromPath(new ScreenshotUtil(driver).capture()).build());
		consoleLog("Start", message);
	}

	public void end(String message, boolean needScreenshot) {

		if (!needScreenshot) {
			end(message);
			return;
		}

		ExtentTestManager.getTest().info(message,
				MediaEntityBuilder.createScreenCaptureFromPath(new ScreenshotUtil(driver).capture()).build());
		consoleLog("End", message);
	}

	public void info(String message, boolean needScreenshot) {

		if (!needScreenshot) {
			info(message);
			return;
		}

		ExtentTestManager.getTest().info(message,
				MediaEntityBuilder.createScreenCaptureFromPath(new ScreenshotUtil(driver).capture()).build());
		consoleLog("Info", message);
	}

	public void pass(String message, boolean needScreenshot) {

		if (!needScreenshot) {
			pass(message);
			return;
		}

		ExtentTestManager.getTest().pass(message,
				MediaEntityBuilder.createScreenCaptureFromPath(new ScreenshotUtil(driver).capture()).build());
		consoleLog("Pass", message);
	}

	public void fail(String message, boolean needScreenshot) {

		if (!needScreenshot) {
			fail(message);
			return;
		}

		ExtentTestManager.getTest().fail(message,
				MediaEntityBuilder.createScreenCaptureFromPath(new ScreenshotUtil(driver).capture()).build());
		consoleLog("Fail", message);
	}

	public void skip(String message, boolean needScreenshot) {

		if (!needScreenshot) {
			skip(message);
			return;
		}

		ExtentTestManager.getTest().skip(message,
				MediaEntityBuilder.createScreenCaptureFromPath(new ScreenshotUtil(driver).capture()).build());
		consoleLog("Skip", message);
	}

	public void warning(String message, boolean needScreenshot) {

		if (!needScreenshot) {
			warning(message);
			return;
		}

		ExtentTestManager.getTest().warning(message,
				MediaEntityBuilder.createScreenCaptureFromPath(new ScreenshotUtil(driver).capture()).build());
		consoleLog("Warning", message);
	}

	public void matchLogType(LogType type, String message) {

		switch (type.toString()) {
		case "start":
			info(message);
			break;
		case "end":
			end(message);
			break;
		case "info":
			info(message);
			break;
		case "pass":
			pass(message);
			break;
		case "fail":
			fail(message);
			break;
		case "skip":
			skip(message);
			break;
		case "warning":
			warning(message);
			break;
		default:
			info(message);
			break;
		}
	}

	public void matchLogType(LogType type, String message, boolean needScreenshot) {

		switch (type.toString()) {
		case "start":
			info(message, needScreenshot);
			break;
		case "end":
			end(message, needScreenshot);
			break;
		case "info":
			info(message, needScreenshot);
			break;
		case "pass":
			pass(message, needScreenshot);
			break;
		case "fail":
			fail(message, needScreenshot);
			break;
		case "skip":
			skip(message, needScreenshot);
			break;
		case "warning":
			warning(message, needScreenshot);
			break;
		default:
			info(message, needScreenshot);
			break;
		}
	}

	private void consoleLog(String logType, String message) {

		SimpleDateFormat format = new SimpleDateFormat("[hh:mm:ss]");
		Date date = new Date();
		System.out.println(format.format(date) + "[" + logType + "] " + message);
	}

}
