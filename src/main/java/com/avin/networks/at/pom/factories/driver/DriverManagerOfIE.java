package com.avin.networks.at.pom.factories.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManagerOfIE implements DriverInterface{

	@Override
	public WebDriver createDriver() {
		WebDriverManager.iedriver().setup();
		return new InternetExplorerDriver();
	}

}
