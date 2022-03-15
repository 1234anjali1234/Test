package com.crm.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.testng.annotations.Test;

public class PropertyFilePractice {
	
	@Test
	
	public void propertyFilePractice() throws Throwable
	{
		//step1:read the file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//step2: create Obj of Properties
		Properties pobj = new Properties();
		pobj.load(fis);
		
		//step 3: read the data
		 String URL= pobj.getProperty("user");
		 
		 //Verification
		 System.out.println(URL);
		
	}

}
