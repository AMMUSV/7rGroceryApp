package ElementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class LocationPage {
	WebDriver driver;
	ManageProductPage mp;
	LocationPage lcp;
	GeneralUtilities gu = new GeneralUtilities();

	public LocationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// to initiaLIZE elements with factory
	}

	@FindBy(linkText = "Remember Me")
	WebElement rememberMe;

	@FindBy(linkText = "Manage Location")
	WebElement manageLocation;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[6]//a[1]") // dynamic
	WebElement editIcon;

	@FindBy(id = "st_id")
	WebElement state;

	public void selectManageLocation() {
		manageLocation.click();
	}

	public void selectEditIcon() {
		editIcon.click();
	}

	public String selectValueFromDropDown(String valueString) {
		String value = gu.selectValueFromDropDown(state, valueString);
		return value;
	}

}
