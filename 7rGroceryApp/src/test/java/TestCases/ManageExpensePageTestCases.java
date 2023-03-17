package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import ElementRepository.ManageExpensePage;

import ElementRepository.SignInPage;
import constant.Constant;

public class ManageExpensePageTestCases extends BaseClass {
	ManageExpensePage mep;
	SignInPage sp;

	 @Test(priority = 1, groups = { "regression" })
	public void verifyBackGroundColorOfNewButton() {
		sp = new SignInPage(driver);
		mep = new ManageExpensePage(driver);
		sp.SignInCredentials(prop.getProperty("Username"),prop.getProperty("Password"));
		mep.selectManageExpenseDropDown();
		mep.selectManageExpense();
		String actualValue = mep.getBackgroundColorOfNewButton();
		String expectedValue = "rgba(220, 53, 69, 1)";
		Assert.assertEquals(actualValue, expectedValue, "Actual background color of new button is not as expected.");
	}
	 @Test(priority = 2, groups = { "regression" })
	public void checkWhetherTheButtonSelecetd() {
		sp = new SignInPage(driver);
		mep = new ManageExpensePage(driver);
		sp.SignInCredentials(prop.getProperty("Username"),prop.getProperty("Password"));
		mep.selectManageExpenseDropDown();
		mep.selectManageExpense();
		boolean actualValue = mep.selectionOfManageExpenseButton();	
		Assert.assertTrue(actualValue,"NOT AS EXPECTED");
	 }
	// @Test(priority = 3, groups = { "regression" })
	public void verifyTheDateOfExpenceOfUser() {
		sp = new SignInPage(driver);
		mep = new ManageExpensePage(driver);
		sp.SignInCredentials(prop.getProperty("Username"),prop.getProperty("Password"));
		mep.selectManageExpenseDropDown();
		mep.selectManageExpense();
		String actualValue = mep.getTheDateOfExpenceOfUser(prop.getProperty("nameOfUserInExpense"));
		String expecetdValue=prop.getProperty("ExpectedDate");
		Assert.assertEquals(actualValue, expecetdValue,Constant.ERRORMESSAGE_DATEOFEXPENSE_STRING);

	}
}
