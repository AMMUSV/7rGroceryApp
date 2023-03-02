package ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class SignInPage {

	WebDriver driver;
	ManageProductPage mp;
	GeneralUtilities gu = new GeneralUtilities();

	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// to initiaLIZE elements with factory

	}

	@FindBy(xpath = "//input[@name='username']")
	WebElement userName;

	@FindBy(xpath = "//input[@type='password']")
	WebElement passWord;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement SignInButton;

	@FindBy(xpath = "//input[@name='username']")
	WebElement inavaliUserName;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement errorMessage;

	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement rememberMeBox;
	public String getUrlOfSignInPage() {
		
		return gu.getCurrentUrl(driver);
	}
	public void enterInvalidUserName(String username) {
		inavaliUserName.sendKeys(username);
	}

	public String getTheTextOfSignInButton() {
		return gu.getTextOfElement(SignInButton);

	}

	public String getErrorTextOfElement() {
		String text = gu.getTextOfElement(errorMessage);
		return text;
	}

	public Boolean verifyTherememberMeBoxCheckBoxIsSelected() {
		Boolean value = gu.verifyTheCheckBoxButtonIsSelected(rememberMeBox);
		return value;

	}

	public void selectRememberMeBox() {
		rememberMeBox.isEnabled();
	}

	public Boolean verifyTheRemembermeCheckBoxIsSelected() {
		Boolean selecetdCheckbox = gu.verifyTheCheckBoxButtonIsSelected(rememberMeBox);
		return selecetdCheckbox;
	}

	public void SignInCredentials(String username, String password) {
		userName.sendKeys(username);
		passWord.sendKeys(password);
		SignInButton.click();

	}
}
