package com.avin.networks.at.pom.factories.driver;

import com.avin.networks.at.config.enums.DriverTypes;

public class DriverFactory {

	private DriverFactory() { 	}
	
	public static DriverInterface getManager(DriverTypes driverTypes) {
		// WebDriver driver = null;
		// browser = System.getProperty("browser", browser);
		// String runmode = PropertitesUtils.get(ConfigProperties.RUNMODE);

		switch (driverTypes) {
		case CHROME:
			return new DriverManagerOfChrome();

		case FIREFOX:
			return new DriverManagerOfFirefox();

		case EDGE:
			return new DriverManagerOfEdge();

		case IE:
			return new DriverManagerOfIE();

		default:
			throw new IllegalStateException("Invalid browser name : " + driverTypes);

		}
	}
}
