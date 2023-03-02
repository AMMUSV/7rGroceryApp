package TestCases;

import org.testng.Assert;

import ElementRepository.ManageExpensePage;

import ElementRepository.SignInPage;

public class ManageExpensePageTestCases extends BaseClass {
	ManageExpensePage mep;
	SignInPage sp;

	// @Test
	public void verifyBackGroundColorOfNewButton() {
		sp = new SignInPage(driver);
		mep = new ManageExpensePage(driver);
		sp.SignInCredentials("admin", "admin");
		mep.selectManageExpenseDropDown();
		mep.selectManageExpense();
		String actualValue = mep.getBackgroundColorOfNewButton();
		String expectedValue = "rgba(220, 53, 69, 1)";
		Assert.assertEquals(actualValue, expectedValue, "Actual background color of new button is not as expected.");
	}

	public void checkWhetherTheRadioButtonSelecetd() {
		sp = new SignInPage(driver);
		mep = new ManageExpensePage(driver);
		sp.SignInCredentials("admin", "admin");
		mep.selectManageExpenseDropDown();
		mep.selectManageExpense();
		boolean actualValue = mep.selectionOfManageExpenseRadioButton();
		boolean expecetdValue = true;
		Assert.assertEquals(actualValue, expecetdValue,
				"EvenThough manage expense buttoon is selected it is not get selected actually. ");
	}

	public void verifyTheCreditCashOfOrderCashElement() {
		sp = new SignInPage(driver);
		mep = new ManageExpensePage(driver);
		sp.SignInCredentials("admin", "admin");
		mep.selectManageExpenseDropDown();
		mep.selectManageExpense();
		String actualValue = mep.getTheCreditCashOfOrderCash296();
		String expecetdValue="£ 140";
		Assert.assertEquals(actualValue, expecetdValue,"The credit cash of odercash is not as expected");

	}
}
