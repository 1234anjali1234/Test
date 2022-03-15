package com.crm.Practice;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SelectAnyDateFromCalendarTest {
	
	@Test(enabled=false)
	 public void Calendar()
	 {
		String date="14";
		String monthAndYear = "December 2022";
	    WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		
		Actions actions =  new Actions(driver);
		actions.moveByOffset(10, 10).click().perform();
		
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		String ForwordArrowXpath ="//span[@aria-label='Next Month']";               // forward Arrow
	    //String BackwardArrowXpath ="//span[@aria-label='Previous Month']";          //backward Arrow
		String dateXpath = "//div[.='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='"+date+"']";
		
		
		for(;;)
		{
			try {
				  driver.findElement(By.xpath(dateXpath)).click();
				  break;
			    } 
			
			catch (Exception e) 
			{
				driver.findElement(By.xpath(ForwordArrowXpath)).click();
			}
			//driver.findElement(By.xpath(BackwardArrowXpath)).click();
		}
		
	 }
	 

	@Test
	public void GoibiboCalendar()
	 {
	
		String monthAndYear = "Sat May 14 2022";
	    WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.goibibo.com/");
		
		Actions actions =  new Actions(driver);
		actions.moveByOffset(10, 10).click().perform();
		
		driver.findElement(By.xpath("//span[@class='sc-kfPuZi dprjVP fswDownArrow']")).click();
		String ForwordArrowXpath ="//span[@aria-label='Next Month']";               // forward Arrow
	    //String BackwardArrowXpath ="//span[@aria-label='Previous Month']";          //backward Arrow
		//String dateXpath = "//div[.='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='"+date+"']";
		String DateXpath = "//div[@aria-label='"+monthAndYear+"']";
		//driver.findElement(By.xpath(DateXpath)).click();
		
		
		
		for(;;)
		{
			try {
				  driver.findElement(By.xpath(DateXpath)).click();
				  driver.findElement(By.xpath("//span[@class='fswTrvl__done']")).click();
				  break;
			    } 
			
			catch (Exception e) 
			{
				driver.findElement(By.xpath(ForwordArrowXpath)).click();
			}
			
		}
		
	 }
	
	 
}
	
	
	
	
	
	
	
	
	
	
	

