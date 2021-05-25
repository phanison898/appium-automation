package com.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.report.Report;
import com.report.Test;

public class TestListener implements ITestListener {

	private ExtentReports extent = null;
	public ExtentTest test = null;
	private String category;
	private String testcase;

	public void onStart(ITestContext context) {
		Report report = new Report();
		extent = report.generateReport();
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}

	public void onTestStart(ITestResult result) {
		System.out.println("The test-case [ " + result.getMethod().getMethodName() + " ] --> Started");

		category = result.getInstance().getClass().getSimpleName();
		testcase = result.getMethod().getMethodName();

		Test testManager = new Test(extent);

		test = testManager.startTest(testcase);
		test.assignCategory(category);
		test.log(Status.INFO, "Test case started");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("The test-case [ " + result.getMethod().getMethodName() + " ] --> Passed");
		test.log(Status.PASS, "Test case passed");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("The test-case [ " + result.getMethod().getMethodName() + " ] --> Failed");
		test.log(Status.FAIL, "Test case failed");
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("The test-case [ " + result.getMethod().getMethodName() + " ] --> Skipped");
		test.log(Status.SKIP, "Test case skipped");
	}

}