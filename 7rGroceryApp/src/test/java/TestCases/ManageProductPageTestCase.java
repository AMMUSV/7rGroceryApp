package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import ElementRepository.ManageProductPage;
import ElementRepository.SignInPage;

public class ManageProductPageTestCase extends BaseClass {

	ManageProductPage mp;
	SignInPage sp;

	// @Test
	public void verifyBackGroundColorOfNewButton() {
		mp = new ManageProductPage(driver);
		sp = new SignInPage(driver);
		sp.SignInCredentials("admin", "admin");
		mp.clickManageProduct();
		String actualColor = mp.getBackgroundcolorOfNewBUtton();
		String expectedColor = "rgba(220, 53, 69, 1)";
		Assert.assertEquals(actualColor, expectedColor, "bgColor of NewFolderAction Button Was not as expeceted");

	}

	// @Test
	public void verifyBackGroundColorOfresetButtonButton() {
		mp = new ManageProductPage(driver);
		sp = new SignInPage(driver);
		sp.SignInCredentials("admin", "admin");
		mp.clickManageProduct();
		String actualColor = mp.getBackgroundcolorOfResetBUtton();
		String expectedColor = "rgba(255, 193, 7, 1)";
		Assert.assertEquals(actualColor, expectedColor, "bgColor of reset Button Was not as expeceted");

	}

	// @Test
	public void verifyTheTextOfManagreProductsPage() {
		mp = new ManageProductPage(driver);
		sp = new SignInPage(driver);
		sp.SignInCredentials("admin", "admin");
		mp.clickManageProduct();
		String actualText = mp.getTheTextOfManagreProductsPage();
		String expectedText = "List Products";
		Assert.assertEquals(actualText, expectedText, "the text of title is nit as expected");

	}

	// @Test
	public void verifyNonVegRadioButtonIsSelected() {
		mp = new ManageProductPage(driver);
		sp = new SignInPage(driver);
		sp.SignInCredentials("admin", "admin");
		mp.clickManageProduct();
		mp.clickEditButton();
		Boolean actuavalue = mp.checkWhetherNonvegRadioButtonIsSelected();
		Assert.assertTrue(actuavalue, "Radio button is not slected");

	}

	@Test
	public void verifyProductsSearchByTitle() {
		mp = new ManageProductPage(driver);
		sp = new SignInPage(driver);
		sp.SignInCredentials("admin", "admin");
		mp.clickManageProduct();
		mp.selectSearchIcon();
		mp.enterTitleToBeSearched("Red Meat");
		mp.selectSearchButton();
		boolean actualResult = mp.getTheListOfElementsSearchedByTitles("Red Meat");
		Assert.assertFalse(actualResult, "Products listed by searching title was not as expected");

	}
//	@Test
//	public void verifyTheDropDownOfCategoryButton() {
//		mp = new ManageProductPage(driver);
//		mp.enterUserName("admin");
//		mp.enterPassword("admin");
//		mp.ClickSignInButton();
//		mp.clickManageProduct();
//		mp.selectSearchIcon();
//		//String ActualText =mp.selectValueFromCategoryDropDown();
//		String expectedText="Grocery & staples";
//		Assert.assertEquals(ActualText, expectedText,"error in the seleceted dropdown value");
//	}

}
