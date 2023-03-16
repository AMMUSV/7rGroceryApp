package TestCases;

import org.testng.annotations.Test;

import ElementRepository.ManageProductPage;
import ElementRepository.SignInPage;
import constant.Constant;
import utilities.ExcelRead;

import org.testng.Assert;

public class SignInPageTestCases extends BaseClass {

	SignInPage sp;
	ManageProductPage mp;
	ExcelRead eRead= new ExcelRead();

	@Test(priority = 1)
	public void verifyTheTextOfSignInButton() {
		sp = new SignInPage(driver);
		String actualResult = sp.getTheTextOfSignInButton();
		String expectedResult = eRead.readFromExcelFile(6,1);
		Assert.assertEquals(actualResult, expectedResult, Constant.ERRORMESSAGE_SIGNINBUTTON);

	}

	@Test(groups =  "Critical" , priority = 2)
	public void verifyTheAlertMessageForErrorWhileLogIn() {
		sp = new SignInPage(driver);
		sp.SignInCredentials(prop.getProperty("InvalidUsername"), prop.getProperty("InvalidPassword"));
		String actualResult = sp.getTextofAlertMessageWhileLogin();
		actualResult = actualResult.replaceAll("[^a-zA-Z0-9]", " ");
		String expectedResult = Constant.ALERTMESSAGE_TEXT;
		Assert.assertEquals(actualResult, expectedResult, Constant.ERRORMESSAGE_ALERT);

	}

	@Test(groups = "Critical", priority = 3)
	public void verifyThatTherememberMeBoxCheckBoxIsSelected() {
		sp = new SignInPage(driver);
		sp.selectRememberMeCheckBox();
		Boolean actualResult = sp.verifyTherememberMeBoxCheckBoxIsSelected();
		Assert.assertTrue(actualResult, Constant.ERRORMESSAGE_ONCHECKBOX);

	}

	@Test(groups = "High", priority = 4)
	public void verifyTheURLofSignInPage() {
		sp = new SignInPage(driver);
		String actualURL = sp.getUrlOfSignInPage();
		String expextedURL = prop.getProperty("BaseURL");
		Assert.assertEquals(actualURL, expextedURL, Constant.ERRORMESSAGE_FOREWRONGURL);
	}

	@Test(groups = "High", priority = 5)
	public void verifyTheBackGroundColorOfSignInButton() {
		sp = new SignInPage(driver);
		String actualResult = sp.getBackroundColorOfSignInButton();
		String expectedResult = eRead.readFromExcelFile(5, 1);
		Assert.assertEquals(actualResult, expectedResult, Constant.ERRORMESSAGE_BACKGROUNDCOLOR);

	}

	@Test(groups = "Critical", priority =6)
	public void verifyLoginwithInvalidCredentails() {
		sp = new SignInPage(driver);
		sp.SignInCredentials(prop.getProperty("InvalidUsername"), prop.getProperty("InvalidPassword"));
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = prop.getProperty("LoginPageURL");
		Assert.assertEquals(actualUrl, expectedUrl, Constant.ERRORMESSAGE_INVALIDLOGIN);
	}
}
