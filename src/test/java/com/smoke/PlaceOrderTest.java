package com.smoke;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.test.BaseTest;
import com.screens.HomeScreen;

public class PlaceOrderTest extends BaseTest {

	private String FULL_NAME = "Phani Kumar";

	private String ADDRESS_LINE_1 = "Church Street";

	private String ADDRESS_LINE_2 = "3rd cross";

	private String CITY = "Bengaluru";

	private String STATE = "Karnataka";

	private String ZIP_CODE = "500000";

	private String COUNTRY = "India";

	private String USERNAME = "bob@example.com";

	private String PASSWORD = "10203040";

	private String CARD_NO = "325812657568789";

	private String EXPIRY = "03/25";

	private String CVV = "123";

	@Test
	public void verifyEnd2EndFunctionalityOfPlacingOrder() {

		HomeScreen homeScreen = new HomeScreen(getDriver());
		
		boolean validation = 
				homeScreen
					.tapOnProduct()
					.addToCart()
					.login(USERNAME, PASSWORD)
					.enterPersonalDetails(FULL_NAME, ADDRESS_LINE_1, ADDRESS_LINE_2, CITY, STATE, ZIP_CODE, COUNTRY)
					.enterPaymentDetails(FULL_NAME, CARD_NO, EXPIRY, CVV)
					.tapPlaceOrderButton()
					.isCheckOutCompleteTextDisplayed();
		
		Assert.assertTrue(validation, "Check Out Successfully text not displayed");

	}

}
