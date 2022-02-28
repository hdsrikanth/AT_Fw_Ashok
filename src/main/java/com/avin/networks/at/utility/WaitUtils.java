package com.avin.networks.at.utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.avin.networks.at.config.enums.WaitStrategy;
import com.avin.networks.at.exceptions.WaitElementException;
import com.avin.networks.at.pom.factories.driver.DriverManager;

public class WaitUtils {
	
	private WaitUtils() { 	}

	public static WebElement performExplicitWait(WaitStrategy waitstrategy, By by) {
		WebElement element = null;
		if (waitstrategy == WaitStrategy.CLICKABLE) {
			element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10))
					.until(ExpectedConditions.elementToBeClickable(by));
		} else if (waitstrategy == WaitStrategy.PRESENCE) {
			element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10))
					.until(ExpectedConditions.presenceOfElementLocated(by));
		} else if (waitstrategy == WaitStrategy.VISIBLE) {
			element = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(10))
					.until(ExpectedConditions.visibilityOfElementLocated(by));
		} else if (waitstrategy == WaitStrategy.NONE) {
			element = DriverManager.getDriver().findElement(by);
		}
		return element;
	}

	public static void waitThenClick(By locator) {
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverManager.getDriver())
					.pollingEvery(Duration.ofSeconds(2))
					.withTimeout(Duration.ofSeconds(30)).ignoring(StaleElementReferenceException.class)
					.ignoring(NoSuchElementException.class);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			
		} catch (TimeoutException toe) {
			throw new WaitElementException("Exception from Fluent Wait: " + toe.getMessage());
		} catch (NoSuchElementException e) {
			throw new WaitElementException("Exception from Fluent Wait: " + e.getMessage());
		}
	}

	// Fluent Wait for till the locator Invisible
	public static void waitTillElementInVisible(By locator) {
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverManager.getDriver())
					.pollingEvery(Duration.ofSeconds(15))
					.withTimeout(Duration.ofSeconds(20))
					.ignoring(StaleElementReferenceException.class)
					.ignoring(NoSuchElementException.class);
			
			wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		} catch (TimeoutException toe) {
			throw new WaitElementException("Timeout exception of invisibility of element located is" + locator.toString());
		} catch (Exception e) {
			throw new WaitElementException("Exception of invisibility of element located is" + locator.toString());
		}
	}

	// Fluent Wait for till the locator visible
	public static void waitTillElementVisible(By locator) {
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverManager.getDriver())
					.pollingEvery(Duration.ofSeconds(3))
					.withTimeout(Duration.ofSeconds(15))
					.ignoring(StaleElementReferenceException.class)
					.ignoring(NoSuchElementException.class);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (TimeoutException toe) {
			throw new WaitElementException("Timeout exception of visibility of element located is" + locator.toString());
		} catch (Exception e) {
			throw new WaitElementException("Exception of visibility of element located is" + locator.toString());
		}
	}

	public static void waitTillElementInVisible(By locator, int waitTime) {
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverManager.getDriver())
					.pollingEvery(Duration.ofSeconds(2))
					.withTimeout(Duration.ofSeconds(waitTime))
					.ignoring(StaleElementReferenceException.class)
					.ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		} catch (TimeoutException toe) {
			throw new WaitElementException("Timeout exception of to find locator is" + locator.toString());
		} catch (Exception e) {
			throw new WaitElementException("Exception of to find locator is" + locator.toString());
		}
	}
}
