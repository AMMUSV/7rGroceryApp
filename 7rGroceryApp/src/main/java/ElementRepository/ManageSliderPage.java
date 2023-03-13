package ElementRepository;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GeneralUtilities;

public class ManageSliderPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public ManageSliderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// to initiaLIZE elements with factory

	}

	@FindBy(xpath = "//p[text()='Manage Slider']")
	WebElement manageSlider;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButtonElement;

	@FindBy(xpath = "//input[@name='main_img']")
	WebElement chooseFileButton;

	@FindBy(xpath = "//input[@class='form-control']")
	WebElement linkElement;

	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement saveElement;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[2]")
	List<WebElement>  columnLinkElementListElement;

	public void selectManageSlider()
	{
		gu.selectAnElement(manageSlider);
	}
	
	public void selectNewButtonElement()
	{
		gu.selectAnElement(newButtonElement);
	}
	public void uploadAFile() throws AWTException {
		gu.fileUpload(driver, "C:\\Users\\HP\\Downloads\\pic2.jpeg", chooseFileButton);
	}

	public void sendlinkText() {
		linkElement.sendKeys("abc@gmail.com");

	}
	public void saveTheDetails() {
		gu.submitElement(saveElement);
	}

	public void savingNewData() throws AWTException {
		uploadAFile();
		sendlinkText();
		saveTheDetails();

	}
	public boolean checkingTheAddedElementIspresent() throws AWTException {
		savingNewData();
		Boolean value = gu.verifyWhetherAnItemIsInList(columnLinkElementListElement, "abc@gmail.com");
		return value;
	}
	public String getThebackgroundColorOfSaveButton() {
		
			return gu.getCssValueOfElements(saveElement, "background-color");
		
	}
}