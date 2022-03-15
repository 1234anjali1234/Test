package com.crm.ContactTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.ContactInfoPage;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.CreateOrganizationPage2;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationsInfoPage3;
import com.crm.ObjectRepository.OrganizationsPage1;

public class CreateContactsAndChooseExistingOrganizationTest_Pom_ObjectRepository {

	@Test
	public void createContactWithOrgTest() throws Throwable
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
		String LastName = eLib.readDataFromExcel("Contacts", 4, 2)+"_"+jLib.getRandomNumber();
		String OrgName = eLib.readDataFromExcel("Contacts", 4, 3)+"_"+jLib.getRandomNumber();

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

		/*Step 4: Navigate to Organizations Link*/
		HomePage hp = new HomePage(driver);
		hp.ClickOnOrgLnk();

		/*Step 5: click on create organization Link*/
		OrganizationsPage1 op = new OrganizationsPage1(driver);
		op.clickOnCreateOrgImg();

		/*Step 6: enter mandatory fields and save*/
		CreateOrganizationPage2 cop = new CreateOrganizationPage2(driver);
		cop.createNewOrg(OrgName);


		/*Step 7:verify for organization*/
		OrganizationsInfoPage3 oip = new OrganizationsInfoPage3(driver);
		String header = oip.OrgNameInfo();
		if(header.contains(OrgName))
		{
			System.out.println(header);
			System.out.println("Org created");
		}
		else
		{
			System.out.println(header);
			System.out.println("Org not created");
		}

		/*step 8: navigate to contacts link*/
		hp.ClickOnContactLnk();

		ContactsPage cp = new ContactsPage(driver);
		cp.clickOncreateContactImg();


		/*Step 9: choose org */
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.createNewContact(driver, LastName, OrgName);

		/*Step 10: verfify for contact*/
		ContactInfoPage cip = new ContactInfoPage(driver);
		String contactHeader = cip.contactNameInfo();
		if(contactHeader.contains(LastName))
		{
			System.out.println(contactHeader +" contact created");
		}
		else
		{
			System.out.println("contact not created");
		}

		/*Step 11: logout and close the browser*/
		hp.signOutOfApp(driver);
		driver.quit();
	}
}




}
