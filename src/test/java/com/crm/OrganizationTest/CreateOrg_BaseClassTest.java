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

public class CreateOrg_BaseClassTest extends BaseClass {

	@Test(groups = "SmokeSuit")

	public void createOrgChooseIndustryType() throws Throwable
	{

		SoftAssert sa = new SoftAssert(); //softAssert --->give it globally
		
		//read data from excel file
		String OrgName = eLib.readDataFromExcel("Org", 1, 2)+"_"+jLib.getRandomNumber();
		

		/*Step 4: Navigate to Organization link*/
		HomePage hp = new HomePage(driver);
		hp.ClickOnOrgLnk();
		String ExpData = "Organizations";
	    String actData = driver.findElement(By.linkText("Organizations")).getText();
	    Assert.assertEquals(actData, ExpData);  //Hard Assert

		/*Step 5: Click on create organization btn*/
		OrganizationsPage1 op = new OrganizationsPage1(driver);
		op.clickOnCreateOrgImg();
		String expHeader = "Creating New Organization";
		String actHeader = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		sa.assertEquals(actHeader,expHeader); //soft Assert
		

		/*Step 6: enter mandatory fields and save*/
		CreateOrganizationPage2 cop = new CreateOrganizationPage2(driver);
		cop.createNewOrg(OrgName);

		/*Step 7: Verification */
		OrganizationsInfoPage3 oip = new OrganizationsInfoPage3(driver);
		String actOrgName = oip.OrgNameInfo();
		Assert.assertTrue(actOrgName.contains(OrgName)); //Hard Assert
		Reporter.log(actOrgName +"org created",true);
		
		sa.assertTrue(actOrgName .contains(OrgName)); //put "abc", OrgName //soft Assert
		System.out.println("pass");
		sa.assertAll();                   //soft Assert
		System.out.println("Assert all Ok");

		
	}

	

	
}


