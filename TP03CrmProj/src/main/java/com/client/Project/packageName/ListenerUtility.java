package com.client.Project.packageName;

import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerUtility implements ITestListener, ISuiteListener{
	
	public ExtentSparkReporter spark;
	public static ExtentReports report;
	public static ExtentTest test;
	
	public void onStart(ITestContext context) {
		System.out.println("====Report Configuration====");
		
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report_.html");
		spark.config().setDocumentTitle("VTiger TestResult");
		spark.config().setReportName("Test Report");
		spark.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("BROWSER", "chrome");
	}
	public void onFinish(ITestContext context) {
		System.out.println("====Report Backup====");
		report.flush();
	}
	public void onTestStart(ITestResult result) {
		System.out.println("=====START=====");
		test = report.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO, result.getMethod().getMethodName()+ "===> STARTED <===");
	}
	public void onTestSuccess(ITestResult result) {
		System.out.println("=====END=====");
		test.log(Status.PASS, result.getMethod().getMethodName()+ "===> COMPLETED <===");

	}


}
