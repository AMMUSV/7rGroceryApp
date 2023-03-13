package ElementRepository;
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

	@FindBy(xpath = "//p[text()='Manage Expense']")
	WebElement manageExpense;

	@FindBy(id = "sidebar-overlay")
	WebElement newButton;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[1]")
	WebElement orderCashElement;

	public void selectManageExpenseDropDown() {
		gu.selectAnElement(manageExpenseDropDown);
	}

	public void selectManageExpense() {
		gu.selectAnElement(manageExpense);
	}
	
	public boolean selectionOfManageExpenseRadioButton() {
		gu.selectAnElement(manageExpense);
		boolean value = manageExpense.isSelected();
		return value;

	}

	public String getBackgroundColorOfNewButton() {
		String value = gu.getCssValueOfElements(newButton, "background-color");
		return value;

	}
	public String getTheCreditCashOfOrderCash296()
	{
		String value =gu.getTheCorrespondingStringValueToAnElement(orderCashElement);
		return value;
	}

}
