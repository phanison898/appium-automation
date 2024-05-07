package com.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utils.InteractionsUtil;

public class ProductScreen extends InteractionsUtil {

	private WebDriver driver = null;

	private String addToCartVisibileText = "Add To Cart";

	private By addToCartButton = By.xpath("//android.widget.TextView[@text='" + addToCartVisibileText + "']");

	private By cartIcon = By.xpath("//android.view.ViewGroup[@content-desc='cart badge']/android.widget.ImageView");

	private By checkOutButton = By.xpath("//android.view.ViewGroup[@content-desc='Proceed To Checkout button']");

	public ProductScreen(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public LoginScreen addToCart() {
		scrollToElement(addToCartVisibileText);
		tap(addToCartButton, "Tapped on Add To Cart Button", true);
		tap(cartIcon, "Tapped on Cart Icon", true);
		tap(checkOutButton, "Tapped on Check Out button", true);

		return new LoginScreen(driver);
	}

}
