package ElementRepository;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ListPages {

	WebDriver driver;
	ManageProductPage mp;
	GeneralUtilities gu = new GeneralUtilities();

	public ListPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// to initiaLIZE elements with factory

	}

	@FindBy(linkText = "More info")
	WebElement moreInfobutton;

	@FindBy(xpath = "/html/body/div/div[1]/section/div[4]/div[2]/table/tbody/tr[1]/td[5]/a[1]") // change it
	WebElement editButton;

	@FindBy(xpath = "//input[@name='main_img']")
	WebElement chooseFileButton;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement updateButton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertMessage;

	public void selectmoreInfobutton() {
		gu.selectAnElement(moreInfobutton);
	}

	public void selecteditButton() {
		gu.selectAnElement(editButton);
	}

//	public void dynamicTable() {
//		gu.selectAnElement(editButton);
//		WebElement cellValue =	@FindBy(By.xpath(locator));
//	}
//	
//	public void selectchooseFileButton() {
//		chooseFileButton.submit();
//
//	}

	public void uploadingTheFile() throws AWTException {
		gu.fileUpload(driver, "C:\\Users\\HP\\Downloads\\pic1.jpeg", chooseFileButton);
	}

	public void selectUpdateButton() {

		updateButton.submit();
	}

	public Boolean isAlertPresent() {
		Boolean value = gu.isElementPresent(alertMessage);
		return value;
	}

}
