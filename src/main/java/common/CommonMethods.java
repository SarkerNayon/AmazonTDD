package common;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import packageUtill.LoggerClass;

public class CommonMethods {
	WebDriver driver;
	CommonWaits waits;

	public CommonMethods(WebDriver driver, CommonWaits waits) {
		this.driver = driver;
		this.waits = waits;
	}

	public void click(WebElement element) {
		try {
			waits.waitUntilClickable(element);
			element.click();
			LoggerClass.getLog(element + " ---> This element has been clicked");
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			LoggerClass.getLog(element + " : This element Not Found");
			Assert.fail();
		}
	}
	
	public String getCurrentURL(WebDriver driver) {
		LoggerClass.getLog("The current url is " + driver.getCurrentUrl());
		return driver.getCurrentUrl();
	}
	
	public void sendKeys(WebElement element, String value) {
		try {
			element.sendKeys(value);
			LoggerClass.getLog(value + " --->has passed to" + element);
		} catch (NullPointerException | NoSuchElementException e) {
			e.printStackTrace();
			LoggerClass.getLog(element + " : This element Not Found");
			Assert.fail();
		}
	}
	 

}
