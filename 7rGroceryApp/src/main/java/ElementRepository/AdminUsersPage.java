package ElementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class AdminUsersPage {

	WebDriver driver;

	SignInPage sp;
	GeneralUtilities gu = new GeneralUtilities();

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// to initiaLIZE elements with factory
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")
	WebElement adminUsers;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;

	@FindBy(id = "username")
	WebElement usernameField;

	@FindBy(id = "password")
	WebElement passwordField;

	@FindBy(id = "user_type")
	WebElement usertype;

	@FindBy(xpath = "//button[@name='Create']")
	WebElement saveButton;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[5]//a[3]")
	WebElement deleteButton;

	@FindBy(xpath = "//i[@class=' fa fa-search']")
	WebElement searchButton;

	@FindBy(id = "un")
	WebElement searchName;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	List<WebElement> usernameList;

	public void selectAdminUsersPage() {
		gu.selectAnElement(adminUsers);

	}

	public void addingNewUsers(String username, String password, String type) {
		newButton.click();
		usernameField.sendKeys(username);

		passwordField.sendKeys(password);
		gu.selectDropDownValueByVisibleText(usertype, type);
		saveButton.click();
	}

	public boolean verifyUserIsPresent(String username) {
		return gu.verifyWhetherAnItemIsInList(usernameList, username);
	}

	public void selectDeleteButton() {
		gu.selectAnElement(deleteButton);
	}

	public String getCssValueOfsearchButton() {
		String value = gu.getCssValueOfElements(searchButton, "background-color");
		return value;
	}

	public void deleteUser(String user) {
		String locator = null;
		for (int i = 0; i < usernameList.size(); i += 2) {
			if ((usernameList.get(i).getText()).equals(user)) {
				locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + (i + 1)
						+ "]//td[5]//a[3]";
				break;
			}
		}
		System.out.println("locator" + locator);
		WebElement deleteUser = driver.findElement(By.xpath(locator));
		deleteUser.click();
		driver.switchTo().alert().accept();
	}

	public boolean verifySearchButtonIsClickable() {
		searchButton.click();
		return searchName.isDisplayed();
	}

}
