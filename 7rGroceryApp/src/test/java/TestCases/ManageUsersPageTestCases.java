package TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ElementRepository.ManageUsersPage;
import ElementRepository.SignInPage;

public class ManageUsersPageTestCases {
	WebDriver driver;
	SignInPage sp;
	ManageUsersPage mup;

	@Test
	public void verifyTheStatusOfNeena() {
		sp = new SignInPage(driver);
		sp.SignInCredentials("admin", "admin");
		mup = new ManageUsersPage(driver);
		mup.selecetmanageUsersPage();
		String actualResult = mup.getTheStatusOfNeena();
		String expecetedResult = "Active";
		Assert.assertEquals(actualResult, expecetedResult);
	}

	public void verifyThePasswordOfNimisha() {
		sp = new SignInPage(driver);
		sp.SignInCredentials("admin", "admin");
		mup = new ManageUsersPage(driver);
		mup.selecetmanageUsersPage();
		String actualResult = mup.getThePasswordOfNimisha();
		String expecetedResult = "Password : vih@@n";
		Assert.assertEquals(actualResult, expecetedResult, "Password of Nimisha is not as expected");
	}
}
