package com.avin.networks.at.utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.avin.networks.at.pom.factories.driver.DriverManager;


public final class ScreenshotUtils {

	private ScreenshotUtils() { }

	public static String getImages() {
		return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}
}
