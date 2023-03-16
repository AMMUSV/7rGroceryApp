package ElementRepository;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageProductPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public ManageProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// to initiaLIZE elements with factory

	}

	@FindBy(linkText = "Manage Product")
	WebElement managaeProductElement;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	WebElement resetButton;

	@FindBy(xpath = "//h1[@class='m-0 text-dark']")
	WebElement titleOfManageProductPage;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[9]//a[1]")
	WebElement editButton;

	@FindBy(xpath = "//input[@value = 'Nonveg']")
	WebElement nonvegRadioButton;

	@FindBy(xpath = "//input[@placeholder='Title']")
	WebElement titlebox;
	
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")
	WebElement searchActionButton;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	List<WebElement> columnElementsByTitle;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[3]")
	List<WebElement> columnElementsByCategory;
	
	@FindBy(xpath="//input[@placeholder='Title']")
	WebElement titleElement;
	
	public void clickManageProduct() {
		managaeProductElement.click();
	}

	public void clickNewButton() {
		newButton.click();
	}
	
	public String getBackgroundcolorOfNewBUtton() {

		String bgclor = gu.getCssValueOfElements(newButton, "background-color");
		return bgclor;

	}

	public String getBackgroundcolorOfResetBUtton() {

		String bgclor = gu.getCssValueOfElements(resetButton, "background-color");
		return bgclor;

	}
	
	
	public String getTheTextOfManagreProductsPage() {
		String textOfTitle = gu.getTextOfElement(titleOfManageProductPage);
		return textOfTitle;

	}

	public void selectRadiobButtonForNonVegInNewProduct() {
		nonvegRadioButton.click();

	}


	public Boolean checkWhetherNonvegRadioButtonIsSelected() {
		Boolean value = gu.verifyTheCheckBoxOrRadioButtonIsSelected(nonvegRadioButton);
		return value;

	}

	public void selectSearchIcon() {
		gu.selectAnElement(searchButton);

	}

	public void enterTitleToBeSearched(String titleValue) {
		titlebox.sendKeys(titleValue);

	}

	public void clickSearchActionButton() {
		gu.selectAnElement(searchActionButton);

	}
	
	public String getPlaceholderTextOfTitleField() {
		return gu.getAttributeValueOfElement(titlebox, "placeholder");

	}
	public boolean checkWhetherManageProductTabIsSelected() {
		return gu.verifyWhetherOptionIsSelected(managaeProductElement,"class","active");
		
	}
	
	public boolean getProductsListedCorrespondingToTitleSearched(String title) {
		enterTitleToBeSearched(title);
		clickSearchActionButton();
		return gu.checkAnItemWhenSearched(columnElementsByTitle,title );
	}
	public boolean verifyFunctionalityOfResetButton() {
		searchButton.click();
		resetButton.click();
		return titleElement.isDisplayed();
		
		
	}
	
}
