package automationFramework.Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

public class baseTest {
	
		//Initial test Setup that will be run for every test.
		// Static means you can access without creating an instance of the class
			
		protected WebDriver testSetup(String driverToUse, int timeout){
			try{
			//This is needed to run the latest version of Selenium
			WebDriver driver = null;
			//Set the driver to use
			switch(driverToUse){
				case "FireFox":
					System.setProperty("webdriver.gecko.driver", "/Users/Tom/Google Drive/Programming/Java/TestHarness/TestHarness/geckodriver");
					driver = new FirefoxDriver();
					break;
				case "IE":
					driver = new InternetExplorerDriver();
					break;
				case "Safari":
					driver = new SafariDriver();
					break;
				case "Opera":
					driver = new OperaDriver();
					break;
				case "Chrome":
					System.setProperty("webdriver.chrome.driver", "/Users/Tom/Downloads/chromedriver");
					driver = new ChromeDriver();
					break;
			}
			driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
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
