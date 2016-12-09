package automationFramework.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class baseTest {
	
		//Initial test Setup that will be run for every test.
		// Static means you can access without creating an instance of the class
			
		protected WebDriver testSetup(){
			try{
			//This is needed to run the latest version of Selenium
			System.setProperty("webdriver.gecko.driver", "/Users/Tom/Google Drive/Programming/Java/TestHarness/TestHarness/geckodriver");
			// Create a new instance of the Firefox driver
			WebDriver driver = new FirefoxDriver();
			return driver;
			}
			catch(Exception e){
				System.out.print("@@@Fail@@@ \n");
				System.out.print("Failed to acquire webdriver");
				System.out.print(e);
				System.exit(1);
				return null;
			}
			
		}
		
		
		// All operation needed to close down the test
		protected void tearDown(WebDriver driver){
	        // Close the driver
	        driver.quit();
		}

}
