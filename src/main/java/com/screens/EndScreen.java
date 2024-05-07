package com.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utils.InteractionsUtil;

public class EndScreen extends InteractionsUtil {

	private WebDriver driver = null;

	private By checkoutCompleteText = By.xpath("//android.widget.TextView[@text='Checkout Complete']");

	private By continueShoppingButton = By.xpath("//android.view.ViewGroup[@content-desc='Continue Shopping button']");

	public EndScreen(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean isCheckOutCompleteTextDisplayed() {
		return isDisplayed(checkoutCompleteText);
	}

	public HomeScreen tapContinueShoppingButton() {
		tap(continueShoppingButton, "Tapped on Continue Shopping Button", true);
		return new HomeScreen(driver);
	}

}
