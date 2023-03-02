package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import ElementRepository.PushNotificationsPage;
import ElementRepository.SignInPage;
import constant.Constant;

public class pushNotificationsPageTestCses extends BaseClass {
	SignInPage sp;
	PushNotificationsPage pp;

	@Test
	public void verifyalertmessagesSendingtheDeatails() {

		pp = new PushNotificationsPage(driver);
		sp = new SignInPage(driver);
		sp.SignInCredentials("admin", "admin");
		pp.selectPushNotifications();
		pp.enterTitle("title");
		pp.enterDescription("details are added");
		pp.clickSendButton();
		String actualResult = pp.getTextOfAlertMessage();
		String expecetedResult = "×\n" + "Alert!\n" + "Message send successfully";
		Assert.assertEquals(actualResult, expecetedResult, "actual result is not as expeceted");
	}

	@Test
	public void verifyBackGroundColorOfSendButton() {

		pp = new PushNotificationsPage(driver);
		sp = new SignInPage(driver);
		sp.SignInCredentials("admin", "admin");
		pp.selectPushNotifications();

		String actualColor = pp.getBackgroundcolorOfSendBUtton();
		String expectedColor = "rgba(23, 162, 184, 1)";
		Assert.assertEquals(actualColor, expectedColor, "bgColor of send Button Was not as expeceted");

	}
}
