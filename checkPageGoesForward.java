package automationFramework.Tests;

import org.openqa.selenium.WebDriver;
import automationFramework.TestCommands; 
import automationFramework.baseTestTypes; 



public class checkPageGoesForward extends baseTest{

	
	
	public void test() {
		
			WebDriver driver = testSetup();

			//************************** Open the URL *************************
			String url = "http://blog.arcbees.com/2016/05/10/build-your-own-test-framework/";
			TestCommands.openURL(driver, url);
			
			String forwardURL = TestCommands.navigateForward(driver);			
			baseTestTypes.checkStringAgainstString(url, forwardURL);
			


			
			
			tearDown(driver);
			
		
	    }

}
