package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import ElementRepository.AdminUsersPage;
import ElementRepository.SignInPage;
import constant.Constant;
import utilities.RandomUtility;

public class AdminUsersPageTestCases extends BaseClass {
	AdminUsersPage ap;
	SignInPage sp;
	RandomUtility ru = new RandomUtility();

	@Test(groups = {"High","Critical"}, priority=1)
	public void verifyBackGroundColorOfSearchButton() {
		sp = new SignInPage(driver);
		ap = new AdminUsersPage(driver);
		sp.SignInCredentials(prop.getProperty("Username"), prop.getProperty("Password"));
		ap.selectAdminUsersPage();
		String actualColor = ap.getCssValueOfsearchButton();
		String expectedColor = "rgba(0, 123, 255, 1)";
		Assert.assertEquals(actualColor, expectedColor, "bgColor of NewFolderAction Button Was not as expeceted");
	}
	@Test
	public void verifyUsersAreAdded(String username,String type) {
		sp = new SignInPage(driver);
		sp.SignInCredentials(prop.getProperty("Username"), prop.getProperty("Password"));
		ap = new AdminUsersPage(driver);
		ap.selectAdminUsersPage();
		ap.addingNewUsers(username,ru.randomPassword(),type);
		boolean actual =ap.verifyUserIsPresent(username);
		Assert.assertTrue(actual,Constant.ERRORMESSAGE_USERSNOTADDED);
		
		}
	@Test
	public void verifyUserIsDeleted(String username,String type)	{
		sp = new SignInPage(driver);
		sp.SignInCredentials(prop.getProperty("Username"), prop.getProperty("Password"));
		ap = new AdminUsersPage(driver);
		ap.selectAdminUsersPage();
		ap.deleteUser(username);
		boolean actual=ap.verifyUserIsPresent(username);
		Assert.assertFalse(actual,Constant.ERRORMESSAGE_USERSNOTDELETED);
		
}
	
}
