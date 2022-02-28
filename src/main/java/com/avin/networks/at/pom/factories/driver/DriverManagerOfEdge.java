package com.avin.networks.at.pom.factories.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManagerOfEdge implements DriverInterface {

	@Override
	public WebDriver createDriver() {
		WebDriverManager.edgedriver().setup();
		return new EdgeDriver();
	}

}
