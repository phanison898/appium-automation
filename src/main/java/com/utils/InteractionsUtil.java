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

/**
 * 
 * @author Phanison
 * @since 30/04/2024
 * @github_username phanison898
 * 
 **/

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

	public void click(By locator) {
		getElement(locator).click();
	}

	public void click(By locator, String log) {
//		getElement(locator).click();
		jsUtil.click(getElement(locator));
		logger.info(log);
	}

	public void click(By locator, String log, boolean needScreenshot) {
		getElement(locator).click();
		logger.info(log, needScreenshot);
	}

	public void click(By locator, String log, LogType type) {
		getElement(locator).click();
		logger.matchLogType(type, log);
	}

	public void click(By locator, String log, LogType type, boolean needScreenshot) {
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
//		element.clear();
//		element.sendKeys(text);
		jsUtil.enter(element, text);
		logger.info(log);
	}

	public void enter(By locator, String text, String log, boolean needScreenshot) {
		WebElement element = getElement(locator);
//		element.clear();
//		element.sendKeys(text);
		jsUtil.enter(element, text);
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

}
