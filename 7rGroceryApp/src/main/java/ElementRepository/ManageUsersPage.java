package ElementRepository;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GeneralUtilities;

public class ManageUsersPage {

	WebDriver driver;

	LocationPage lcp;
	GeneralUtilities gu = new GeneralUtilities();

	public ManageUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// to initiaLIZE elements with factory
	}

	@FindBy(xpath = "//p[text()='Manage Users']")
	WebElement manageusersElement;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	WebElement columnelements;

	@FindBy(xpath = "(//div[@class='profile-info-name'])[2]")
	WebElement password;

	public void selecetmanageUsersPage() {
		gu.selectAnElement(manageusersElement);
	}

	public String getTheStatusOfNeena() {
		return gu.getTheStatusOfElement((List<WebElement>) columnelements, "Neena", 1);
	}

	public String getThePasswordOfNimisha() {
		String valueString = gu.getTextOfElement(password);
		return valueString;
	}
}
