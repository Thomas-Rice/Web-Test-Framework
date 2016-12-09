package automationFramework.Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import automationFramework.TestCommands; 
import automationFramework.baseTestTypes; 



public class checkURLOpens extends baseTest{

	
	
	public Boolean test() throws IOException {
		
			WebDriver driver = testSetup();

			//************************** Open the URL *************************
			String url = "http://blog.arcbees.com/2016/05/10/build-your-own-test-framework/";
			TestCommands.openURL(driver, url);
			
			//Get  the actual URL
//			String actualUrl = driver.getCurrentUrl();
			String PageSource = driver.getPageSource();
			String referencePath = "/Users/Tom/Desktop/test1.txt";
			Boolean testResult = baseTestTypes.checkSourceAgainstReference(PageSource, referencePath);
			
			
			tearDown(driver);
			
			return testResult;
	    }

}
