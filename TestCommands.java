package automationFramework;

import org.openqa.selenium.WebDriver;

public class TestCommands {

	
	public static void openURL(WebDriver driver, String url){
		try{
			//Launch the Online Store Website
			driver.get(url);
		}
		catch(Exception e){
			System.out.print("@@@Fail@@@ \n");
			System.out.printf("*** Failed to get URL ***\n");
			// This can be saved to a file later for a more detailed test breakdown
//			System.out.printf("Caught Exception: %s \n", e);
			driver.quit();
			System.out.printf("*** Test Was Automatically Terminmated ***\n");
			System.exit(1);
		}
	}
	
	public static String navigateForward( WebDriver driver){
		try{
			driver.navigate().forward();
			String forwardURL = driver.getCurrentUrl();
			return forwardURL;
		}
		finally{
			System.out.print("@@@Fail@@@ \n");
			System.out.printf("*** Failed to navigate forward ***\n");
			driver.quit();
			System.out.printf("*** Test Was Automatically Terminmated ***\n");
			System.exit(1);
		}
		
		
	}


	
}
