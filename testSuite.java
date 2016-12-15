package automationFramework.Tests;

import org.openqa.selenium.WebDriver;

import automationFramework.TestCommands;
import automationFramework.baseTestTypes;

public class testSuite extends baseTest{
	
	
	public Boolean enterTextIntoSearchBoxTest() {
		//************************** Initialize *************************
		WebDriver driver = testSetup();

		//************************** Open the URL *************************
		String url = "https://www.google.co.uk/";
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
		WebDriver driver = testSetup();

		//************************** Open the URL *************************
		String url = "https://www.google.co.uk/";
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
		WebDriver driver = testSetup();

		//************************** Open the URL *************************
		String url = "https://www.google.co.uk/";
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
		
		WebDriver driver = testSetup();

		//************************** Open the URL *************************
		String url = "http://blog.arcbees.com/2016/05/10/build-your-own-test-framework/";
		TestCommands.openURL(driver, url);
		Boolean testResult = false;
		tearDown(driver);
		return testResult;
	
    }
	
	
	
	
	
	
}
	
	
	
	
	


