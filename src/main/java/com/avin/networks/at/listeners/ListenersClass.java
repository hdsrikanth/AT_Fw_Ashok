package com.avin.networks.at.listeners;

import java.io.IOException;
import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.avin.networks.at.reports.ExtentLogger;
import com.avin.networks.at.reports.ExtentReport;
import com.avin.networks.at.utility.CustomAnnotation;

public class ListenersClass  implements ITestListener, ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		try {
			ISuiteListener.super.onStart(suite);
			ExtentReport.initReports();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onFinish(ISuite suite) {
		try {
			ISuiteListener.super.onFinish(suite);
			ExtentReport.flushReports();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		ITestListener.super.onTestStart(result);
		ExtentReport.createTest(result.getMethod().getDescription());
		ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(CustomAnnotation.class).author());
		ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(CustomAnnotation.class).category());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ITestListener.super.onTestSuccess(result);
		ExtentLogger.getInstance().pass(result.getMethod().getMethodName() + " is passed", true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			ITestListener.super.onTestFailure(result);
			ExtentLogger.getInstance().fail(result.getMethod().getMethodName() + " is failed",true);
			ExtentLogger.getInstance().fail(result.getThrowable().toString());
			ExtentLogger.getInstance().fail(Arrays.toString(result.getThrowable().getStackTrace()));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ITestListener.super.onTestSkipped(result);
		ExtentLogger.getInstance().skip(result.getMethod().getMethodName() + " is skipped", true);
		ExtentLogger.getInstance().skip(result.getThrowable().toString());
		ExtentLogger.getInstance().skip(Arrays.toString(result.getThrowable().getStackTrace()));
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		ITestListener.super.onFinish(context);
	}

}
