package com.crm.ContactTests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.HomePage;

public class ContactsWebTableTest extends BaseClass{

	@Test
	public void contactsWebTableTest() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		hp.ClickOnContactLnk();
		
		//ContactsPage cp = new ContactsPage(driver);   // Business Library
		//cp.clickOnCheckBox();
		
		 List<WebElement> ele = driver.findElements(By.xpath("//table[@class = 'lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']"));
		
		
		
		for(WebElement cbox : ele) 
		{
			cbox.click();
			Thread.sleep(2000);
		}
		
	
  }
}


