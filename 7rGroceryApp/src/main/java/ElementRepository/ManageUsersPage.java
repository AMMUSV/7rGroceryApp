package ElementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GeneralUtilities;

public class ManageUsersPage  {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public ManageUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// to initiaLIZE elements with factory
	}

	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-user'])[1]")
	WebElement manageUsersElement;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	List<WebElement> userColumnelements;

	@FindBy(xpath = "(//div[@class='profile-info-name'])[3]")
	WebElement passwordOfRubyVarghese;

	public void selecetmanageUsersPage() {
		gu.selectAnElement(manageUsersElement);
	}

	public String getTheStatusOfUser(String name) {
		String locator = null;
		for (int i = 0; i < userColumnelements.size(); i++) {
			String value = userColumnelements.get(i).getText();

			if (value.contains(name)) {

				locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + (i + 1)
						+ "]//td[5]//a";
				break;
			}
		}
		WebElement userStatusElement = driver.findElement(By.xpath(locator));
	String status= userStatusElement.getText();
	return status;
			
	}

	public String getThePasswordOfRubyVarghese() {
		String valueString = gu.getTextOfElement(passwordOfRubyVarghese);
		return valueString;
	}
}
