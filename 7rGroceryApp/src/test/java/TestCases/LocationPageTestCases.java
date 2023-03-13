package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import ElementRepository.LocationPage;

import ElementRepository.SignInPage;
import utilities.ExcelRead;

public class LocationPageTestCases extends BaseClass {
	SignInPage sp;
	LocationPage lcp;
	ExcelRead eRead;

	@Test
	public void verifyDropdownTextInLocationPage() {

		lcp = new LocationPage(driver);
		sp = new SignInPage(driver);
		sp.SignInCredentials(prop.getProperty("Username"), prop.getProperty("Password"));
		lcp.selectManageLocation();
		lcp.selectEditIcon();
		String expecetedvalue = eRead.readFromExcelFile(6,1);
		String actualvalue = lcp.selectValueFromDropDown(expecetedvalue);
		Assert.assertEquals(actualvalue, expecetedvalue, "value is not as expected");
	}

}
