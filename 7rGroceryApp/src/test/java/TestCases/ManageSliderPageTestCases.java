package TestCases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;
import ElementRepository.ManageSliderPage;
import ElementRepository.SignInPage;
import constant.Constant;
import utilities.ExcelRead;

public class ManageSliderPageTestCases extends BaseClass {

	SignInPage sp;
	ManageSliderPage msp;
	ExcelRead eRead = new ExcelRead();

	@Test(priority = 1, groups = { "sanity" })
	public void verifyTheSavedDataIsPresent() {
		sp = new SignInPage(driver);
		msp = new ManageSliderPage(driver);
		sp.SignInCredentials(prop.getProperty("Username"), prop.getProperty("Password"));
		msp.selectManageSlider();
		msp.selectNewButtonElement();
		Boolean actualResult = msp.checkingTheAddedElementIspresent(prop.getProperty("EnterLinkElementValue"));
		Assert.assertTrue(actualResult, Constant.ERRORMESSAGE_MANAGAESLIDERSPAGE_SAVEDDATA);

	}

	@Test(priority = 2, groups = { "regression" })
	public void verifyTheBackGroundColorOfSaveButton() {
		sp = new SignInPage(driver);
		msp = new ManageSliderPage(driver);
		sp.SignInCredentials(prop.getProperty("Username"), prop.getProperty("Password"));
		msp.selectManageSlider();
		msp.selectNewButtonElement();
		String actualResult = msp.getThebackgroundColorOfSaveButton();
		String expectedResult = eRead.readFromExcelFile(7, 1);
		Assert.assertEquals(actualResult, expectedResult, Constant.ERRORMESSAGE_BACKGROUNDCOLOR);

	}
}
