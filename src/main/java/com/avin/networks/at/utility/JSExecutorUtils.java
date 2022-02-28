package com.avin.networks.at.utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.avin.networks.at.pom.factories.driver.DriverManager;

public class JSExecutorUtils {

private JSExecutorUtils() { }


	private static JavascriptExecutor runJavascriptExecutor() {
		return	((JavascriptExecutor) DriverManager.getDriver());
	}
	
	public static String getValue(String javaScripts) {
		return (String) runJavascriptExecutor().executeScript(javaScripts);

	}
	
	// Scroll to the particular element
	public static void scrollIntoView(WebElement element) {
		try {
			runJavascriptExecutor().executeScript("arguments[0].scrollIntoView(true);", element);
		} catch (Exception error) {
			throw new RuntimeException("Please check scroll into view of element");
		}
	}
	
	public static void openNewWindowHandles(String url) {
		try{
			runJavascriptExecutor().executeScript("window.open('about:blank','_blank');");
		    for(String winHandle : DriverManager.getDriver().getWindowHandles()){
			    DriverManager.getDriver().switchTo().window(winHandle);
			    }
		    DriverManager.getDriver().get(url);
		}catch(Exception error){
			throw new RuntimeException("Please check url for new window");
		 }
	}
	
	// Highlighting The element with green
	public static void elementHighlightGreen(WebElement element) {
		runJavascriptExecutor().executeScript("arguments[0].style.border='3px solid green'", element);
	}
	
	// Highlighting The element with red
	public static void elementHighlightRed(WebElement element) {
		runJavascriptExecutor().executeScript("arguments[0].style.border='3px solid red'", element);
	}
	

}
