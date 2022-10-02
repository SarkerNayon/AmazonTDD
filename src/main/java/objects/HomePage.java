package objects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import common.CommonMethods;

public class HomePage {
	WebDriver driver;
	CommonMethods cMethods;
	
	public HomePage(WebDriver driver, CommonMethods cMethods) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.cMethods = cMethods;
	}
	
	@FindBy(id = "twotabsearchtextbox")
	WebElement searchBox;
	
	
	private void pageUrl() {
		assertEquals(cMethods.getCurrentURL(driver), "https://www.amazon.com");
	}
	
	private void inputSearch(String value) {
		cMethods.sendKeys(searchBox, value);
	}
	
	public void homePageSteps(String value) {
		pageUrl();
		inputSearch(value);
		
	}

}
