package com.basic;

import org.testng.annotations.Test;

import com.base.Base;
import com.screens.MainScreen;

public class BasicTest extends Base{
	
	MainScreen mainScreen;
	
	@Test(priority = 1)
	public void addition() {
		mainScreen = new MainScreen();
		mainScreen.number(1).click();
		mainScreen.operation("+").click();
		mainScreen.number(2).click();
		mainScreen.enter().click();
		mainScreen.getResult();
	}
	
	@Test(priority = 2)
	public void subtraction() {
		mainScreen = new MainScreen();
		mainScreen.number(3).click();
		mainScreen.operation("-").click();
		mainScreen.number(4).click();
		mainScreen.enter().click();
		mainScreen.getResult();
	}
	
	@Test(priority = 3)
	public void multiplication() {
		mainScreen = new MainScreen();
		mainScreen.number(5).click();
		mainScreen.operation("x").click();
		mainScreen.number(6).click();
		mainScreen.enter().click();
		mainScreen.getResult();
	}
	
	@Test(priority = 4)
	public void division() {
		mainScreen = new MainScreen();
		mainScreen.number(7).click();
		mainScreen.operation("/").click();
		mainScreen.number(8).click();
		mainScreen.enter().click();
		mainScreen.getResult();
	}

}
