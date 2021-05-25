package com.report;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Report {

	private ExtentReports extent = null;
	private ExtentSparkReporter spark = null;
	private Properties reportConfig = null;
	private final String reportConfigFilePath = System.getProperty("user.dir")
			+ "/src/main/resources/report-config.properties";
	private final String reportPath = System.getProperty("user.dir") + "/target/index.html";

	public Report() {
		reportConfig = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(new File(reportConfigFilePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			reportConfig.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public ExtentReports generateReport() {
		if (extent == null) {
			extent = new ExtentReports();
			spark = new ExtentSparkReporter(reportPath);
			reportConfig();
			extent.attachReporter(spark);
		}
		return extent;
	}

	public void closeReport() {
		extent.flush();
	}

	private void reportConfig() {
		InetAddress ip = null;
		try {
			ip = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		String authorEmail = String.format("<a href=mailto:%s target=_blank>%<s</a>",
				getReportConfigValue("author-email"));

		extent.setSystemInfo("App Name", getReportConfigValue("app-name"));
		extent.setSystemInfo("Host Name", ip.getHostName());
		extent.setSystemInfo("Host Address", ip.getHostAddress());
		extent.setSystemInfo("Host Platform", System.getProperty("os.name"));
		extent.setSystemInfo("Host Java -v", System.getProperty("java.version"));
		extent.setSystemInfo("Author Name", getReportConfigValue("author-name"));
		extent.setSystemInfo("Author Email", authorEmail);

		if (getReportConfigValue("report-theme").equalsIgnoreCase("DARK")) {
			spark.config().setTheme(Theme.DARK);
		} else {
			spark.config().setTheme(Theme.STANDARD);
		}

		spark.config().setDocumentTitle(getReportConfigValue("report-name"));
		spark.config().setReportName(getReportConfigValue("report-name"));
		spark.config().setTimelineEnabled(true);
	}

	private String getReportConfigValue(String key) {
		return reportConfig.getProperty(key);
	}
}
