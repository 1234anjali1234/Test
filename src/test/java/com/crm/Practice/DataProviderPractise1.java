package com.crm.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractise1 {
	
	@Test (dataProvider = "getData")
	public void sampleDataProvider(String Name, String Fav_subject)
	{
		System.out.println(Name+ "--------"+Fav_subject);
	}
		@DataProvider
		public Object[][] getData()
		{
			Object[][] obj = new Object [6][2];
			
			obj[0][0]="Rama";
			obj[0][1]="fav subject is Maths";
			
			
			obj[1][0]="Sita";
			obj[1][1]="fav subject is Sanskrit";
			
			
			obj[2][0]="Lakshman";
			obj[2][1]="fav subject is English";
			
					
			obj[3][0]="Hanuman";
			obj[3][1]="fav subject is Hindi";
			
			obj[4][0]="krishna";
			obj[4][1]="fav subject is Chemistry";
			
			obj[5][0]="Radha";
			obj[5][1]="fav subject is Physics";
			
			
			return obj;
			
			
		}
	}




