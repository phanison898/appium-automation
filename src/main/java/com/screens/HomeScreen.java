package com.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utils.InteractionsUtil;

public class HomeScreen extends InteractionsUtil {

	private WebDriver driver = null;

	private By product = By
			.xpath("(//android.view.ViewGroup[@content-desc='store item'])[1]/android.view.ViewGroup[1]");

	private By title = By
			.xpath("//android.widget.TextView[@content-desc='store item text' and @text='Sauce Labs Backpack']");

	public HomeScreen(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public ProductScreen tapOnProduct() {

		logger.info("Opened My Demo App", true);

		tap(product, "Tapped on product", true);
		return new ProductScreen(driver);
	}

}
