package com.avin.networks.at.pom.factories.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.avin.networks.at.config.enums.ConfigProperties;
import com.avin.networks.at.utility.PropertitesUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManagerOfFirefox implements DriverInterface {

	String runmode = PropertitesUtils.get(ConfigProperties.RUNMODE);
	
	@Override
	public WebDriver createDriver() {

		/*
		 * RemoteWebDriver driver = null; try { if (runmode.equalsIgnoreCase("remote"))
		 * { DesiredCapabilities cap = new DesiredCapabilities();
		 * cap.setBrowserName(BrowserType.FIREFOX); driver = new RemoteWebDriver(new
		 * URL(""), cap);
		 * 
		 * DevTools devTools = ((FirefoxDriver) driver).getDevTools();
		 * devTools.createSession(); devTools.send(Security.enable());
		 * devTools.send(Security.setIgnoreCertificateErrors(true));
		 * 
		 * driver.manage().window().maximize(); driver.manage().deleteAllCookies(); }
		 * else { WebDriverManager.chromedriver().clearDriverCache();
		 * WebDriverManager.firefoxdriver().setup(); driver = new FirefoxDriver();
		 * 
		 * DevTools devTools = ((FirefoxDriver) driver).getDevTools();
		 * devTools.createSession(); devTools.send(Security.enable());
		 * devTools.send(Security.setIgnoreCertificateErrors(true));
		 * 
		 * driver.manage().window().maximize(); driver.manage().deleteAllCookies(); } }
		 * catch (MalformedURLException e) { e.printStackTrace(); }
		 */
		WebDriverManager.chromedriver().clearDriverCache();
		WebDriverManager.firefoxdriver().setup(); 
		return new FirefoxDriver();
	}
	
	
}
