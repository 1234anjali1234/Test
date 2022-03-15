package com.crm.OrganizationOthersTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.CreateOrganizationPage2;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationsInfoPage3;
import com.crm.ObjectRepository.OrganizationsPage1;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrgChooseIndustryTypeTest_Pom_ObjectRepository {
	
	@Test
	
	public void reateOrgChooseIndustryType() throws Throwable
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
		String OrgName = eLib.readDataFromExcel("Org", 4, 2)+"_"+jLib.getRandomNumber();
		String indType = eLib.readDataFromExcel("Org", 4, 2);
		
		/*Step 2: launch the browser*/
		WebDriverManager.firefoxdriver().setup();
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=null;
        if(BROWSER.equalsIgnoreCase("chrome"))  //Polymorphism
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
		
		/*Step 4: Navigate to Organization link*/
		HomePage hp = new HomePage(driver);
		hp.ClickOnOrgLnk();
		
		
		/*Step 5: Click on create organization btn*/
		 OrganizationsPage1 op = new OrganizationsPage1(driver);
		 op.clickOnCreateOrgImg();
		 
		 /*Step 6: enter mandatory fields and save*/
		CreateOrganizationPage2 cop = new CreateOrganizationPage2(driver);
		cop.createNewOrg(OrgName);
		
		 /*Step 7: Verification */
		OrganizationsInfoPage3 oip = new OrganizationsInfoPage3(driver);
		String actHeader = oip.OrgNameInfo();
		
		if(actHeader.contains(OrgName))
		{
		 System.out.println(actHeader +"-------> organization created");
		}
		
	   else 
	     {
		   System.out.println("organization creation failed");
	     }
		
	}

}
