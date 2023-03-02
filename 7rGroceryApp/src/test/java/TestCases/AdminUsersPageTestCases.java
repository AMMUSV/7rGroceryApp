package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import ElementRepository.AdminUsersPage;
import ElementRepository.SignInPage;

public class AdminUsersPageTestCases extends BaseClass {
	AdminUsersPage ap;
	SignInPage sp;

	@Test
	public void verifyBackGroundColorOfSearchButton() {
		sp = new SignInPage(driver);
		ap = new AdminUsersPage(driver);
		sp.SignInCredentials("admin", "admin");
		// ap.selectmoreInfobutton();
		// ap.selectDeleteButton();
		String actualColor = ap.getCssValueOfsearchButton();
		String expectedColor = "rgba(0, 123, 255, 1)";
		Assert.assertEquals(actualColor, expectedColor, "bgColor of NewFolderAction Button Was not as expeceted");
	}
}
