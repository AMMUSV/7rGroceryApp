package TestCases;

import org.testng.annotations.Test;

import ElementRepository.ManageProductPage;
import ElementRepository.SignInPage;
import constant.Constant;

import org.testng.Assert;

public class SignInPageTestCases extends BaseClass {

	SignInPage sp;
	ManageProductPage mp;

	@Test
	public void verifyTheTextOfSignInButton() {
		sp = new SignInPage(driver);
		String actualResult = sp.getTheTextOfSignInButton();
		String expectedResult = "Sign In";
		Assert.assertEquals(actualResult, expectedResult, Constant.ERRORMESSAGELOGINBUTTON);

	}

	@Test
	public void verifyTheErrorMessage() {
		sp = new SignInPage(driver);
		mp = new ManageProductPage(driver);
		sp.enterInvalidUserName(Constant.INVALIDUSERNAME);
		sp.SignInCredentials("admin", "admin");
		String actualResult = sp.getErrorTextOfElement();
		String expectedResult = "×\n" + "Alert!\n" + "Invalid Username/Password";
		Assert.assertEquals(actualResult, expectedResult, Constant.ERRORMESSAGE);

	}

	@Test
	public void verifyTherememberMeBoxCheckBoxIsSelected() {
		sp = new SignInPage(driver);
		sp.selectRememberMeBox();
		Boolean actualResult = sp.verifyTherememberMeBoxCheckBoxIsSelected();
		Assert.assertTrue(actualResult, Constant.ERRORMESSAGEONCHECKBOX);

	}
	public void verifyTheURLofSignInPage() {
		sp = new SignInPage(driver);
		String actualURL=sp.getUrlOfSignInPage();
		String expecetdURL= "https://groceryapp.uniqassosiates.com/admin/login"; 
		Assert.assertEquals(actualURL, expecetdURL, Constant.ERRORMESSAGEFOEWRONGURL);
	}
}
