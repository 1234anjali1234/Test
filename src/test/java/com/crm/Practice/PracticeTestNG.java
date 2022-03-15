package com.crm.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeTestNG {
	
	@Test(priority = -1)                 //@Test(priority = -1)
	public void createOrg()              //it is executing based on alphabetical order or ASCII value 
	                                     //so we have to give priority for executing in sequence
	
	{
		System.out.println("org created");
	}

	@Test(dependsOnMethods = "createOrg") //@Test(dependsOnMethods = "createOrg")--this feature is not recommended
	public void modifyOrg()
	
	{
		System.out.println("org modified");
	}
	
	@Test(invocationCount =4)             //@Test(invocationCount =4)--->for printing 4 times
	public void deleteOrg()
	
	{
		System.out.println("org deleted");
		Assert.fail();                      //it will fail the script purposely
	}
	
}
