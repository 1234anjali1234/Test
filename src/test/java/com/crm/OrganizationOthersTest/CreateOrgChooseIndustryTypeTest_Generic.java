package com.crm.OrganizationOthersTest;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;

public class CreateOrgChooseIndustryTypeTest_Generic {


	@Test

	public void createOrgTest() throws Throwable
	{
		PropertyFileUtility pLib = new PropertyFileUtility();
		JavaUtility jLib = new JavaUtility();
		ExcelFileUtility eLib = new ExcelFileUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		/*Step 1: read all necessary data*/

		//read data from property file
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String URL = pLib.readDataFromPropertyFile("url");
		String USERNAME = pLib.readDataFromPropertyFile("user");
		String PASSWORD = pLib.readDataFromPropertyFile("password");

		//read data from excel file
		String OrgName = eLib.readDataFromExcel("Org", 4, 2)+"_"+jLib.getRandomNumber();
		String indType = eLib.readDataFromExcel("Org", 4, 2);

		/*Step 2: launch the browser*/
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome")) //use Ignore case to avoid error w.r.t. upper and lower case
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else		

		{
			System.out.println("invalid browser");
		}

		wLib.maximizeWindow(driver);
		wLib.waitForpageLoad(driver);
		driver.get(URL);

		/*Step 3: login to application*/
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		/*Step 4: Navigate to Organizations Link*/
		driver.findElement(By.linkText("Organizations")).click();

		/*Step 5: click on create organization button*/
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

		/*Step 6: enter mandatory fields and save*/
		driver.findElement(By.name("accountname")).sendKeys(OrgName);


		/*Step 7: Click on industry type from drop down*/
		WebElement ele = driver.findElement(By.xpath("//select[@name='industry']"));
		wLib.select(indType, ele);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']"));



		/*Step 10: logout of application*/
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		//wLib.mouseHover(driver, element);
		//driver.findElement(By.xpath("//a[.='Sign Out']")).click();

		/*Step 11: close the browser*/
		//driver.quit();
	}
}





