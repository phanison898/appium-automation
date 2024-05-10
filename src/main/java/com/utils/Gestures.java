package com.utils;

import org.openqa.selenium.WebElement;

public abstract class Gestures {

	public abstract void swipeUp(WebElement element);

	public abstract void swipeDown(WebElement element);

	public abstract void swipeLeft(WebElement element);

	public abstract void swipeRight(WebElement element);

	public abstract void click(WebElement element);

	public abstract void longClick(WebElement element);

	public abstract void doubleClick(WebElement element);

	public abstract void drag(WebElement element);

	public abstract void fling(WebElement element);

	public abstract void pinchOpen(WebElement element);

	public abstract void pinchClose(WebElement element);

	public abstract void scroll(WebElement element);

}
