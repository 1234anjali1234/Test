package com.crm.OrganizationOthersTest;

import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CreateOrganizationPage2;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationsInfoPage3;
import com.crm.ObjectRepository.OrganizationsPage1;

public class CreateOrg_BaseClassTest extends BaseClass {

	@Test

	public void createOrgChooseIndustryType() throws Throwable
	{


		//read data from excel file
		String OrgName = eLib.readDataFromExcel("Org", 1, 2)+"_"+jLib.getRandomNumber();
		

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
