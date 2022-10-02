package testPackage;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import basePackage.BaseClass;

public class SearchBoxtest extends BaseClass{

	@Test
	public void testSearchBox() {
		hPage.homePageSteps("Macbook");
	}
}
