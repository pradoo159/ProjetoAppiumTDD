package br.com.rsinet.hub_tdd.util;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentReport {

	private static ExtentReports extent;
	private static ExtentTest test;

	public static void iniciaReport() {
		extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/ExtentScreenshot.html", true);
	}

	public static void fechaReport() {
		extent.flush();
	}

	public static ExtentTest getTest() {
		return test;
	}

	public static ExtentReports getExtent() {
		return extent;
	}
}
