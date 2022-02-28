package com.avin.networks.at.pom.pages.home;

import org.openqa.selenium.By;

import com.avin.networks.at.config.enums.WaitStrategy;
import com.avin.networks.at.pom.pages.base.BasePage;
import com.avin.networks.at.utility.WaitUtils;

public class Home extends BasePage {

	
	private final By idOfAdmin = By.cssSelector("li[title='Configure and manage the system.']");
	private final By lblOfAccountAdministration = By.xpath("(//span[@class=\"k-in d-tree-header-item\"][contains(text(),'Account Administration')])");
	
	
	public Home navigateToAdmin() {
		WaitUtils.waitTillElementVisible(idOfAdmin);
		doClick(idOfAdmin, WaitStrategy.CLICKABLE);
		return this;
	}
	
	public Admin load() {
		load("#!/admin");
		WaitUtils.waitTillElementVisible(lblOfAccountAdministration);
		return new Admin();
	}
}
