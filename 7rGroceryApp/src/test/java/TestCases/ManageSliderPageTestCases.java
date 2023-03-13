package TestCases;
import java.awt.AWTException;

import javax.sound.sampled.spi.AudioFileReader;

import org.testng.Assert;
import org.testng.annotations.Test;
import ElementRepository.ManageSliderPage;
import ElementRepository.SignInPage;
import constant.Constant;
import utilities.ExcelRead;

public class ManageSliderPageTestCases extends BaseClass {
	 
	  SignInPage sp;
	  ManageSliderPage msp;
	  ExcelRead eRead;
  @Test
  public void verifyTheSavedDataIsPresent() throws AWTException {
	  msp = new ManageSliderPage(driver);
		sp = new SignInPage(driver);
		sp.SignInCredentials(prop.getProperty("Username"), prop.getProperty("Password"));
		msp.selectManageSlider();
		msp.selectNewButtonElement();
		msp.savingNewData();
		boolean actualResult=msp.checkingTheAddedElementIspresent();
		Assert.assertTrue(actualResult,Constant.ERRORMESSAGE_MANAGAESLIDERSPAGE_SAVEDDATA);
	  
  }
  @Test
  public void verifyTheBackGroundColorOfSaveButton() {
	  sp = new SignInPage(driver);
	  msp = new ManageSliderPage(driver);
		String actualResult = msp.getThebackgroundColorOfSaveButton();
		String expectedResult =eRead.readFromExcelFile(7, 1) ;
		Assert.assertEquals(actualResult, expectedResult, Constant.ERRORMESSAGE_BACKGROUNDCOLOR);

  }
}
