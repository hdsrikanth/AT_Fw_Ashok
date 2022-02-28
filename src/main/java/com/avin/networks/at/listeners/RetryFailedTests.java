package com.avin.networks.at.listeners;


import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.avin.networks.at.config.enums.ConfigProperties;
import com.avin.networks.at.utility.PropertitesUtils;

public class RetryFailedTests implements IRetryAnalyzer {

	private int count = 0;
	private int retries = 1;

	public boolean retry(ITestResult result) {
		boolean value = false;
		try {
			if(PropertitesUtils.get(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes")) {
				value = count < retries;
				count++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

}
