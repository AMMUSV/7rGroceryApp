package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {
	WebDriver driver;

	public void selectAnElement(WebElement element) {
		element.click();
	}

	public void clearTextFromAnElement(WebElement element) {
		element.clear();
	}

	public void submitElement(WebElement element) {
		element.submit();
	}

	public String getTagNameOfAnElement(WebElement element) {
		return element.getTagName();
	}

	public String getCssValueOfElements(WebElement element, String propertyValue) {
		String value = element.getCssValue(propertyValue);
		return value;
	}

	public Boolean verifyTheCheckBoxOrRadioButtonIsSelected(WebElement element) {
		Boolean value = element.isSelected();
		return value;

	}

	public void selectByIndexFromDropDown(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getTextOfElement(WebElement element) {
		String text = element.getText();
		return text;
	}

	public Boolean isElementPresent(WebElement element) {
		Boolean value = element.isDisplayed();
		return value;
	}
	
		
	

	public void fileUpload(WebDriver driver, String filepath, WebElement element)  {
try {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		actions.click(element).perform();

		StringSelection ss = new StringSelection(filepath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		Robot obj = new Robot();
		obj.delay(250);
		obj.keyPress(KeyEvent.VK_CONTROL);
		obj.keyPress(KeyEvent.VK_V);
		obj.delay(250);

		obj.keyRelease(KeyEvent.VK_CONTROL);
		obj.keyRelease(KeyEvent.VK_V);
		obj.delay(250);

		obj.keyPress(KeyEvent.VK_ENTER);
		obj.keyRelease(KeyEvent.VK_ENTER);
}
catch(AWTException e) {
	System.out.println(e);
	}

	}


	public String getAttributeValueOfElement(WebElement element, String attributeType) {
		String attributeValue = element.getAttribute(attributeType);
		return attributeValue;
	}

	public String getTheStatusOfElement(List<WebElement> elementsInColumn, String name) {
		String locator = null;
		for (int i = 0; i < elementsInColumn.size(); i++) {
			String value = elementsInColumn.get(i).getText();

			if (value.contains(name)) {

				locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + (i + 1)
						+ "]//td[1]";

			}
		}

		WebElement cellValue = driver.findElement(By.xpath(locator));
		String textValuealue = cellValue.getText();
		return textValuealue;

	}

	

	public boolean checkAnItemWhenSearched(List<WebElement> columnElements, String searchText) {
		boolean value = true;
		for (int i = 0; i < columnElements.size(); i++) {
			String ListedElementText = columnElements.get(i).getText();
			if (!ListedElementText.toLowerCase().contains(searchText.toLowerCase())) {

				value = false;
			}
		}
		return value;
	}

	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();

	}

	public void selectDropDownValueByVisibleText(WebElement element, String visibleText) {
		Select obj = new Select(element);
		obj.selectByVisibleText(visibleText);

	}

	public boolean verifyWhetherAnItemIsInList(List<WebElement> columnElements, String searchText) {
		boolean value = false;
		for (int i = 0; i < columnElements.size(); i++) {
			String ListedElementText = columnElements.get(i).getText();
			if (ListedElementText.toLowerCase().equals(searchText.toLowerCase())) {

				value = true;
				break;

			}
		}
		return value;
	}

	public boolean verifyWhetherOptionIsSelected(WebElement element, String attributeType, String text) {
		boolean value = element.getAttribute(attributeType).contains(text);
		return value;
	}

}
