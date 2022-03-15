package com.crm.ContactTests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.HomePage;

public class ContactsWebTableChkBoxAndDeleteTest extends BaseClass{
	
	@Test
	public void contactsWebTableChkBoxAndDelete() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		hp.ClickOnContactLnk();

		//driver.findElements(By.xpath("//table[@class = 'lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']"));
		driver.findElement(By.xpath("(//input)[@type='checkbox'][7]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//table[@class = 'lvt small']/tbody/tr[7]/td[10]/a[.='del']")).click();
		Thread.sleep(2000);
		
		System.out.println("deleted the contact");
		WebDriverUtility wLib = new WebDriverUtility();
		wLib.acceptAlert(driver);
		
    }

}
