package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import ElementRepository.ListPages;
import ElementRepository.SignInPage;
import constant.Constant;



public class ListPagesTestCases extends BaseClass {
	SignInPage sp;
	ListPages lp;

	@Test
	public void verifyfileupload() throws Exception {
		sp = new SignInPage(driver);
		lp = new ListPages(driver);
		sp.SignInCredentials(prop.getProperty("Username"), prop.getProperty("Password"));
		lp.selectmanageContentElement();
		lp.selectmanagemanagePageElement();
		lp.selecteditButton();
		lp.uploadingTheFile();
		lp.selectUpdateButton();
		
		Boolean actualResult = lp.isAlertPresent();
		Assert.assertTrue(actualResult, Constant.ERRORMESSAGE_LISTPAGES_ALERT_STRING);

	}
}