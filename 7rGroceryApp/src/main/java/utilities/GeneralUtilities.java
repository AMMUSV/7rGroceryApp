package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

	public Boolean checkWhetherTheRadioButtonIsSelected(WebElement element) {
		Boolean value = element.isSelected();
		return value;

	}

	public Boolean verifyTheCheckBoxButtonIsSelected(WebElement element) {
		Boolean value = element.isSelected();
		return value;

	}
	public void scrollToFindAnElement(WebElement element,WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	public void selectByIndexFromDropDown(WebElement element,int index) {
		Select select=new Select(element);
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



	public void fileUpload(WebDriver driver, String filepath, WebElement element) throws AWTException {

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

	public String selectValueFromDropDown(WebElement element, String textToSelect) {
		Select obj = new Select(element);
		obj.selectByVisibleText(textToSelect);
		WebElement seclecetedElement = obj.getFirstSelectedOption();
		String text = seclecetedElement.getText();
		return text;
	}

	public Boolean verifywhetherTheCheckBoxIsSelected(WebElement element) {
		Boolean checkboxSeleceted = element.isSelected();
		return checkboxSeleceted;
	}

	public boolean checkAnElement(List<WebElement> elements, String text) {
		boolean value = true;
		for (int i = 0; i < elements.size(); i++) {
			String listedElementsTextValues = elements.get(i).getText();
			if (!listedElementsTextValues.contains(text))
				;
			{
				value = false;
			}
		}
		return value;

	}

	public String getTheAttributeStringOfAnElement(WebElement element, String attributename) {

		String attributevalue = element.getAttribute(attributename);
		return attributevalue;
	}

	

	public String getTheStatusOfElement(List<WebElement> elementsInColumn, String name, int d) {
		String locator = null;
		for (int i = 0; i < elementsInColumn.size(); i++) {
			String value = elementsInColumn.get(i).getText();

			if (value.contains(name)) {

				locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + (i + 1)+ "]//td[d]";

			}
		}

		WebElement cellValue = driver.findElement(By.xpath(locator));
		String textValuealue = cellValue.getText();
		return textValuealue;

	}
	
	public String getTheCorrespondingStringValueToAnElement(WebElement element) {
		 List<WebElement> rowValues= driver.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]"));
				 for(int i=0;i<rowValues.size();i++)
	        {
	        	if(rowValues.get(i).getText().equals(element));
	        	{
	        		String locator ="table[@class='table table-bordered table-hover table-sm']//tbody//tr[ \"+ i+1+ \" ]//td[5]";
	        		 WebElement cellValue =	driver.findElement(By.xpath(locator));
	        	        String cellValueText = cellValue.getText();
	        	       
	        	}
	        	break; 
	        	
	        }
		return null;
	}
	
	//table[@id='dtBasicExample']//tbody//tr[ "+ i+1+ " ]//td[4]
	
	//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]

	//table[@class='table table-bordered table-hover table-sm']//tbody//tr[ "+ i+1+ " ]//td[5]
	
	public String getCurrentUrl(WebDriver driver2) {
		return driver.getCurrentUrl();	
		
	}

}
//table[@class='table table-bordered table-hover
	// table-sm']//tbody//tr[1]//td[5]//a[3]------------xpath of delete icon