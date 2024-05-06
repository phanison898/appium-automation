package com.smoke;

import org.testng.annotations.Test;

import com.base.test.BaseTest;
import com.screens.HomeScreen;

public class HomeScreenTest extends BaseTest {

	@Test
	public void sample() {
		HomeScreen screen = new HomeScreen(getDriver());
		screen.logger.info("screenshot", true);
	}

}
