package com.avin.networks.at.pom.pages.home;

import org.openqa.selenium.By;

import com.avin.networks.at.config.enums.WaitStrategy;
import com.avin.networks.at.pom.pages.base.BasePage;

public class Admin extends BasePage {

	private final By btnOfLogout = By.cssSelector("i[class='navbar_icon_logout']");
	
	
	public Admin doLogout() {
		doClick(btnOfLogout, WaitStrategy.CLICKABLE);
		return this;
	}
}
