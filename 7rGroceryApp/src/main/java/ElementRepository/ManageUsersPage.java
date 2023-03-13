package ElementRepository;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GeneralUtilities;

public class ManageUsersPage {

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

	@FindBy(xpath = "(//div[@class='profile-info-name'])[2]")
	WebElement passwordOfRubyVarghese;

	public void selecetmanageUsersPage() {
		gu.selectAnElement(manageUsersElement);
	}

	public String getTheStatusOfNeena() {
		return gu.getTheStatusOfElement(userColumnelements, "Neena", 1);
	}

	public String getThePasswordOfNimisha() {
		String valueString = gu.getTextOfElement(passwordOfRubyVarghese);
		return valueString;
	}
}
