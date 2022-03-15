package com.crm.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;

public class DataProviderWithExcel {
	
	@Test(dataProvider= "data")
	public void data(String orgname, String indType, String Type )
	{
		System.out.println(orgname+ " "+indType+ " "+Type);
	}

	@DataProvider(name = "data")
	public Object[][] getData() throws Throwable 
	{
		ExcelFileUtility eLib = new ExcelFileUtility();
		Object[][] value = eLib.readmultipleDataFromExcel("OrgMultipleData");
		return value;
	}
}
