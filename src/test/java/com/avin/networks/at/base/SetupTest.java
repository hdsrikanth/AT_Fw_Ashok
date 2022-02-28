package com.avin.networks.at.base;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentTest;
import com.avin.networks.at.pom.factories.driver.Driver;
import com.avin.networks.at.pom.factories.driver.DriverManager;
import com.avin.networks.at.reports.ExtentManager;

public class SetupTest {
	
	public static ExtentTest extentTest = ExtentManager.getExtentTest();

	@Parameters("browser")
	@BeforeClass
	public synchronized void setUp(@Optional String browser) throws Exception{
		if(null == browser) browser = "CHROME";
		browser = System.getProperty("browser", browser);
		Driver.initializationOfDriver(browser);
		
		
		System.out.println("CURRENT THREAD : "+Thread.currentThread().getId()+"Driver : "+DriverManager.getDriver());
	}
	
	@AfterClass
	public synchronized void tearDown() throws IOException {
		System.out.println("CURRENT THREAD : "+Thread.currentThread().getId()+"Driver : "+DriverManager.getDriver());
		Driver.closeDriver();
		
	}
}
