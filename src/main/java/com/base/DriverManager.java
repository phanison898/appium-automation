package com.base;

import java.net.URL;

import org.openqa.selenium.WebDriver;

public interface DriverManager {

	void init(URL url);

	WebDriver get();

}
