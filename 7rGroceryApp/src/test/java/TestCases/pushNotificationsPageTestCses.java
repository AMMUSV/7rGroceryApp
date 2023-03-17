package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import ElementRepository.PushNotificationsPage;
import ElementRepository.SignInPage;
import constant.Constant;
import utilities.ExcelRead;

public class pushNotificationsPageTestCses extends BaseClass {
	SignInPage sp;
	PushNotificationsPage pp;
	ExcelRead eRead = new ExcelRead();

	@Test(priority = 1, groups = { "sanity" })
	public void verifyalertmessagesSendingtheDeatails() {

		pp = new PushNotificationsPage(driver);
		sp = new SignInPage(driver);
		sp.SignInCredentials(eRead.readFromExcelFile(1, 1),eRead.readFromExcelFile(2, 1));
		pp.selectPushNotifications();
		pp.enterTitle("title");
		pp.enterDescription("details are added");
		pp.clickSendButton();
		String actualResult = pp.getTextOfAlertMessage();
		String expecetedResult = "×\n" + "Alert!\n" + "Message send successfully";
		Assert.assertEquals(actualResult, expecetedResult, "actual result is not as expeceted");
	}

	@Test(priority = 2, groups = { "sanity" })
	public void verifyBackGroundColorOfSendButton() {

		pp = new PushNotificationsPage(driver);
		sp = new SignInPage(driver);
		sp.SignInCredentials(eRead.readFromExcelFile(1, 1),eRead.readFromExcelFile(2, 1));
		pp.selectPushNotifications();

		String actualColor = pp.getBackgroundcolorOfSendBUtton();
		String expectedColor = prop.getProperty("expectedBackGroundColorOfSendButton");
		//String expectedColor = eRead.readFromExcelFile(9, 1);
		Assert.assertEquals(actualColor, expectedColor, Constant.ERRORMESSAGE_BACKGROUNDCOLOR);

	}
}
