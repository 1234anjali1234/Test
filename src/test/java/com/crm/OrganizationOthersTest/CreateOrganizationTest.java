package com.crm.OrganizationOthersTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CreateOrganizationTest {
	
	@Test
	
	public void createOrganizationTest() throws InterruptedException
	{
		//step1: launch the browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://localhost:8888");
		
		//step 2: Login to application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//step3: navigate to organization link
		driver.findElement(By.linkText("Organizations")).click();
		
		//step4: click on create Organization link
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//step5 : create org with mandatory fields
		driver.findElement(By.name("accountname")).sendKeys("oitthium");
		
		//step6 : Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(2000);
		
		
		driver.quit();
	}
	
	

}
