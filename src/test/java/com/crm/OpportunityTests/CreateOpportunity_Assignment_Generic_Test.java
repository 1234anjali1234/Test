package com.crm.OpportunityTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOpportunity_Assignment_Generic_Test 

{
	@Test
	public void createOpportunity_Assignment_Generic() throws Throwable
	{
		//WebDriverManager.chromedriver().setup();
		//WebDriverManager.firefoxdriver().setup();

		/*read data*/
		PropertyFileUtility pLib = new PropertyFileUtility();
		JavaUtility jLib = new JavaUtility();
		ExcelFileUtility eLib = new ExcelFileUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		/*Step 1: read all necessary data*/
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String URL = pLib.readDataFromPropertyFile("url");
		String USERNAME = pLib.readDataFromPropertyFile("user");
		String PASSWORD = pLib.readDataFromPropertyFile("password");

		String OppName    = eLib.readDataFromExcel("Sheet1", 3, 2)+"_"+jLib.getRandomNumber();
		String RelatedTo  = eLib.readDataFromExcel("Sheet1", 3, 3);
		String leadSource = eLib.readDataFromExcel("Sheet1", 3, 4)+"_"+jLib.getRandomNumber();
		String LastName   = eLib.readDataFromExcel("Sheet1", 3, 5)+"_"+jLib.getRandomNumber();
		String CampName   = eLib.readDataFromExcel("Sheet1", 3, 6)+"_"+jLib.getRandomNumber();
		

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
			System.out.println("invalid browser name");
		}

		wLib.maximizeWindow(driver);
		wLib.waitForpageLoad(driver);
		driver.get(URL);

		//Login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		//Navigate to contacts and create contact

		driver.findElement(By.linkText("Contacts")).click();

		// click on create Contacts button*/
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();


		// enter mandatory fields(last_name) and save*/
		driver.findElement(By.name("lastname")).sendKeys(LastName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);

		
	/*Step 9: Verification for Contacts*/
		String header = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		{
			if(header.contains(LastName))
			{
				System.out.println(header);
				System.out.println("Contacts created");
			}
			else
			{
				System.out.println(header);
				System.out.println("Contacts not created");
			}
		}
		
      // Navigate to menu and select campaign
		driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']")).click();
		driver.findElement(By.name("Campaigns")).click();

		/* create new campaign*/
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		driver.findElement(By.name("campaignname")).sendKeys(CampName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//driver.findElement(By.xpath("//img[@alt='Select']")).click();

		/* Verification for Campaign*/
		String header1 = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		{
			if(header1.contains(CampName))
			{
				System.out.println(header1);
				System.out.println("Campaign created");
			}
			else
			{
				System.out.println(header);
				System.out.println("Campaign not created");
			}
		}
		
		// Navigate to Opportunity Link*/
		driver.findElement(By.xpath("//a[@href='index.php?module=Potentials&action=index']")).click();

		//click on create Opportunity btn i.e. + symbol */
		driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();

		// enter mandatory fields and save*/
		driver.findElement(By.name("potentialname")).sendKeys(OppName);

		//Select contacts from  Related to drop down
		WebElement element = driver.findElement(By.xpath("//select[@name='related_to_type']"));
		wLib.select(RelatedTo, element);


		//Click on + sign in Related to drop down
		driver.findElement(By.xpath("//img[@alt='Select']")).click();

		// window handle*/
		wLib.switchToWindow(driver, "Accounts");// child window

		//workspace of child window
		driver.findElement(By.name("search_text")).sendKeys(LastName);
		driver.findElement(By.name("search")).click();
		//WebElement phone = driver.findElement(By.xpath("//select[name@='search_field']"));
		//wLib.select(OppName, phone);

		// again window handle*/
		wLib.switchToWindow(driver, "Potentials");// parent window

		//Navigate to Lead source drop down and select Employee
		WebElement sel = driver.findElement(By.xpath("//select[@name='leadsource']"));
		wLib.select(leadSource, sel);


		//Click + sign in Campaign source
		driver.findElement(By.xpath("//input[@name='campaignname']/following-sibling::img[@title='Select']")).click();
		                                            
		// window handle*/
		wLib.switchToWindow(driver, "Campaigns");// child window

		////workspace of child window
		driver.findElement(By.name("search_text")).sendKeys(CampName);
		driver.findElement(By.name("search")).click();
		WebElement camp = driver.findElement(By.xpath("//select[name@='search_field']"));
		wLib.select(CampName, camp);

		// window handle*/
		wLib.switchToWindow(driver, "Potentials");// parent window

		/*Step 8: Save it*/
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);

		/*Step 9: Verification*/
		String header2 = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		{
			if(header2.contains(OppName))
			{
				System.out.println(header2);
				System.out.println("Opportunity created");
			}
			else
			{
				System.out.println(header2);
				System.out.println("Opportunity not created");
			}
		}


		Thread.sleep(2000);
		driver.close();
	}	

}










