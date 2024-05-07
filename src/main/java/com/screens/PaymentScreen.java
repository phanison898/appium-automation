package com.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utils.InteractionsUtil;

public class PaymentScreen extends InteractionsUtil {

	private WebDriver driver = null;

	private By _fullNameInput = By.xpath("//*[contains(@content-desc,'Full Name* input field')]");

	private By cardNumberInput = By.xpath("//android.widget.EditText[@content-desc='Card Number* input field']");

	private By expireDateInput = By.xpath("//android.widget.EditText[@content-desc='Expiration Date* input field']");

	private By securityCodeInput = By.xpath("//android.widget.EditText[@content-desc='Security Code* input field']");

	private By reviewOrderButton = By.xpath("//android.view.ViewGroup[@content-desc='Review Order button']");

	public PaymentScreen(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public ReviewOrderScreen enterPaymentDetails(String fullName, String cardNumber, String expiryDate,
			String securityCode) {

		pause(2000);
		enter(_fullNameInput, fullName, String.format("Entered Full Name = %s", fullName));
		enter(cardNumberInput, cardNumber, String.format("Entered Card Number = %s", cardNumber));
		scrollToElement("Expiration Date*");
		enter(expireDateInput, expiryDate, String.format("Entered Expiry Date = %s", expiryDate));
		enter(securityCodeInput, securityCode, String.format("Entered Security Code = %s", securityCode), true);
		tap(reviewOrderButton, "Tapped on Review Order Button", true);
		return new ReviewOrderScreen(driver);
	}

}
