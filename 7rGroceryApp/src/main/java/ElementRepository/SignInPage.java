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

	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	WebElement signInButton;
	
	@FindBy(xpath = "//input[@name='username']")
	WebElement userName;

	@FindBy(xpath = "//input[@type='password']")
	WebElement passWord;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement errorMessage;

	@FindBy(xpath = "//label[@for='remember']")
	WebElement rememberMeCheckBox;
	
	@FindBy(xpath="//input[@id='remember']")
	WebElement rememberMe;
	
	
	public void SignInCredentials(String username, String password) {
		userName.sendKeys(username);
		passWord.sendKeys(password);
		signInButton.click();

	}
	public String getUrlOfSignInPage() {
		
		return gu.getCurrentUrl(driver);
	}
	
	public String getTheTextOfSignInButton() {
		return gu.getTextOfElement(signInButton);

	}
	
	public void selectRememberMeCheckBox() {
		rememberMeCheckBox.click();
	}
	
	public String getBackroundColorOfSignInButton() {
		return gu.getCssValueOfElements(signInButton, "background-color");
	}

	public String getTextofAlertMessageWhileLogin() {
		
		return gu.getTextOfElement(errorMessage);
		
	}
	
	public String getAttributeValueOfUserName() {
		return gu.getAttributeValueOfElement(userName,"type");
	}
	public Boolean verifyTherememberMeBoxCheckBoxIsSelected() {
		Boolean selecetdCheckbox = gu.verifyTheCheckBoxOrRadioButtonIsSelected(rememberMe);
		return selecetdCheckbox;
	}
	
	}


