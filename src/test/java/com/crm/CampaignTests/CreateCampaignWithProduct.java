package com.crm.CampaignTests;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
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
import org.testng.annotations.Test;

public class CreateCampaignWithProduct {


    @Test
    public void createContactWithOrgTest() throws Throwable
{
	/*generate random number*/
	Random ran = new Random();
	int random = ran.nextInt(500);
	
	/*Step 1: read all necessary data*/
	//read data from property file ----->we call it as common data
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
	Properties pObj = new Properties();
	pObj.load(fis);
	String BROWSER = pObj.getProperty("browser");
	String URL = pObj.getProperty("url");
	String USERNAME = pObj.getProperty("user");
	String PASSWORD = pObj.getProperty("password");
	
	//read data from excel sheet--------we call it as test
	FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\Test_data.xlsx");
	Workbook wb = WorkbookFactory.create(fi);
	Sheet sh = wb.getSheet("Campaign");
	Row ro = sh.getRow(1);
	Cell cel = ro.getCell(2);
	String CamName = cel.getStringCellValue();
	String CamNameRan= CamName+" "+random;
	
	Cell ce = ro.getCell(3);
	String productname = ce.getStringCellValue()+" "+random;
	
	
	/*Step 2: launch the browser*/
	WebDriver driver=null;
	if(BROWSER.equalsIgnoreCase("chrome"))
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
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get(URL);
	
	/*Step 3: login to application*/
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	
	/*Step 4: Navigate to product Link*/
	driver.findElement(By.linkText("Products")).click();
	
	/*Step 5: click on create Product btn*/
	driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
	
	/*Step 6: enter mandatory fields and save*/
	driver.findElement(By.name("productname")).sendKeys(productname);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	
	/*Step 6: verification*/
	
	String header = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
	if(header.contains(CamNameRan))
	{
		System.out.println(header);
		System.out.println("product created");
	}
	else
	{
		System.out.println(header);
		System.out.println("product not created");
	}
	
	/*Step 7: click on more*/
	driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']")).click();
	driver.findElement(By.name("Campaigns")).click();
	//WebElement ele2 = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
		//Actions act = new Actions(driver);
		//act.moveToElement(ele2).perform();
	
	/*Step 8: create new campaign*/
	driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
	driver.findElement(By.name("campaignname")).sendKeys(CamNameRan);
	
	driver.findElement(By.xpath("//img[@alt='Select']")).click();
	
	/*Step 9: window handle*/
	 Set<String> win = driver.getWindowHandles();
	for(String winId : win)
	{
		driver.switchTo().window(winId);
	}
	
	
	driver.findElement(By.name("search_text")).sendKeys(productname);
	driver.findElement(By.name("search")).click();
	driver.findElement(By.xpath("//a[text()='"+productname+"']")).click();
	
	Set<String> win1 = driver.getWindowHandles();
	for(String wi : win1)
	{
		driver.switchTo().window(wi);
	}
	
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	Thread.sleep(2000);
	
	
	/*Step 10: verify */
	String header1 = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(header1.contains(CamNameRan))
	{
		System.out.println(header1 + "campaingn created");
	}
	else
	{
		System.out.println("campaing not created");
	}
	
	/*Step 11: logout and close the browser*/
	WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	Actions act1 = new Actions(driver);
	act1.moveToElement(element).perform();
	
	driver.findElement(By.linkText("Sign Out")).click();
	//driver.quit();
}
}


