package com.crm.OpportunityTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.CreateOpportunityPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OpportunityInfoPage;
import com.crm.ObjectRepository.OpportunityPage;

public class CreateOpportunitytc_14_Pom_ObjectRepo_withQualificationTest {
	
	@Test

	public void createOpportunityTc_11_Pom() throws Throwable

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
		String OppName = eLib.readDataFromExcel("Opportunity", 1, 2)+"_"+jLib.getRandomNumber();
		String RelatedTo = eLib.readDataFromExcel("Opportunity", 2, 3);
		String Organization = eLib.readDataFromExcel("Opportunity", 1, 7);
		String Sales_Stages = eLib.readDataFromExcel("Opportunity", 3, 8);


		/*Step 2: Launch the browser*/
        WebDriver driver = null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}

		else if (BROWSER.equalsIgnoreCase("firefox"))
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
		//HomePage hp = new HomePage(driver);
		//hp.ClickOnOrgLnk();                            
	

		/*Step 5: click on create organization button*/
		 // OrganizationsPage1 op = new OrganizationsPage1(driver); 
		  //op.clickOnCreateOrgImg();
		

		/*Step 6: enter mandatory fields and save*/
		 //CreateOrganizationPage2 cop = new CreateOrganizationPage2(driver); 
		 //cop.createNewOrg(OrgName);
		
		
		/*Step 7: Navigate to Opportunity Link*/
		HomePage hp = new HomePage(driver);
		hp.ClickOnOpportunitiesLnk();



		/*Step 5: click on create Opportunity button*/
		OpportunityPage op = new OpportunityPage(driver); 
		op.clickOnCreateOppImg();


		/*Step 6: enter mandatory fields and save*/
		CreateOpportunityPage cop = new CreateOpportunityPage(driver); 
		cop.createNewOpp(driver, OppName, Organization, Sales_Stages);
		
			
		/* Step 7: verification */
		OpportunityInfoPage oip = new OpportunityInfoPage(driver);  
		String actOppName = oip.OppNameInfo();
		if(actOppName.contains(OppName))
		{
			System.out.println(actOppName+"------> data verified");
		}
		else
		{
			System.out.println("data invalid");
		}

		/*Step 7: logout of application*/
		hp.signOutOfApp(driver);                                          


		/*Step 8: close the browser*/
		driver.quit();
		

	}
}