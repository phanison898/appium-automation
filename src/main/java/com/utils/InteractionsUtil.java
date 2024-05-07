package com.utils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.config.Config;

import io.appium.java_client.AppiumBy;

public class InteractionsUtil {

	private WebDriver driver = null;

	public LoggerUtil logger = null;

	public JSUtil jsUtil = null;

	public InteractionsUtil(WebDriver driver) {

		this.driver = driver;
		logger = new LoggerUtil(driver);
		jsUtil = new JSUtil(driver);
	}

	private WebElement wait(By locator) {
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(Config.getExplicitWaitTime()));
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	private WebElement getElement(By locator) {

		WebElement element = null;

		try {
			element = driver.findElement(locator);
		} catch (Exception e) {
			element = wait(locator);
		}

		return element;
	}

	private List<WebElement> getElements(By locator) {

		List<WebElement> element = null;

		try {
			element = driver.findElements(locator);
		} catch (Exception e) {
			WebElement ele = wait(locator);
			if (ele != null) {
				element = driver.findElements(locator);
			}
		}

		return element;
	}

	public boolean isDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	public void tap(By locator) {
		getElement(locator).click();
	}

	public void tap(By locator, String log) {
		getElement(locator).click();
		logger.info(log);
	}

	public void tap(By locator, String log, boolean needScreenshot) {
		getElement(locator).click();
		logger.info(log, needScreenshot);
	}

	public void tap(By locator, String log, LogType type) {
		getElement(locator).click();
		logger.matchLogType(type, log);
	}

	public void tap(By locator, String log, LogType type, boolean needScreenshot) {
		getElement(locator).click();
		logger.matchLogType(type, log, needScreenshot);
	}

	public void enter(By locator, String text) {
		WebElement element = getElement(locator);
		element.clear();
		element.sendKeys(text);
	}

	public void enter(By locator, String text, String log) {
		WebElement element = getElement(locator);
		element.clear();
		element.sendKeys(text);
		logger.info(log);
	}

	public void enter(By locator, String text, String log, boolean needScreenshot) {
		WebElement element = getElement(locator);
		element.clear();
		element.sendKeys(text);
		logger.info(log, needScreenshot);
	}

	public void enter(By locator, String text, String log, LogType type) {
		WebElement element = getElement(locator);
		element.clear();
		element.sendKeys(text);
		logger.matchLogType(type, log);
	}

	public void enter(By locator, String text, String log, LogType type, boolean needScreenshot) {
		WebElement element = getElement(locator);
		element.clear();
		element.sendKeys(text);
		logger.matchLogType(type, log, needScreenshot);
	}

	public String getText(By locator) {
		return getElement(locator).getText();
	}

	public String getAttribute(By locator, String attribute) {
		return getElement(locator).getAttribute(attribute);
	}

	public void pause(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void scrollToElement(String visibleText) {

		String query = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
				+ visibleText + "\").instance(0))";

		driver.findElement(AppiumBy.androidUIAutomator(query));
	}

}
