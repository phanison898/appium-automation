package com.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utils.InteractionsUtil;

public class CheckOutScreen extends InteractionsUtil {

	private WebDriver driver = null;

	private By fullNameInput = By.xpath("//android.widget.EditText[@content-desc='Full Name* input field']");

	private By addressLine1Input = By.xpath("//android.widget.EditText[@content-desc='Address Line 1* input field']");

	private By addressLine2Input = By.xpath("//android.widget.EditText[@content-desc='Address Line 2 input field']");

	private By cityInput = By.xpath("//android.widget.EditText[@content-desc='City* input field']");

	private By stateInput = By.xpath("//android.widget.EditText[@content-desc='State/Region input field']");

	private By zipCodeInput = By.xpath("//android.widget.EditText[@content-desc='Zip Code* input field']");

	private By countryInput = By.xpath("//android.widget.EditText[@content-desc='Country* input field']");

	private By paymentButton = By.xpath("//android.view.ViewGroup[@content-desc='To Payment button']");

	public CheckOutScreen(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public PaymentScreen enterPersonalDetails(String fullName, String addressLine1, String addressLine2, String city,
			String state, String zipCode, String country) {

		enter(fullNameInput, fullName, String.format("Entered fullName = %s", fullName));
		enter(addressLine1Input, addressLine1, String.format("Entered addressLine1 = %s", addressLine1));
		enter(addressLine2Input, addressLine2, String.format("Entered addressLine2 = %s", addressLine2));
		scrollToElement("Country*");
		enter(cityInput, city, String.format("Entered city = %s", city));
		enter(stateInput, state, String.format("Entered state = %s", state));
		enter(zipCodeInput, zipCode, String.format("Entered zipCode = %s", zipCode));
		enter(countryInput, country, String.format("Entered country = %s", country), true);
		tap(paymentButton, "Clicked Payment Button");

		return new PaymentScreen(driver);
	}

}
