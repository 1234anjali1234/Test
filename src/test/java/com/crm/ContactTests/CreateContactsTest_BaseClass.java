package com.crm.ContactTests;


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
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.ContactInfoPage;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;



	public class CreateContactsTest_BaseClass extends BaseClass {
		
	@Test(retryAnalyzer = com.crm.GenericLibrary.RetryAnalyserImplementation.class)
	
	public void createContactTest() throws Throwable
	{
		String lastName = eLib.readDataFromExcel("Contacts", 1, 2);
		


		/*Step 4: Navigate to Contacts Link*/
		HomePage hp = new HomePage(driver);
		hp.ClickOnContactLnk();
		Assert.fail();
		 
		 
		/*Step 5: click on create Contacts button*/
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOncreateContactImg();
		
		
	    /*Step 6: enter mandatory fields(last_name) and save*/
		 CreateContactPage ccp = new CreateContactPage(driver);
		 ccp.createNewContact(lastName);
		
		 
		 /*Step 6: Verification */
		 ContactInfoPage cip = new ContactInfoPage(driver);
		 String actHeader = cip.contactNameInfo();
		 if(actHeader.contains(lastName))
		 {
			 System.out.println(actHeader+"----->contact created");
		 }
		 
		 else
		 {
			 System.out.println("contact not created");
		 }
		 
	}
		 
		 
	}	
	




