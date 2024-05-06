package com.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 
 * @author Phanison
 * @since 30/04/2024
 * @github_username phanison898
 * 
 **/

public class JSUtil {

	private JavascriptExecutor js = null;

	public JSUtil(WebDriver driver) {
		js = (JavascriptExecutor) driver;
	}

	public void click(WebElement element) {
		js.executeScript("arguments[0].click();", element);
	}

	public void enter(WebElement element, String text) {
		js.executeScript(String.format("arguments[0].value = '%s';", text), element);
	}

	public String getText(WebElement element) {
		return (String) js.executeScript("return arguments[0].textContent;", element);
	}

	public String getTextAttribute(WebElement element, String attribute) {
		return (String) js.executeScript(String.format("return arguments[0].getAttribute('%s');", attribute), element);
	}

	public void scrollToElement(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void scroll(int pixels) {
		js.executeScript(String.format("window.scrollTo(0, %s)", pixels));
	}

	public void scrollToTop() {
		js.executeScript("window.scrollTo(0, 0)");
	}

	public void scrollToBottom() {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void highLight(WebElement element) {
		String borderWidth = "2px";
		String borderType = "solid";
		String borderColor = "green";
		js.executeAsyncScript(
				String.format("arguments[0].style.border = '%s %s %s';", borderWidth, borderType, borderColor),
				element);
	}

	public void unHighLight(WebElement element) {
		js.executeScript("arguments[0].style.border = '';", element);
	}

}
