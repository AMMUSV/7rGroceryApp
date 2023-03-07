package ElementRepository;

import java.awt.AWTException;

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

	public void uploadAFile() throws AWTException {
		gu.fileUpload(driver, "C:\\Users\\HP\\Downloads\\pic2.jpeg", chooseFileButton);
	}

	public void sendlinkText() {
		linkElement.sendKeys("abc@gmail.com");

	}

	public void saveTheDetails() {
		gu.submitElement(saveElement);
	}
	
	public boolean checkingTheAddedDetails() throws AWTException {
		uploadAFile();
		sendlinkText();
		saveTheDetails();
		return false;
		

		}
		
}
	
//	// table[@class='table table-bordered table-hover
//	// table-sm']//tbody//tr[1]//td[4]//a[1]----------------edit
//
//
