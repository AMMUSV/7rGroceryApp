package TestCases;



import org.testng.Assert;
import org.testng.annotations.Test;

import ElementRepository.ManageProductPage;
import ElementRepository.SignInPage;
import constant.Constant;

public class ManageProductPageTestCase extends BaseClass {

	ManageProductPage mp;
	SignInPage sp;

	@Test(priority = 1, groups = { "regression" })
	public void verifyBackGroundColorOfNewButton() {
		mp = new ManageProductPage(driver);
		sp = new SignInPage(driver);
		sp.SignInCredentials(prop.getProperty("Username"), prop.getProperty("Password"));
		mp.clickManageProduct();
		String actualColor = mp.getBackgroundcolorOfNewBUtton();
		String expectedColor = "rgba(220, 53, 69, 1)";
		Assert.assertEquals(actualColor, expectedColor, "bgColor of NewFolderAction Button Was not as expeceted");

	}

	@Test(priority = 2, groups = { "sanity","regression" })
	public void verifyBackGroundColorOfresetButtonButton() {
		mp = new ManageProductPage(driver);
		sp = new SignInPage(driver);
		sp.SignInCredentials(prop.getProperty("Username"), prop.getProperty("Password"));
		mp.clickManageProduct();
		String actualColor = mp.getBackgroundcolorOfResetBUtton();
		String expectedColor = "rgba(255, 193, 7, 1)";
		Assert.assertEquals(actualColor, expectedColor, "bgColor of reset Button Was not as expeceted");

	}

	@Test(priority = 3, groups = { "regression" })
	public void verifyWhetherManageProductTabIsSelected() {
		sp = new SignInPage(driver);
		sp.SignInCredentials(prop.getProperty("Username"), prop.getProperty("Password"));
		mp = new ManageProductPage(driver);
		mp.clickManageProduct();
		boolean actual = mp.checkWhetherManageProductTabIsSelected();
		Assert.assertTrue(actual, Constant.ERRORMESSAGE_MANAGEPRODUCTTAB);
	}

	@Test(priority = 4, groups = { "regression" })
	public void verifyThePlaceHolderTextOfProductTitle() {
		sp = new SignInPage(driver);
		sp.SignInCredentials(prop.getProperty("Username"), prop.getProperty("Password"));
		mp = new ManageProductPage(driver);
		mp.clickManageProduct();
		mp.selectSearchIcon();
		String actualResult = mp.getPlaceholderTextOfTitleField();
		String expectedResult = prop.getProperty("PlaceHolderTextOfTitle");
		Assert.assertEquals(actualResult, expectedResult, Constant.ERRORMESSAGE_MANAAGEPRODUCTS_PLACEHOLDER_TEXT);
	}

	@Test(priority = 5, groups = { "regression" })
	public void verifyTheTextOfManagreProductsPage() {
		mp = new ManageProductPage(driver);
		sp = new SignInPage(driver);
		sp.SignInCredentials(prop.getProperty("Username"), prop.getProperty("Password"));
		mp.clickManageProduct();
		String actualText = mp.getTheTextOfManagreProductsPage();
		String expectedText = "List Products";
		Assert.assertEquals(actualText, expectedText, Constant.ERRORMESSAGE_TITLE_TEXT);

	}

	@Test(priority = 6, groups = { "regression" })
	public void verifyNonVegRadioButtonIsSelected() {
		mp = new ManageProductPage(driver);
		sp = new SignInPage(driver);
		sp.SignInCredentials(prop.getProperty("Username"), prop.getProperty("Password"));
		mp.clickManageProduct();
		mp.clickNewButton();
		mp.selectRadiobButtonForNonVegInNewProduct();
		Boolean actuavalue = mp.checkWhetherNonvegRadioButtonIsSelected();
		Assert.assertTrue(actuavalue, Constant.ERRORMESSAGE_RADIOBUTTON_NONVEG);

	}

	@Test(priority = 7, groups = { "regression" })
	public void verifyProductsSearchByTitle() {
		mp = new ManageProductPage(driver);
		sp = new SignInPage(driver);
		sp.SignInCredentials(prop.getProperty("Username"), prop.getProperty("Password"));
		mp.clickManageProduct();
		mp.selectSearchIcon();
		boolean actualResult = mp
				.getProductsListedCorrespondingToTitleSearched(prop.getProperty("titleOfProductToBeSearched"));
		Assert.assertTrue(actualResult, Constant.ERRORMESSAGE_PRODUCTLISTED_TITLE);

	}

	@Test(priority = 8, groups = { "regression" })
	public void verifyFunctionalityOfRestButton() {
		sp = new SignInPage(driver);
		mp = new ManageProductPage(driver);
		sp.SignInCredentials(prop.getProperty("Username"), prop.getProperty("Password"));
		mp.clickManageProduct();
		mp.selectSearchIcon();
		boolean actual = mp.verifyFunctionalityOfResetButton();
		Assert.assertFalse(actual, Constant.ERRORMESSAGE_RESETFUNCTIONALITY);
	}
}
