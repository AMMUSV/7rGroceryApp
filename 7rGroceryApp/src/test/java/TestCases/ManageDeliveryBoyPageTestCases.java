package TestCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import DataProvider.DataProviderClass;
import ElementRepository.ManageDeliveryBoyPage;
import ElementRepository.SignInPage;
import constant.Constant;
import utilities.RandomUtility;

public class ManageDeliveryBoyPageTestCases extends BaseClass{
	SignInPage sp;
	ManageDeliveryBoyPage md;
	RandomUtility ru = new RandomUtility();

  
  @Test(dataProvider="add_deliveryBoy",dataProviderClass = DataProviderClass.class, priority = 1,groups = { "regression"})
	public void verifyNewDeliveryBoyIsAdded(String name,String address) {
	  sp = new SignInPage(driver);
	  md= new ManageDeliveryBoyPage(driver);
	  sp.SignInCredentials(prop.getProperty("Username"),prop.getProperty("Password"));
	  md.selectManageDeliveryBoyPage();
		String emailid=name+ru.randomnumbers()+"@gmail.com";
		String username = name+ru.randomnumbers();
		md.addNewDeliveryBoy(name,emailid,ru.randomPhoneNumber(),address,username,ru.randomPassword());
		boolean actual = md.verifyDeliveryBoyAdded(username);
		Assert.assertTrue(actual, Constant.ERRORMESSAGE_DELIVERYBOYNOTADDED);
}

	//@Test(priority = 2,groups = { "regression"})
	public void verifyFunctionalityOfRestButton() {
		sp = new SignInPage(driver);
		  md= new ManageDeliveryBoyPage(driver);
		  sp.SignInCredentials(prop.getProperty("Username"),prop.getProperty("Password"));
		md = new ManageDeliveryBoyPage(driver);
		md.selectManageDeliveryBoyPage();
		boolean actual = md.verifyFunctionalityOfResetButton();
		Assert.assertFalse(actual,Constant.ERRORMESSAGE_RESETFUNCTIONALITY);
	}
	
	
}
