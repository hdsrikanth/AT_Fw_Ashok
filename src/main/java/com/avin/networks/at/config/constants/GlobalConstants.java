package com.avin.networks.at.config.constants;

import java.util.Properties;

import com.avin.networks.at.config.enums.ConfigProperties;
import com.avin.networks.at.utility.PropertitesUtils;

public class GlobalConstants {
	
	private static GlobalConstants globalConstants;
	private Properties configProp;
	
	private static final int EXPLICITWAIT = 10;
	private static final String RESOURCEPATH = System.getProperty("user.dir") + "/src/test/resources";
	
	private static final String CONFIGFILEPATH = RESOURCEPATH + "/properties/config.properties";
	private static final String LOG4J = RESOURCEPATH+"/properties/log4j.properties";
	
	private static final String EXCELPATH = RESOURCEPATH + "/excel/testData.xlsx";
	
	private static final String JSONCONFIGFILEPATH = RESOURCEPATH + "/json/config.json";
	private static final String REPORTCONFIGFILEPATH = RESOURCEPATH + "/extentConf/reportConfig.xml";
	
	private static final String PASSEDREPORTSPATH = RESOURCEPATH + "/reports/passReports";
	private static final String FAILEDREPORTSPATH = RESOURCEPATH + "/reports/failedReports";
	
	
	
	
	
	private GlobalConstants(){
		if(null == configProp){
			configProp = new Properties();
		}
	}
	
	public static GlobalConstants getInstance(){
		if(null == globalConstants){
			globalConstants = new GlobalConstants();
		}
		return globalConstants;
	}
	
	
	
	/**
	 * @return the log4j
	 */
	public String getLog4j() {
		return LOG4J;
	}

	/**
	 * @return the getExcelpath
	 */
	public String getExcelpath() {
		return EXCELPATH;
	}

	/**
	 * @return the report config file path
	 */
	public String getReportconfigfilepath() {
		return REPORTCONFIGFILEPATH;
	}

	/**
	 * @return the failed reports path
	 * @throws Exception 
	 */
	public String getFailedreportspath() throws Exception {
		if(PropertitesUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("yes")) {
			return FAILEDREPORTSPATH+"/"+"Failed_result_"+System.currentTimeMillis()+".html";
		}else {
			return FAILEDREPORTSPATH;
		}
	}

	/**
	 * @return the resource path
	 */
	public String getResourcepath() {
		return RESOURCEPATH;
	}

	/**
	 * @return the passed reports path
	 * @throws Exception 
	 */
	public String getPassedreportspath() throws Exception {
		if(PropertitesUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("yes")) {
			return PASSEDREPORTSPATH+"/"+"Index_"+System.currentTimeMillis()+".html";
		}else {
			return PASSEDREPORTSPATH;
		}
		
	}

	public int getExplicitwait() {
		return EXPLICITWAIT;
	}

	public String getConfigFilePath() {
		return CONFIGFILEPATH;
	}
	
	public String getJsonConfigFilePath() {
		return JSONCONFIGFILEPATH;
	}
}
