package basePackage;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import common.CommonMethods;
import common.CommonWaits;
import io.github.bonigarcia.wdm.WebDriverManager;
import objects.HomePage;
import packageUtill.Configuration;

public class BaseClass {

	public Configuration configuration = Configuration.getInstance();
	// This is singleton object, not need for general students.
	// Singleton is only allowing to create a single object of a class.

	WebDriver driver;
	CommonWaits wait1;
	WebDriverWait wait2;
	protected HomePage hPage;
	protected CommonMethods commonMethods;

	@BeforeMethod
	public void setUp(String sBrowser) {
		driver = localDriver("chrome");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(configuration.get("URL"));
		driver.manage().timeouts()
				.pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(configuration.get("pageLoadTimeOut"))));
		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Integer.parseInt(configuration.get("implicitWait"))));
		wait2 = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(configuration.get("explecitWait"))));
		initClass();
	}
	protected WebDriver getDriver() {
		return driver;
	}


	private WebDriver localDriver(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		return driver;
	}
	
	private void initClass() {
		wait1 = new CommonWaits(wait2);
		commonMethods = new CommonMethods(driver, wait1);
		hPage = new HomePage(driver, commonMethods);
	}

	@AfterMethod
	public void closeDriver() { 
		driver.quit();
	}

}
