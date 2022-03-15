package com.crm.OpportunityTests;

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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateOpportunitytc_12withValuePropositionTest {
	
@Test
	


public void createOpportunitywithSalesStageValueProposition() throws Throwable

{
	Random ran = new Random();
	int random = ran.nextInt(100);
	
	/*Step 1: read all necessary data*/
	
	//read data from property file
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
	Properties pObj = new Properties();           
	pObj.load(fis);
	String BROWSER  = pObj.getProperty("browser");
	String USER     = pObj.getProperty("user");
	String URL      = pObj.getProperty("url");
	String PASSWORD = pObj.getProperty("password");
	
     /* read data from excel file*/
	FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\Test_data.xlsx");
	Workbook wb = WorkbookFactory.create(fi);
	Sheet sh = wb.getSheet("Campaign");
	Row ro = sh.getRow(1);
	Cell cel = ro.getCell(2);
	String Opportunity = cel.getStringCellValue();
	String OpportunityRan = Opportunity+" "+random;
	
	 Cell ce = ro.getCell(3);
	 String Organization = ce.getStringCellValue();
	 
	
	/*Step 2: Launch the browser*/
	 
	WebDriver driver = null;
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		driver = new ChromeDriver();
	}
	
	else if (BROWSER.equalsIgnoreCase("firefox"))
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
	driver.findElement(By.name("user_name")).sendKeys(USER);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	
	/*Step 4: Navigate to Opportunity Link*/
	driver.findElement(By.xpath("//a[@href='index.php?module=Potentials&action=index']")).click();
	
	/*Step 5: click on create Opportunity btn i.e. + symbol */
	driver.findElement(By.xpath("//img[@title='Create Opportunity...']")).click();
	
	/*Step 6: enter mandatory fields and save*/
	driver.findElement(By.name("potentialname")).sendKeys(OpportunityRan);
	
    driver.findElement(By.xpath("//img[@alt='Select']")).click();
	
	/*Step 7: window handle*/
	 Set<String> win = driver.getWindowHandles();
	for(String winId : win)
	{
		driver.switchTo().window(winId);
	}
	
	
	driver.findElement(By.name("search_text")).sendKeys(Organization);
	driver.findElement(By.name("search")).click();
	WebElement ass = driver.findElement(By.name("search_field"));
	Select selec = new Select(ass);
	selec.selectByIndex(4);
	driver.findElement(By.xpath("//a[@id='13']")).click();
	
	/*Step 8: again window handle*/
	Set<String> win1 = driver.getWindowHandles();
	for(String wi : win1)
	{
		driver.switchTo().window(wi);
	}
	
	driver.findElement(By.xpath("//input[@value='T']")).click();
	WebElement gp = driver.findElement(By.xpath("//select[@name='assigned_group_id']"));
	Select sele = new Select(gp);
	sele.selectByIndex(3);
	
	/*Date*/
	driver.findElement(By.xpath("//img[@id='jscal_trigger_closingdate']")).click();
	
	 
	/*Step 8: Save it*/
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	Thread.sleep(2000);
	
	/*Step 9: Verification*/
	String header = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	{
		if(header.contains(OpportunityRan))
		{
			System.out.println(header);
			System.out.println("Opportunity created");
		}
		else
		{
			System.out.println(header);
			System.out.println("Opportunity not created");
		}
	}
	
	
	Thread.sleep(2000);
	//driver.close();
}	

}

	
		