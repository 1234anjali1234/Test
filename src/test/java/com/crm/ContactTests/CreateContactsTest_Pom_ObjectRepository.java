package com.crm.ContactTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.ContactInfoPage;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

public class CreateContactsTest_Pom_ObjectRepository {
	
	//Create Object for all utilities
	
		PropertyFileUtility pLib = new PropertyFileUtility(); //Globally declare it so that it will work for both @Test and @DataProvider
		ExcelFileUtility eLib = new ExcelFileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		JavaUtility jLib = new JavaUtility();
	
	@Test(dataProvider = "ContactstestData")
	public void createContactTest(String LastName) throws Throwable
	{
		PropertyFileUtility pLib = new PropertyFileUtility();
		JavaUtility jLib = new JavaUtility();
		ExcelFileUtility eLib = new ExcelFileUtility();
		WebDriverUtility wLib = new WebDriverUtility();

		/*Step 1: read all necessary data*/

		//read data from property file
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String URL = pLib.readDataFromPropertyFile("url");
		String USERNAME = pLib.readDataFromPropertyFile("user");
		String PASSWORD = pLib.readDataFromPropertyFile("password");

		//read data from excel file
		String lastName = LastName +jLib.getRandomNumber();
		

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

		wLib.maximizeWindow(driver);
		wLib.waitForpageLoad(driver);
		driver.get(URL);

		/*Step 3: login to application*/
		 LoginPage lp = new LoginPage(driver);
		 lp.loginToApp(USERNAME, PASSWORD);

		/*Step 4: Navigate to Contacts Link*/
		HomePage hp = new HomePage(driver);
		hp.ClickOnContactLnk();

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
		 
		 
		 
		/*Step 7: logout of application*/
		hp.signOutOfApp(driver);
		driver.quit();

		/*Step 8: close the browser*/
		//driver.quit();
	}
	
	@DataProvider(name = "ContactstestData")
	public Object[][] getData() throws Throwable
	
	{
		Object[][] data = eLib.readmultipleDataFromExcel("ContactsMultipleData");
		return data;
	}
	
}


