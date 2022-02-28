package com.avin.networks.at.pom.factories.driver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v96.security.Security;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.avin.networks.at.config.enums.ConfigProperties;
import com.avin.networks.at.utility.PropertitesUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

@SuppressWarnings("deprecation")
public class DriverManagerOfChrome implements DriverInterface{

	String runmode = PropertitesUtils.get(ConfigProperties.RUNMODE);
	
	@Override
	public WebDriver createDriver() {

		RemoteWebDriver driver = null;
		try {
			if (runmode.equalsIgnoreCase("remote")) {
				ChromeOptions opt = new ChromeOptions();
				opt.setPageLoadStrategy(PageLoadStrategy.EAGER);
				
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName(BrowserType.CHROME);
				driver = new RemoteWebDriver(new URL(""), cap);
				
				DevTools devTools = ((ChromeDriver) driver).getDevTools();
				devTools.createSession();
				devTools.send(Security.enable());
				devTools.send(Security.setIgnoreCertificateErrors(true));
				
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				
			} else {
				ChromeOptions opt = new ChromeOptions();
				opt.setPageLoadStrategy(PageLoadStrategy.EAGER);
				
				WebDriverManager.chromedriver().clearDriverCache();
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				
				DevTools devTools = ((ChromeDriver) driver).getDevTools();
				devTools.createSession();
				devTools.send(Security.enable());
				devTools.send(Security.setIgnoreCertificateErrors(true));  
				
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;
	}
	
}
