package ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class AdminUsersPage {
	private static Object selectDeleteButton;

	WebDriver driver;

	SignInPage sp;
	GeneralUtilities gu = new GeneralUtilities();

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// to initiaLIZE elements with factory
	}

	@FindBy(linkText = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'])[2]")
	WebElement moreInfobutton;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[5]//a[3]")
	WebElement deleteButton;

	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/user/status?id=3352&st=inactive&page_ad=1'])[1]")
	WebElement statusElement;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;

	public void selectDeleteButton() {
		gu.selectAnElement(deleteButton);
	}

	public String presenceOfAlertmessage() {
		String value = ((WebDriver) AdminUsersPage.selectDeleteButton).switchTo().alert().getText();
		return value;

	}

	public void selectmoreInfobutton() {
		gu.selectAnElement(moreInfobutton);
	}

	public String getCssValueOfsearchButton() {
		String value = gu.getCssValueOfElements(searchButton, "background-color");
		return value;
	}

}
