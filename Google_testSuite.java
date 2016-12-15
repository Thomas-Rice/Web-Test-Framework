package automationFramework.Tests;

import org.openqa.selenium.WebDriver;

import automationFramework.TestCommands;
import automationFramework.baseTestTypes;

public class Google_testSuite extends baseTest{
	public static String url = "https://www.google.co.uk/";
	public static String browser = "FireFox";
	
	public Boolean enterTextIntoSearchBoxTest() {
		//************************** Initialize *************************
		WebDriver driver = testSetup(browser);

		//************************** Open the URL *************************
		driver = TestCommands.openURL(driver, url);
		
		//************************** Test Commands *************************
		TestCommands.enterTextIntoBox(driver, "id", "lst-ib", "Hello");
		String returnedURL = TestCommands.clickButton(driver, "id", "_fZl");
		
		//************************** Evaluation *************************
		String referenceURL = "https://www.google.co.uk/#q=Hello";
		Boolean testResult = baseTestTypes.checkStringAgainstString(returnedURL , referenceURL);

		//************************** Close The Test Down *************************
		tearDown(driver);
		return testResult;
		}
		
	
	public Boolean checkURLTitleTest() {			
		//************************** Initialize *************************
		WebDriver driver = testSetup(browser);

		//************************** Open the URL *************************
		driver = TestCommands.openURL(driver, url);
		
		//************************** Test Commands *************************
		String Title = TestCommands.getPageTitle(driver);
		
		//************************** Evaluation *************************
		Boolean testResult = baseTestTypes.checkStringAgainstString(Title , "Google");
		
		//************************** Close The Test Down *************************
		tearDown(driver);
		return testResult;
		
		
    }
	
	
	public Boolean clickLoginButtonTest() {			
		//************************** Initialize *************************
		WebDriver driver = testSetup(browser);

		//************************** Open the URL *************************
		driver = TestCommands.openURL(driver, url);
		
		//************************** Test Commands *************************
		String returnedURL = TestCommands.clickButton(driver, "xpath", "//a[@id='gb_70']");
		
		//************************** Evaluation *************************
		String refernceURL = "https://accounts.google.com/ServiceLogin?hl=en&passive=true&continue=https://www.google.co.uk/#identifier";
		Boolean testResult = baseTestTypes.checkStringAgainstString(returnedURL , refernceURL);

		//************************** Close The Test Down *************************
		tearDown(driver);
		return testResult;
		
    }
	
	public Boolean checkURLOpensTest() {
		
		WebDriver driver = testSetup(browser);

		//************************** Open the URL *************************
		TestCommands.openURL(driver, url);
		Boolean testResult = false;
		tearDown(driver);
		return testResult;
	
    }
	
//	public Boolean checkMainLogoIsPresent(){
//		
//	}
	
	
	
	
}
	
	
	
	
	


