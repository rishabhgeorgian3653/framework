package com.qa.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	
	/*
	 * function for generating extent report
	 * 
	 * and storing report at one place
	 */
	
	public static ExtentReports getReportObject()
	{
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation results");
		reporter.config().setDocumentTitle("Test Results");
		ExtentReports extent = new ExtentReports();
		
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Rishabh");
		return extent;
	}

}
