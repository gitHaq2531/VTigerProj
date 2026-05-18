package com.client.Project.packageName;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	public void waitForPageLoad(WebDriver driver) {
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
		
		
		public void waitForElementPresent(WebDriver driver,WebElement element) {
			WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		

}
