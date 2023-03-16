package ElementRepository;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GeneralUtilities;

public class ManageExpensePage {
	WebDriver driver;
	ManageExpensePage mep;
	GeneralUtilities gu = new GeneralUtilities();

	public ManageExpensePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// to initiaLIZE elements with factory
	}

	@FindBy(xpath = "//i[@class='nav-icon fas fa-money-bill-alt']")
	WebElement manageExpenseDropDown;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-expense']")
	WebElement manageExpense;

	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	List<WebElement> titleColumnElements;

	public void selectManageExpenseDropDown() {
		gu.selectAnElement(manageExpenseDropDown);
	}

	public void selectManageExpense() {
		gu.selectAnElement(manageExpense);
	}
	
	public boolean selectionOfManageExpenseButton() {
		gu.selectAnElement(manageExpense);
		return gu.verifyWhetherOptionIsSelected(manageExpense, "class", "active");
		

	}

	public String getBackgroundColorOfNewButton() {
		String value = gu.getCssValueOfElements(newButton, "background-color");
		return value;

	}
	public String getTheDateOfExpenceOfUser(String name) {
		String locator = null;
		for (int i = 0; i < titleColumnElements.size(); i++) {
			String value = titleColumnElements.get(i).getText();

			if (value.contains(name)) {

				locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + (i + 1)
						+ "]//td[2]";
				break;
			}
		}
		WebElement Date = driver.findElement(By.xpath(locator));
	String value= Date.getText();
	return value;
			
	}

}
