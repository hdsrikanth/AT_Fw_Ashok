package com.avin.networks.at.utility;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.avin.networks.at.config.constants.GlobalConstants;


public final class LoggerUtils {

	private static boolean root=false;
	
	private LoggerUtils() { }
	
	@SuppressWarnings("rawtypes")
	public static Logger getLogger(Class cls){
		if(root){
			return Logger.getLogger(cls);
		}
		PropertyConfigurator.configure(GlobalConstants.getInstance().getLog4j());
		root = true;
		return Logger.getLogger(cls);
	}
}
