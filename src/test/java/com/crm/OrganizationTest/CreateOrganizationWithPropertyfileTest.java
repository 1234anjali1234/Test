package com.crm.OrganizationTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CreateOrganizationWithPropertyfileTest {
	
	@Test
	public void createOrgTest() throws Throwable
	{
		//step1: read data  property file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String BROWSER = pobj.getProperty("browser");
		String URL = pobj.getProperty("url");
		String USER = pobj.getProperty("user");
		String PASSWORD = pobj.getProperty("password");
		
		//step2: launch the browser
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get(URL);
		
		//Step 3: login
		
        driver.findElement(By.name("user_name")).sendKeys(USER);
        driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
        driver.findElement(By.id("submitbutton")).click();
		
		//Step 3: navigate to organizations link
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step 4: click on create Organization link
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//Step 5:create org with mandatory fields
		driver.findElement(By.name("accountname")).sendKeys("tinnacle");
		
		//Step 6: Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		
		driver.quit();
		
		
	}
	

}
