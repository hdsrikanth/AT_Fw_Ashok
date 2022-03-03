package com.avin.networks.at.pom.pages.logindex;

import org.openqa.selenium.By;

import com.avin.networks.at.config.enums.WaitStrategy;
import com.avin.networks.at.pom.factories.objects.LogindexObj;
import com.avin.networks.at.pom.pages.base.BasePage;
import com.avin.networks.at.pom.pages.home.Home;
import com.avin.networks.at.utility.WaitUtils;

public class Logindex extends BasePage {

	private final By ipOfUsername = By.id("username");
    private final By ipOfPassword = By.id("password");
    private final By btnOfLogin = By.id("login");
    private final By iconOfLoader = By.cssSelector("img[src='resources/bftmicons/loader-squares.gif']");
    // private final By loginStatus = By.id("loginStatus");
    
    
    
    private Logindex entryOfUsername(String user) {
		doSendkeys(ipOfUsername, user, WaitStrategy.PRESENCE);
		//ExtentLogger.getInstance().pass(user+" is entered successfully");
		return this;
	}
	
	private Logindex entryOfPassword(String pass) {
		doSendkeys(ipOfPassword, pass, WaitStrategy.PRESENCE);
		//ExtentLogger.getInstance().pass("Password filed is entered successfully");
		return this;
	}
	
	private Logindex doClickLogin() {
		doClick(btnOfLogin, WaitStrategy.CLICKABLE);
		return this;
	}
	
	public Logindex doLogin(LogindexObj loginObj) {
		entryOfUsername(loginObj.getUserName()).
		entryOfPassword(loginObj.getPassword()).
		doClickLogin();
		return this;
	}
	
	public Home load() {
		WaitUtils.waitTillElementInVisible(iconOfLoader);
		load("#!/media");
		return new Home();
	}

}
