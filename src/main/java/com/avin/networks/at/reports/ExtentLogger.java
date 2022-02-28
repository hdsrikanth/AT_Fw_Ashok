package com.avin.networks.at.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.avin.networks.at.config.enums.ConfigProperties;
import com.avin.networks.at.utility.PropertitesUtils;
import com.avin.networks.at.utility.ScreenshotUtils;

public final class ExtentLogger {

	private static ExtentLogger extentLogger;
	
	private ExtentLogger() { 	}
	
	public static ExtentLogger getInstance() {
		if(null == extentLogger){
			extentLogger = new ExtentLogger();
		}
		return extentLogger;
	}

	public void pass(String message) {
		ExtentManager.getExtentTest().pass(message);
	}

	public void fail(String message) {
		ExtentManager.getExtentTest().fail(message);
	}

	public void skip(String message) {
		
		ExtentManager.getExtentTest().skip(message);
	}

	public void pass(String message, boolean isScreenshotNeeded) {
		if (PropertitesUtils.get(ConfigProperties.PASSEDSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded) {
			ExtentManager.getExtentTest().pass(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getImages()).build());
		} else {
			pass(message);
		}
	}

	public void fail(String message, boolean isScreenshotNeeded) {
		if (PropertitesUtils.get(ConfigProperties.FAILEDSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded) {
			ExtentManager.getExtentTest().fail(message,MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getImages()).build());
		} else {
			fail(message);
		}
	}

	public void skip(String message, boolean isScreenshotNeeded) {
		if (PropertitesUtils.get(ConfigProperties.SKIPEDSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded) {
			ExtentManager.getExtentTest().skip(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getImages()).build());
		} else {
			skip(message);
		}
	}

}
