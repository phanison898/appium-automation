package com.reports;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Phanison
 * @since 30/04/2024
 * @github_username phanison898
 * 
 **/

import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {

	private static Map<Integer, ExtentTest> testMap = new HashMap<Integer, ExtentTest>();

	public static synchronized ExtentTest getTest() {
		return testMap.get((int) (long) Thread.currentThread().getId());
	}

	public static synchronized void createTest(String testName) {
		ExtentTest test = ExtentManager.getExtentReport().createTest(testName);
		testMap.put((int) (long) Thread.currentThread().getId(), test);
	}

}
