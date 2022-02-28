package com.avin.networks.at.pom.pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.avin.networks.at.config.enums.ConfigProperties;
import com.avin.networks.at.config.enums.WaitStrategy;
import com.avin.networks.at.pom.factories.driver.DriverManager;
import com.avin.networks.at.utility.PropertitesUtils;
import com.avin.networks.at.utility.WaitUtils;


public class BasePage {

	protected void doClick(By by, WaitStrategy waitstrtaegy) {
		WebElement element = WaitUtils.performExplicitWait(waitstrtaegy, by);
		element.click();
	}

	protected void doClear(By by, WaitStrategy waitstrtaegy) {
		WebElement element = WaitUtils.performExplicitWait(waitstrtaegy, by);
		element.clear();
	}

	protected void doSendkeys(By by, String value, WaitStrategy waitstrtaegy) {
		WebElement element = WaitUtils.performExplicitWait(waitstrtaegy, by);
		element.sendKeys(value);
	}
	
	protected WebElement getElement(By by) {
		return DriverManager.getDriver().findElement(by);
	}
	
	protected void load(String endPoint) {
		DriverManager.getDriver().get(PropertitesUtils.get(ConfigProperties.URL) + endPoint);
		System.out.println("Final URL is : "+PropertitesUtils.get(ConfigProperties.URL) + endPoint);
	}
}
