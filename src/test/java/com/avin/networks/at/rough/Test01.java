package com.avin.networks.at.rough;

import java.util.Map;

import org.testng.annotations.Test;

import com.avin.networks.at.base.SetupTest;
import com.avin.networks.at.config.enums.CategoryType;
import com.avin.networks.at.pom.factories.objects.LogindexObj;
import com.avin.networks.at.pom.pages.home.Admin;
import com.avin.networks.at.pom.pages.home.Home;
import com.avin.networks.at.pom.pages.logindex.Logindex;
import com.avin.networks.at.utility.CustomAnnotation;
import com.avin.networks.at.utility.DataProviderUtils;

public class Test01 extends SetupTest{

	Home home;
	Admin admin;
	
	@CustomAnnotation(author = { "Ashok" }, category = {CategoryType.SMOKE })
	@Test(dataProvider = "getData", dataProviderClass = DataProviderUtils.class)
	public void logIndex(Map<String, String> data) {
		System.out.println("Data : "+data);
		LogindexObj login = new LogindexObj(data.get("username"), data.get("password"));
		admin = new Logindex().
				doLogin(login).
				load().
				navigateToAdmin().
				load().
				doLogout();
	}

}
