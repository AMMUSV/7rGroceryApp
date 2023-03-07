package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import ElementRepository.LocationPage;

import ElementRepository.SignInPage;

public class LocationPageTestCases extends BaseClass {
	SignInPage sp;
	LocationPage lcp;

	@Test
	public void verifyDropdownTextInLocationPage() {

		lcp = new LocationPage(driver);
		sp = new SignInPage(driver);
		sp.SignInCredentials("admin", "admin");
		lcp.selectManageLocation();
		lcp.selectEditIcon();
		String expecetedvalue = "Cambridge";
		String actualvalue = lcp.selectValueFromDropDown(expecetedvalue);
		Assert.assertEquals(actualvalue, expecetedvalue, "value is not as expected");
	}

}
