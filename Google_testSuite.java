package automationFramework.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import automationFramework.TestCommands;
import automationFramework.baseTestTypes;

public class Google_testSuite extends baseTest{
	public static String url = "https://www.google.co.uk/";
	public static String browser = "FireFox";
	public static int timeout = 100;
	
	public Boolean enterTextIntoSearchBoxTest() {
		//************************** Initialize *************************
		WebDriver driver = testSetup(browser, timeout);

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
		WebDriver driver = testSetup(browser, timeout);

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
		WebDriver driver = testSetup(browser, timeout);

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

	public Boolean signInToGoogleAccountTest() {			
		//************************** Initialize *************************
		WebDriver driver = testSetup(browser, timeout);

		//************************** Open the URL *************************
		driver = TestCommands.openURL(driver, url);
		
		//************************** Test Commands *************************
		//Click SignIn Button
		TestCommands.clickButton(driver, "xpath", "//a[@id='gb_70']");
		TestCommands.enterTextIntoBox(driver, "xpath", "//input[@id='Email']", "thomas.rice@thefoundry.co.uk");
		TestCommands.clickButton(driver, "id", "next"); 
		TestCommands.enterTextIntoBox(driver, "xpath", "//input[@id='Passwd']", "www.Foundry Password 1234.com");
		String returnedURL = TestCommands.clickButton(driver, "id", "signIn"); 
		System.out.print(returnedURL);
		//************************** Evaluation *************************
		String refernceURL = "https://www.google.co.uk/";
		Boolean testResult = baseTestTypes.checkStringAgainstString(returnedURL , refernceURL);

		//************************** Close The Test Down *************************
		tearDown(driver);
		return testResult;
		
    }
	
	
	
	
	
	
	
	
	
	public Boolean clickGmailButtonTest() {			
	//************************** Initialize *************************
	WebDriver driver = testSetup(browser, timeout);
	
	//************************** Open the URL *************************
	driver = TestCommands.openURL(driver, url);
	
	//************************** Test Commands *************************
	String returnedURL = TestCommands.clickButton(driver, "xpath", "//a[contains(text(),'Gmail')]");
	
	//************************** Evaluation *************************
	String refernceURL = "https://www.google.com/gmail/about/";
	Boolean testResult = baseTestTypes.checkStringAgainstString(returnedURL , refernceURL);

	//************************** Close The Test Down *************************
	tearDown(driver);
	return testResult;	
}
	
	
	//This is not an ideal test, testing the title as the new page loads, but the url is dynamic. 
	public Boolean clickImagesButtonTest() {			
	//************************** Initialize *************************
	WebDriver driver = testSetup(browser, timeout);
	
	//************************** Open the URL *************************
	driver = TestCommands.openURL(driver, url);
	
	//************************** Test Commands *************************
	TestCommands.clickButton(driver, "xpath", "//a[contains(text(),'Images')]");
	String Title = TestCommands.getPageTitle(driver);
	//************************** Evaluation *************************
	String reference = "Google Images";
	Boolean testResult = baseTestTypes.checkStringAgainstString(Title , reference);

	//************************** Close The Test Down *************************
	tearDown(driver);
	return testResult;
	
}	
	
	public Boolean checkMainLogoIsPresent(){
		//************************** Initialize *************************
		WebDriver driver = testSetup(browser, timeout);

		//************************** Open the URL *************************
		driver = TestCommands.openURL(driver, url);
		
		//************************** Test Commands *************************
		Boolean returnedBool = TestCommands.checkElementIsDisplayed(driver, "id", "hplogo");
		
		//************************** Evaluation *************************
		Boolean reference = true;
		Boolean testResult = baseTestTypes.checkBooleanResult(returnedBool , reference);
		//************************** Close The Test Down *************************
		tearDown(driver);
		return testResult;
	}
	
	public Boolean checkMainLogoDimension(){
		//************************** Initialize *************************
		WebDriver driver = testSetup(browser, timeout);

		//************************** Open the URL *************************
		driver = TestCommands.openURL(driver, url);
		
		//************************** Test Commands *************************
		String returnedDimensions = TestCommands.getElementDimensions(driver, "id", "hplogo");
		//************************** Evaluation *************************
		//Cast dimensions into a string to compare
		String reference = "(272, 92)";
		Boolean testResult = baseTestTypes.checkStringAgainstString(returnedDimensions , reference);
		//************************** Close The Test Down *************************
		tearDown(driver);
		return testResult;
	}	
	
	
	public Boolean checkMainLogoPosition(){
		//************************** Initialize *************************
		WebDriver driver = testSetup(browser, timeout);

		//************************** Open the URL *************************
		driver = TestCommands.openURL(driver, url);
		
		//************************** Test Commands *************************
		String returnedDimensions = TestCommands.getElementPositionOnPage(driver, "id", "hplogo");
		//************************** Evaluation *************************
		//Cast dimensions into a string to compare
		String reference = "(404, 198)";
		Boolean testResult = baseTestTypes.checkStringAgainstString(returnedDimensions , reference);
		//************************** Close The Test Down *************************
		tearDown(driver);
		return testResult;
	}
	

	
	
	
	
	
	
}
	
	
	
	
	


