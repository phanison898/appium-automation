package com.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.config.Config;
import com.config.Paths;

/**
 * 
 * @author Phanison
 * @since 30/04/2024
 * @github_username phanison898
 * 
 **/

public class ExtentManager {

	private static ExtentReports extent = null;
	private static ExtentSparkReporter spark = null;

	public static ExtentReports getExtentReport() {

		if (extent == null) {

			extent = new ExtentReports();

			spark = new ExtentSparkReporter(Paths.EXTENT_REPORT_FILE);

			setSystemInfo();
			configureSparkReporter();

			extent.attachReporter(spark);

		}
		return extent;
	}

	public static void flushExtentReport() {
		extent.flush();
	}

	private static void setSystemInfo() {
		extent.setSystemInfo(null, null);
		extent.setSystemInfo(null, null);
		extent.setSystemInfo(null, null);
		extent.setSystemInfo(null, null);
		extent.setSystemInfo(null, null);
		extent.setSystemInfo(null, null);
	}

	private static void configureSparkReporter() {
		spark.config().setDocumentTitle(Config.getReportTitle());
		spark.config().setReportName(Config.getReportName());
		spark.config().setTheme(Config.getReportTheme().equals("dark") ? Theme.DARK : Theme.STANDARD);
	}

}
