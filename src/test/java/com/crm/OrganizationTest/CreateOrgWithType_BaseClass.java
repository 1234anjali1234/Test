package com.crm.OrganizationTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CreateOrganizationPage2;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationsInfoPage3;
import com.crm.ObjectRepository.OrganizationsPage1;

public class CreateOrgWithType_BaseClass  extends BaseClass{

	@Test(groups = "RegressionSuite")

	public void createOrgWithType() throws Throwable 
	{
		
	
		
	//read data from excel file
	String OrgName = eLib.readDataFromExcel("Org", 3, 2)+"_"+jLib.getRandomNumber();
	String IndType = eLib.readDataFromExcel("Org", 3, 3);
	String Type = eLib.readDataFromExcel("Org", 3, 4);
	
	/*Step 4: Navigate to Organizations Link*/
	HomePage hp = new HomePage(driver);
	hp.ClickOnOrgLnk();  
	

	/*Step 5: click on create organization button*/
	OrganizationsPage1 op = new OrganizationsPage1(driver); 
	op.clickOnCreateOrgImg();
	

	/*Step 6: enter mandatory fields and save*/
	CreateOrganizationPage2 cop = new CreateOrganizationPage2(driver); 
	cop.createNewOrg(OrgName, IndType, Type);;


	/* Step 7: verification */
	OrganizationsInfoPage3 oip = new OrganizationsInfoPage3(driver);  
	String actHeader = oip.OrgNameInfo();
	Assert.assertTrue(actHeader.contains(OrgName));
    
/*
    
	if(actHeader.contains(OrgName))
	{
		System.out.println(actHeader +"-------> organization created");
	}

	else 
	{
		System.out.println("organization creation failed");
	}
	
	*/
}
	//@Test
	//public void createOrg()
	//{
		//System.out.println("Test Script");
	//}
	
	//@Test
	//public void createOrg1()
	//{
	//	System.out.println("Test Script1");
	//}
	
	//@Test
	//public void createOrg2()
	//{
	//	System.out.println("Test Script2");
	//}
	
}


