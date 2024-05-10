package com.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

public class AppGestures extends Gestures {

	private WebDriver driver;

	public AppGestures(WebDriver driver) {

		this.driver = driver;
	}

	@Override
	public void swipeUp(WebElement element) {

		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "direction", "up", "percent", 0.75));

	}

	@Override
	public void swipeDown(WebElement element) {

		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
				((RemoteWebElement) element).getId(), "direction", "down", "percent", 0.75));
	}

	@Override
	public void swipeLeft(WebElement element) {

		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
				((RemoteWebElement) element).getId(), "direction", "left", "percent", 0.75));
	}

	@Override
	public void swipeRight(WebElement element) {

		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
				((RemoteWebElement) element).getId(), "direction", "right", "percent", 0.75));
	}

	@Override
	public void click(WebElement element) {

		((JavascriptExecutor) driver).executeScript("mobile: clickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId()));
	}

	@Override
	public void longClick(WebElement element) {

		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId()));
	}

	@Override
	public void doubleClick(WebElement element) {

		((JavascriptExecutor) driver).executeScript("mobile: doubleClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId()));

	}

	@Override
	public void drag(WebElement element) {

		((JavascriptExecutor) driver).executeScript("mobile: dragGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "endX", 100, "endY", 100));
	}

	@Override
	public void fling(WebElement element) {

		boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: flingGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "direction", "down", "speed", 500));
	}

	@Override
	public void pinchOpen(WebElement element) {

		((JavascriptExecutor) driver).executeScript("mobile: pinchOpenGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "percent", 0.75));
	}

	@Override
	public void pinchClose(WebElement element) {

		((JavascriptExecutor) driver).executeScript("mobile: pinchCloseGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "percent", 0.75));

	}

	@Override
	public void scroll(WebElement element) {

		boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture",
				ImmutableMap.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent",
						1.0));

	}
}
