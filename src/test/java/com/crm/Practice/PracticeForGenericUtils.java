package com.crm.Practice;

import org.testng.annotations.Test;

import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;

public class PracticeForGenericUtils {
	
	@Test
	public void practice() throws Throwable
	
	//Non static so created object for java utils
	{
		JavaUtility jLib = new JavaUtility();
		int ran = jLib.getRandomNumber();
		String dat = jLib.getSystemDateInFormat();
		String date = jLib.getSystemDate();
		System.out.println(ran + date);
		System.out.println(dat);
		
		PropertyFileUtility pLib = new PropertyFileUtility();
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		System.out.println(BROWSER);
	}

}
