package TestCases;

import java.io.FileInputStream;

import java.io.IOException;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.ScreenShotUtility;

public class BaseClass {
	WebDriver driver;
	public static Properties prop;
	ScreenShotUtility scr;

	public static void testBasic() throws IOException {
		prop = new Properties();
		FileInputStream obj = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\properties\\config.properties");
		prop.load(obj);
	}// this three line code can be used to call a data from this properties file.if
		// u havent created that function u need to copy this three lines everywhere..

	@BeforeMethod(alwaysRun=true)
	@Parameters("browser")
	public void beforeMethod(String browserValue) throws IOException {
		testBasic();
		
		if(browserValue.equals(prop.getProperty("Browser1"))) {
			ChromeOptions co=new ChromeOptions();
			co.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(co);
		}
		else if(browserValue.equals(prop.getProperty("Browser2"))) {
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		driver.manage().window().maximize();
		driver.get(prop.getProperty("BaseURL"));  
	}
//	@BeforeMethod(alwaysRun=true)
//	
//	public void beforeMethod() throws IOException {
//		testBasic();
//		
//		 driver =new EdgeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
//		driver.get(prop.getProperty("BaseURL"));
//	}

	@AfterMethod
	public void afterMethod(ITestResult iTestResult) throws IOException {

		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			scr = new ScreenShotUtility();
			scr.captureFailureScreenShot(driver, iTestResult.getName());
		}
		driver.close();
	}

}
