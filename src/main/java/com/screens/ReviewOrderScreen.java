package com.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utils.InteractionsUtil;

public class ReviewOrderScreen extends InteractionsUtil {

	private WebDriver driver = null;

	private By placeOrderButton = By.xpath("//android.view.ViewGroup[@content-desc='Place Order button']");

	public ReviewOrderScreen(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public EndScreen tapPlaceOrderButton() {

		tap(placeOrderButton, "Tapped on Place Order Button", true);

		return new EndScreen(driver);

	}

}
