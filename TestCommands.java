package automationFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestCommands {

	
	
	//Initial test Setup that will be run for every test.
	// Static means you can access without creating an instance of the class
	
	public static WebDriver testSetup(){
		try{
		//This is needed to run the latest version of Selenium
		System.setProperty("webdriver.gecko.driver", "/Users/Tom/Documents/workspace/TestHarness/geckodriver");
		// Create a new instance of the Firefox driver
		WebDriver driver = new FirefoxDriver();
		
		return driver;
		}
		catch(Exception e){
			System.out.print("Failed to acquire webdriver");
			System.out.print(e);
			System.exit(1);
			return null;
		}
		
	}
	
	public static void openURL(WebDriver driver, String url){
		try{
			//Launch the Online Store Website
			driver.get(url);
		}
		catch(Exception e){
			System.out.printf("*** Failed to get URL ***\n");
			System.out.printf("Caught Exception: %s \n", e);
			System.exit(1);
		}
	}
	


	
}
