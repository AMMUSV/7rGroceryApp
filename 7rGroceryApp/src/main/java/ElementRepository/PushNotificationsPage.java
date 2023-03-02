package ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GeneralUtilities;

public class PushNotificationsPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public PushNotificationsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// to initiaLIZE elements with factory

	}

	@FindBy(linkText = "Push Notifications")
	WebElement pushNotification;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement sendButton;

	@FindBy(id = "title")
	WebElement titleTab;

	@FindBy(id = "description")
	WebElement DescriptionTab;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertMessage;

	public void selectPushNotifications() {
		pushNotification.click();

	}

	public void enterTitle(String titlename) {
		titleTab.sendKeys(titlename);

	}

	public void enterDescription(String description) {
		DescriptionTab.sendKeys(description);

	}

	public void clickSendButton() {
		sendButton.click();

	}

	public String getBackgroundcolorOfSendBUtton() {
		String value = gu.getCssValueOfElements(sendButton, "background-color");
		return value;
	}

	public String getTextOfAlertMessage() {
		String text = alertMessage.getText();
		return text;
	}
}
