package com.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utils.InteractionsUtil;

public class LoginScreen extends InteractionsUtil {

	private WebDriver driver = null;

	private By usernameInput = By.xpath("//android.widget.EditText[@content-desc='Username input field']");

	private By passwordInput = By.xpath("//android.widget.EditText[@content-desc='Password input field']");

	private By loginButton = By.xpath("//android.view.ViewGroup[@content-desc='Login button']");

	public LoginScreen(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public CheckOutScreen login(String username, String password) {

		enter(usernameInput, username, String.format("Entered username = %s", username));
		enter(passwordInput, password, String.format("Entered password = %s", password), true);
		tap(loginButton, "Tapped on Login Button", true);

		return new CheckOutScreen(driver);
	}
}
