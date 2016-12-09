package automationFramework.Tests;

import org.openqa.selenium.WebDriver;
import automationFramework.TestCommands; 
import automationFramework.baseTestTypes; 


public class URLOpens {
	public static void main(String[] args){
		System.out.println("Entering");
	}
	
	
	
	public Boolean test() {
		
			//************************** Setup *************************
			WebDriver driver = TestCommands.testSetup();
			//************************** Open the URL *************************
			String url = "htsdfsdfsdffacebook3423df.com";
			TestCommands.openURL(driver, url);
			
			//Get  the actual URL
			String actualUrl = driver.getCurrentUrl();
			Boolean testResult = baseTestTypes.checkStringEquals(actualUrl, url);
			
			
			
//			
//			
//			
			
//			//Get Page Source
//			String PageSource = driver.getPageSource();		
//			
//			// Get title
//			String Title = driver.getTitle();
//			System.out.printf("Page Title is %s\n", Title);
//			
//	        // Print a Log In message to the screen
//	        System.out.printf("Successfully opened the website %s", Title);
//	 
			
	        // Close the driver
	        driver.quit();
	        System.out.printf("***TEST RESULT***", testResult);
			return testResult;
	    }

}
