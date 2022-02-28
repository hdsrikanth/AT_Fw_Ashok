package com.avin.networks.at.pom.factories.driver;

import java.util.Objects;

import com.avin.networks.at.config.enums.ConfigProperties;
import com.avin.networks.at.config.enums.DriverTypes;
import com.avin.networks.at.utility.PropertitesUtils;

public class Driver {

	
	
	public static void initializationOfDriver(String browser) {
		if (Objects.isNull(DriverManager.getDriver())) {
			DriverManager.setDriver(DriverFactory.getManager(DriverTypes.valueOf(browser)).createDriver());
			DriverManager.getDriver().get(PropertitesUtils.get(ConfigProperties.URL));
			System.out.println("Get url from config properties files : "+PropertitesUtils.get(ConfigProperties.URL));
		}
	}
	 
	public static void closeDriver() {
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
