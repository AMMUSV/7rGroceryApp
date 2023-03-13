package TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ElementRepository.ManageUsersPage;
import ElementRepository.SignInPage;
import constant.Constant;
import utilities.ExcelRead;

public class ManageUsersPageTestCases {
	WebDriver driver;
	SignInPage sp;
	ManageUsersPage mup;
	ExcelRead eRead;
	@Test
	public void verifyTheStatusOfNeena() {
		sp = new SignInPage(driver);
		sp.SignInCredentials(eRead.readFromExcelFile(1, 0),eRead.readFromExcelFile(1, 1));
		mup = new ManageUsersPage(driver);
		mup.selecetmanageUsersPage();
		String actualResult = mup.getTheStatusOfNeena();
		String expecetedResult = eRead.readFromExcelFile(3, 0);
		Assert.assertEquals(actualResult, expecetedResult,Constant.ERRORMESSAGE_MANAGEUSERS_STATUSOF_NEENA);
	}
	 @Test
	public void verifyThePasswordOfNimisha() {
		sp = new SignInPage(driver);
		sp.SignInCredentials(eRead.readFromExcelFile(1, 0),eRead.readFromExcelFile(1, 1));
		mup = new ManageUsersPage(driver);
		mup.selecetmanageUsersPage();
		String actualResult = mup.getThePasswordOfNimisha();
		String expectedResult = eRead.readFromExcelFile(2, 0);
		Assert.assertEquals(actualResult, expectedResult,Constant.ERRORMESSAGE_MANAGEUSERS_STATUSOF_NEENA);
	}
}
