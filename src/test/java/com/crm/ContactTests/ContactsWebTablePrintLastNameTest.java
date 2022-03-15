package com.crm.ContactTests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.HomePage;

public class ContactsWebTablePrintLastNameTest extends BaseClass{

	@Test
	public void contactWebTableLastChkBoxTest() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		hp.ClickOnContactLnk();

		//ContactsPage cp = new ContactsPage(driver);   // Business Library
		//cp.clickOnCheckBox();

		List<WebElement> ele = driver.findElements(By.xpath("//table[@class = 'lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']"));
		ArrayList<WebElement> arrele = new ArrayList<WebElement>(ele);
		int size = arrele.size()-1;
		arrele.get(size).click();
    }
	
	@Test
	public  void lastName() throws InterruptedException
	{
		
	HomePage hp = new HomePage(driver);
	hp.ClickOnContactLnk();

	List<WebElement> ele = driver.findElements(By.xpath("//table[@class = 'lvt small']/tbody/tr[*]/td[4]"));
	for(WebElement value : ele) 
	{
		String text = value.getText();
		System.out.println(text);
		Thread.sleep(2000);
	}


 }
}









