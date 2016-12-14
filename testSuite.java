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
		
    }
	
	
	
	
	


