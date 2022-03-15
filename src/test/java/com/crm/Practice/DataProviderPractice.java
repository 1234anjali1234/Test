package com.crm.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	
	@Test (dataProvider = "getData")
	public void sampleDataProvider(String Name, String model, int qty)
	{
		System.out.println(Name+ "--------"+model+ "--------"+qty);
	}
	
		@DataProvider
		public Object[][] getData()
		{
			Object[][] obj = new Object [4][3];
			
			obj[0][0]="Mi";
			obj[0][1]="13 PRO max";
			obj[0][2]=25;
			
			obj[1][0]="iphone";
			obj[1][1]="11 max";
			obj[1][2]=12;
			
			obj[2][0]="VIVO";
			obj[2][1]="17 max";
			obj[2][2]=30;
					
			obj[3][0]="Nokia";
			obj[3][1]="13 max";
			obj[3][2]=12;
			
			return obj;
			
			
		}
	}


