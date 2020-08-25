package com.project.report;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport implements ITestListener{
	ExtentReports extent;
	ExtentSparkReporter spark;
	ExtentTest test;
   
	public void onStart(ITestContext context) {
	    spark=new ExtentSparkReporter(System.getProperty("user.dir")+"//Report//TestReport.html");
		extent=new ExtentReports();
		extent.attachReporter(spark);
	}

	public void onTestStart(ITestResult result) {
		test=extent.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS,"Success");
		
	}
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
		
	}
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP,"Skipped");
	}

	public void onFinish(ITestContext context) {
		extent.flush();
		
	

}}
