package com.crm.ContactTests;

import org.openqa.selenium.WebDriver;
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

public class CreateContactWithMandatoryFieldTest {

	PropertyFileUtility pLib = new PropertyFileUtility();
	JavaUtility jLib = new JavaUtility();
	ExcelFileUtility eLib = new ExcelFileUtility();
	WebDriverUtility wLib = new WebDriverUtility();
	

	@Test(dataProvider = "OrgtestData")

	public void createContactTest() throws Throwable
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
		String LastName = eLib.readDataFromExcel("Org", 4, 2)+"_"+jLib.getRandomNumber();
		

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
		hp.ClickOnContactLnk();
		
	    /*Step 6: enter mandatory fields(last_name) and save*/
		 CreateContactPage ccp = new CreateContactPage(driver);
		 ccp.createNewContact(LastName);
		 
		 /*Step 6: Verification */
		 ContactInfoPage cip = new ContactInfoPage(driver);
		 String actHeader = cip.contactNameInfo();
		 if(actHeader.contains(LastName))
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
	

	@DataProvider(name = "OrgtestData")
	public Object[][] getData() throws Throwable
	
	{
		Object[][] data = eLib.readmultipleDataFromExcel("OrgMultipleData");
		return data;
	}
	
}


