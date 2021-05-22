package com.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.util.TestUtil;

public class MainScreen extends TestUtil {
	
	final String commonNumberId = "com.android.calculator2:id/digit_";
	final String commonOperatorId = "com.android.calculator2:id/";
	
	public WebElement number(int number) {
		WebElement element = driver.findElement(By.id(commonNumberId+Integer.toString(number)));
		return element;
	}
	
	public WebElement operation(String operator) {
		WebElement element = null;
		switch(operator) {
		case "+":
			operator = "op_add";
			break;
		case "-":
			operator = "op_sub";
			break;
		case "x":
			operator = "op_mul";
			break;
		case "/":
			operator = "op_div";
			break;
		default:
			operator = "op_add";
			break;
		}

		element = driver.findElement(By.id(commonOperatorId+operator));
		
		return element;
	}
	
	public WebElement enter() {
		WebElement element = driver.findElement(By.id(commonOperatorId+"eq"));
		return element;
	}
	
	public String getResult() {
		WebElement element = driver.findElement(By.id(commonOperatorId+"result"));
		return element.getText();
	}

}
