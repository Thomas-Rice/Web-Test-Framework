package automationFramework;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCommands {

	private static void errorOutput(WebDriver driver, String failMessage){
		System.out.print("@@@Fail@@@ \n");
		System.out.printf(failMessage);
		driver.quit();
		System.out.printf("*** Test Was Automatically Terminmated ***\n");
		System.exit(1);
	}
	
	
	
	
	
	private static WebElement findElementBy(WebDriver driver, String identifier, String text){
		WebElement element = null;
		try{
			switch(identifier){
				case "id":
					element = driver.findElement(By.id(text));
					break;
				case "name":
					element = driver.findElement(By.name(text));
					break;	
				case "tagName":
					element = driver.findElement(By.tagName(text));
					break;	
				case "link":
					element = driver.findElement(By.linkText(text));
					break;	
				case "partialLink":
					element = driver.findElement(By.partialLinkText(text));
					break;
				case "xpath":
					element = driver.findElement(By.xpath(text));
					break;
					} 
		}
		catch(NoSuchElementException e){
			errorOutput(driver, "*** Failed to get Element ***\n");
			}
		
		return element;
	}
		
	
	
	
	private static List<WebElement> findElementsBy(WebDriver driver, String identifier, String text){
		List<WebElement> element = null;
		try{
			switch(identifier){
				case "id":
					element = driver.findElements(By.id(text));
					break;
				case "name":
					element = driver.findElements(By.name(text));
					break;	
				case "tagName":
					element = driver.findElements(By.tagName(text));
					break;	
				case "link":
					element = driver.findElements(By.linkText(text));
					break;	
				case "partialLink":
					element = driver.findElements(By.partialLinkText(text));
					break;
				case "xpath":
					element = driver.findElements(By.xpath(text));
					break;
					} 
		}
		catch(NoSuchElementException e){
			errorOutput(driver, "*** Failed to get Element ***\n");
			}
		
		return element;
	}	
	
	
	
	
	public static WebDriver openURL(WebDriver driver, String url){
		try{
			//Launch the Online Store Website
			driver.get(url);
			return driver;
		}
		catch(Exception e){
			System.out.print(e);
			errorOutput(driver, "*** Failed to get URL ***\n");
			return null;
		}

	}
	
	
	
	
	public static String navigateForward( WebDriver driver){
		String forwardURL = "";
		try{
			driver.navigate().forward();
			forwardURL = driver.getCurrentUrl();
			
		}
		catch (Exception e){
			errorOutput(driver,"*** Failed to navigate forward ***\n");
		}
		return forwardURL;
		
	}

	
	
	
	public static String getPageTitle(WebDriver driver){
		String Title = " ";
		try{
			Title = driver.getTitle();
		}
		catch(Exception e){
			errorOutput(driver, "*** Failed to get page title ***\n");
			
		}
		return Title;
	}
	
	
	
	public static void enterTextIntoBox(WebDriver driver, String findBy, String locator, String text){
		try{
			WebElement element = findElementBy(driver, findBy, locator);
			element.sendKeys(text);
		}
		catch(Exception e){
			errorOutput(driver,"*** Failed to get send keys via element***\n");
		}
	}
	
	
	public static String clickButton(WebDriver driver, String findBy, String locator){
		String returnedURL = null;
		try{
			WebElement element = findElementBy(driver, findBy, locator);
			element.click();
			returnedURL = getCurrentURL(driver);
		}
		catch(Exception e){
			errorOutput(driver,"*** Failed to click button via element***\n");
		}
		return returnedURL;
	}
	
	
	public static String getCurrentURL(WebDriver driver){
		String currentURL = null;
		try{
			//The Wait is needed to load the new page
			Thread.sleep(500);
			currentURL = driver.getCurrentUrl();
		}
		catch(Exception e){
			errorOutput(driver,"*** Failed to get page URL***\n");
		}
		return currentURL;
	}
	
	
	
	
}
