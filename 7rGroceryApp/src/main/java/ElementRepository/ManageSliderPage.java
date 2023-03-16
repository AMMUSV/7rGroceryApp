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
	

	public void sendlinkText() {
		linkElement.sendKeys("pqrst@gmail.com");

	}
	public void selectSaveButton() {
		
		gu.submitElement(saveElement);
	}


	public boolean checkingTheAddedElementIspresent(String text) {
		gu.fileUpload(driver, "C:\\Users\\HP\\Downloads\\newpic.jpg", chooseFileButton);
		sendlinkText();
		selectSaveButton();
		selectManageSlider();
		boolean value =gu.verifyWhetherAnItemIsInList(columnLinkElementListElement, text);
		return value;
		
	}
	public String getThebackgroundColorOfSaveButton() {
		
			return gu.getCssValueOfElements(saveElement, "background-color");
		
	}
}