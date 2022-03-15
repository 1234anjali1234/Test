package com.crm.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNgAssertionsPractice {
@Test
	
	public void assertionpractice()
	{
		
	  SoftAssert sa = new SoftAssert();
      System.out.println("This is test 1");
	  sa.assertEquals(1, 0);
	  System.out.println("Passed");
	  Assert.assertEquals(1,0);
	  System.out.println("skip");
	  Assert.assertEquals(1,0);
	  System.out.println("fail");
	  sa.assertAll();
	}


}
