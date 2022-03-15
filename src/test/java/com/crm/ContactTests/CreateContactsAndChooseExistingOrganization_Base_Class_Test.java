package com.crm.ContactTests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.ContactInfoPage;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.CreateOrganizationPage2;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationsInfoPage3;
import com.crm.ObjectRepository.OrganizationsPage1;

@Listeners(com.crm.GenericLibrary.ListnerImplementationClass.class)
public class CreateContactsAndChooseExistingOrganization_Base_Class_Test extends BaseClass  {

	@Test
	public void createContactWithOrgTest() throws Throwable
	{
		
		//read data from excel file
		String LastName = eLib.readDataFromExcel("Contacts", 4, 2)+"_"+jLib.getRandomNumber();
		String OrgName = eLib.readDataFromExcel("Contacts", 4, 3)+"_"+jLib.getRandomNumber();

	

		/*Step 4: Navigate to Organizations Link*/
		HomePage hp = new HomePage(driver);
		hp.ClickOnOrgLnk();

		/*Step 5: click on create organization Link*/
		OrganizationsPage1 op = new OrganizationsPage1(driver);
		op.clickOnCreateOrgImg();
		Assert.fail();

		/*Step 6: enter mandatory fields and save*/
		CreateOrganizationPage2 cop = new CreateOrganizationPage2(driver);
		cop.createNewOrg(OrgName);
		Assert.fail();
		
		/* Step 7: verification */
		OrganizationsInfoPage3 oip = new OrganizationsInfoPage3(driver);  
		String actdata = oip.OrgNameInfo();

		if(actdata.contains(OrgName))
		{
			System.out.println(actdata+"------> data verified");
		}
		else
			
		{
			System.out.println("data invalid");
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

	}
}





