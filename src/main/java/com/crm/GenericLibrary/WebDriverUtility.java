package com.crm.GenericLibrary;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.record.SelectionRecord;
import org.omg.CORBA.Current;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consists of all generic methods related to webdriver Actions
 * @param driver
 */

public class WebDriverUtility {

	/**
	 * This method will maximize the window
	 * @param driver
	 */

	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}

	/**
	 * This method will wait for 20 seconds for the page to load
	 * @param driver
	 */
	public void waitForpageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	/**
	 * This method will wait for 10 seconds for an element to be click able
	 * @param driver
	 * @param element
	 */

	public void waitForElementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This method will wait for 10 seconds for an element to be visible
	 * @param driver
	 * @param element
	 */

	public void waitForElementToBeVisible(WebDriver driver, WebElement element) //method overloading
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method will will select data from drop down using index
	 * @param index
	 * @param element
	 */
	public void select(int index, WebElement element)                         //method overloading --1st select
	{
		Select sel = new Select(element);    
		sel.selectByIndex(index);
	}


	/**
	 * This method will will select data from drop down using visible text
	 * @param element
	 * @param text
	 */
	public void select(WebElement element, String text)                               //method overloading-----2nd select
	{
		Select sel = new Select(element);    
		sel.selectByVisibleText(text);
	}
	/**
	 * This method will will select data from drop down using value
	 * @param value
	 * @param element
	 */


	public void select(String value, WebElement element)                            //method overloading-----3rd select
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}


	/**
	 * This method will  perform mouse Hover action
	 * @param driver
	 * @param element
	 */

	public void mouseHover(WebDriver driver, WebElement element)                               //------->1st action method
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * This method will  perform drag and drop action
	 * @param driver
	 * @param src
	 * @param target
	 */
	public void dragAndDrop(WebDriver driver, WebElement src, WebElement target)               //------->2nd action method
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(src, target).perform();	
	}

	/**
	 * This method will  double click on element
	 * @param driver
	 * @param element
	 */

	public void doubleClickAction(WebDriver driver, WebElement element) //Overloading         //------->3rd action method
	{
		Actions act = new Actions(driver);
		act.doubleClick(element);	
	}
	/**
	 * This method will double click on web page
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver)                                       //------->4th action method
	{
		Actions act = new Actions(driver);
		act.doubleClick().perform();	
	}

	/**
	 * This method will perform right click on element
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver, WebElement element)                      //------->5th action method
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}

	/**
	 * This method will press enter key
	 * @param driver
	 */

	public void enterKeyPress(WebDriver driver)                                          //------->6th action method

	{
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}

	/**
	 * This method will press enter key
	 * @throws Throwable
	 */
	public void enterKey() throws Throwable                   //------->1st Robot method

	{
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
	}

	/**
	 * This method will release enter key
	 * @throws Throwable
	 */
	public void enterRelease() throws Throwable               //------->2nd Robot method

	{
		Robot rb = new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);
	}





	/**
	 * This method will switch the frame based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index) //Overloading           //1st switchToFrame method
	{
		driver.switchTo().frame(index);
	}

	/**
	 * This method will switch the frame based on name Or Id
	 * @param driver
	 * @param nameOrId
	 */

	public void switchToFrame(WebDriver driver, String nameOrId)                //2nd switchToFrame method
	{
		driver.switchTo().frame(nameOrId);
	}

	/**
	 * This method will switch the frame based on address of the element
	 * @param driver
	 * @param address
	 */

	public void switchToFrame(WebDriver driver, WebElement address)            //3rd switchToFrame method
	{
		driver.switchTo().frame(address);
	}




	/**
	 * This method will accept alert pop up
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)              //1st Accept Alert
	{
		driver.switchTo().alert().accept();
	}

	/**
	 * This method will cancel alert pop up 
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)             //2nd Accept Alert
	{
		driver.switchTo().alert().dismiss();
	}

	/**
	 * This method will switch to window depending on partial window title
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWinTitle)
	{
		//Step1 : use getWindowHandles to capture all windows ids
		Set<String> windows = driver.getWindowHandles();

		//Step2 : iterate the Windows
		Iterator<String> it = windows.iterator();

		//Step3 : Check whether there is next window
		while(it.hasNext())
		{
			//Step4 : capture current window id
			String winId = it.next();

			//Step5 : Switch to current window and capture title	
			String currentWinTitle = driver.switchTo().window(winId).getTitle();

			// Step6 : check the current window is expected
			if(currentWinTitle.contains(partialWinTitle))
			{
				break;
			}
		}
	} 

	/**
	 * This method will take screenshot and store it in folder called as Screenshot
	 * @param driver
	 * @param screenShotName
	 * @throws Throwable 
	 */
	public void getScreenShot(WebDriver driver, String screenShotName) throws Throwable
	{
		TakesScreenshot ts = (TakesScreenshot) driver; // ex of explicit typecasting
		File src = ts.getScreenshotAs(OutputType.FILE);       
		File dst = new File(".\\Screenshot\\"+screenShotName+".png");
		Files.copy(src, dst);
	}

	/**
	 * This method perform random scroll
	 * @param driver
	 */
	public void scrollAction(WebDriver driver) //Overloading                 // ----> 1st scrollAction
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
	}

	/**
	 * This method will scroll until the specified element is found
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver, WebElement element)           // -------> 2nd scrollAction

	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
		//js.executescript("argument[0].scrollIntoView()",element);
	}


}
//Total we have written 24 Web driver Actions in this web driver utility class




