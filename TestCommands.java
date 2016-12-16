package automationFramework;


import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCommands {

	private static void errorOutput(WebDriver driver, String failMessage, Exception e){
		System.out.print(e);
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
			errorOutput(driver, "*** Failed to get Element ***\n", e);
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
			errorOutput(driver, "*** Failed to get Element ***\n", e);
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
			errorOutput(driver, "*** Failed to get URL ***\n", e);
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
			errorOutput(driver,"*** Failed to navigate forward ***\n", e);
		}
		return forwardURL;
		
	}

	
	
	
	public static String getPageTitle(WebDriver driver){
		String Title = " ";
		try{
			Title = driver.getTitle();
		}
		catch(Exception e){
			errorOutput(driver, "*** Failed to get page title ***\n", e);
			
		}
		return Title;
	}
	
	
	
	public static void enterTextIntoBox(WebDriver driver, String findBy, String locator, String text){
		try{
			WebElement element = findElementBy(driver, findBy, locator);
			element.sendKeys(text);
			Thread.sleep(500);
		}
		catch(Exception e){
			errorOutput(driver,"*** Failed to get send keys via element***\n", e);
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
			errorOutput(driver,"*** Failed to click button via element***\n", e);
		}
		return returnedURL;
	}

	public static Boolean checkElementIsDisplayed(WebDriver driver, String findBy, String locator){
		Boolean status = null;
		try{
			WebElement element = findElementBy(driver, findBy, locator);
			status = element.isDisplayed();
		}
		catch(Exception e){
			errorOutput(driver,"*** The Element Is Not Displayed On The Page***\n", e);
		}
		return status;
	}
	
	public static String getCurrentURL(WebDriver driver){
		String currentURL = null;
		try{
			//The Wait is needed to load the new page
			Thread.sleep(1000);
			currentURL = driver.getCurrentUrl();
		}
		catch(Exception e){
			errorOutput(driver,"*** Failed to get page URL***\n", e);
		}
		return currentURL;
	}
	
	public static String getElementDimensions(WebDriver driver, String findBy, String locator){
		Dimension dimensions = null;
		String finalDimensions = null;
		try{
			WebElement element = findElementBy(driver, findBy, locator);
			dimensions = element.getSize();
			finalDimensions = "("+ dimensions.width + ", " + dimensions.height + ")"; 
		}
		catch(Exception e){
			errorOutput(driver,"*** Failed to get element dimensions***\n", e);
		}
		return finalDimensions;
	}
	
	public static String getElementPositionOnPage(WebDriver driver, String findBy, String locator){
		Point point = null;
		String finalPosition = null;
		try{
			WebElement element = findElementBy(driver, findBy, locator);
			point = element.getLocation();
			finalPosition = "("+ point.x + ", " + point.y + ")"; 
		}
		catch(Exception e){
			errorOutput(driver,"*** Failed to get element position on page***\n", e);
		}
		return finalPosition;
	}	
	
	
	

	
	
	
	
}
