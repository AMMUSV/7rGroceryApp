package TestCases;

import org.testng.Assert;

import org.testng.annotations.Test;

import DataProvider.DataProviderClass;
import ElementRepository.AdminUsersPage;
import ElementRepository.SignInPage;
import constant.Constant;
import utilities.RandomUtility;
import utilities.RetryUtils;

public class AdminUsersPageTestCases extends BaseClass {
	AdminUsersPage ap;
	SignInPage sp;
	RandomUtility ru = new RandomUtility();

	@Test(groups = { "High", "Critical" }, priority = 1)
	public void verifyBackGroundColorOfSearchButton() {
		sp = new SignInPage(driver);
		ap = new AdminUsersPage(driver);
		sp.SignInCredentials(prop.getProperty("Username"), prop.getProperty("Password"));
		ap.selectAdminUsersPage();
		String actualColor = ap.getCssValueOfsearchButton();
		String expectedColor = "rgba(0, 0, 0, 0)";
		Assert.assertEquals(actualColor, expectedColor, "bgColor of NewFolderAction Button Was not as expeceted");
	}

	@Test(dataProvider = "add_user", dataProviderClass = DataProviderClass.class, groups = { "sanity","regression" }, priority = 1, retryAnalyzer = RetryUtils.class)
	public void verifyUsersAreAdded(String username, String type) {
		sp = new SignInPage(driver);
		sp.SignInCredentials(prop.getProperty("Username"), prop.getProperty("Password"));
		ap = new AdminUsersPage(driver);
		ap.selectAdminUsersPage();
		ap.addingNewUsers(username, ru.randomPassword(), type);
		boolean actual = ap.verifyUserIsPresent(username);
		Assert.assertTrue(actual, Constant.ERRORMESSAGE_USERSNOTADDED);

	}

	@Test(dataProvider = "delete_user", dataProviderClass = DataProviderClass.class, groups = { "sanity",
			"regression" }, priority = 2, retryAnalyzer = RetryUtils.class)
	public void verifyUserIsDeleted(String username, String type) {
		sp = new SignInPage(driver);
		sp.SignInCredentials(prop.getProperty("Username"), prop.getProperty("Password"));
		ap = new AdminUsersPage(driver);
		ap.selectAdminUsersPage();
		ap.deleteUser(username);
		boolean actual = ap.verifyUserIsPresent(username);
		Assert.assertFalse(actual, Constant.ERRORMESSAGE_USERSNOTDELETED);

	}

	@Test(priority = 3, groups = { "regression" })
	public void verifySearchButtonIsClickable() {
		sp = new SignInPage(driver);
		sp.SignInCredentials(prop.getProperty("Username"), prop.getProperty("Password"));
		ap = new AdminUsersPage(driver);
		ap.selectAdminUsersPage();
		boolean actual = ap.verifySearchButtonIsClickable();
		Assert.assertTrue(actual, Constant.ERRORMESSAGE_ADMINUSERS_SEARCHBUTTON);
	}
}
