package TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ElementRepository.ManageUsersPage;
import ElementRepository.SignInPage;
import constant.Constant;
import utilities.ExcelRead;

public class ManageUsersPageTestCases extends BaseClass {
	
	SignInPage sp;
	ManageUsersPage mup;
	ExcelRead eRead = new ExcelRead();
	
	@Test(groups = { "regression" })
	public void verifyTheStatusOfUser() {
		sp = new SignInPage(driver);
		sp.SignInCredentials(eRead.readFromExcelFile(1, 1),eRead.readFromExcelFile(2, 1));
		mup = new ManageUsersPage(driver);
		mup.selecetmanageUsersPage();
		String actualResult = mup.getTheStatusOfUser(prop.getProperty("NameOfUser"));
		String expectedResult= prop.getProperty("StatusOfUser");
		//String expecetedResult = eRead.readFromExcelFile(4, 0);
		Assert.assertEquals(actualResult, expectedResult,Constant.ERRORMESSAGE_MANAGEUSERS_STATUSOF_NEENA);
	}
	

}
