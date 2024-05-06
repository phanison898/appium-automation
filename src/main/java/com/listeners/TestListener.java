package com.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.reports.ExtentManager;
import com.reports.ExtentTestManager;

/**
 * 
 * @author Phanison
 * @since 30/04/2024
 * @github_username phanison898
 * 
 **/

public class TestListener implements ITestListener {

	@Override
	public void onStart(ITestContext context) {
		ExtentManager.getExtentReport();
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentTestManager.createTest(result.getMethod().getMethodName());
		ExtentTestManager.getTest().assignCategory(result.getInstance().getClass().getSimpleName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentTestManager.getTest().pass(result.getMethod().getMethodName() + " => test case Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentTestManager.getTest().fail(result.getMethod().getMethodName() + " => test case Failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentTestManager.getTest().skip(result.getMethod().getMethodName() + " => test case Skipped");

	}

	@Override
	public void onFinish(ITestContext context) {
		ExtentManager.flushExtentReport();
	}

}
