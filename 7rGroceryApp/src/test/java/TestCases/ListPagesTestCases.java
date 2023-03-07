package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import ElementRepository.ListPages;
import ElementRepository.SignInPage;


public class ListPagesTestCases extends BaseClass {
	SignInPage sp;
	ListPages lp;

	@Test
	public void verifyfileupload() throws Exception {
		sp = new SignInPage(driver);
		lp = new ListPages(driver);
		sp.SignInCredentials("admin", "admin");
		lp.selectmoreInfobutton();
		lp.selecteditButton();
		// lp.selectchooseFileButton();
		lp.uploadingTheFile();

		lp.selectUpdateButton();
		Boolean actualResult = lp.isAlertPresent();
		Assert.assertTrue(actualResult, "Alert is not present");

	}
}