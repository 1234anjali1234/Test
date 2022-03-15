package com.crm.Practice;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadDataFromSuitXMLfileTest {
	
	@Test
	 public void readDataFromSuitXMLfile(XmlTest xml)
	 {
		  String BROWSER = xml.getParameter("browser");
		  String URL = xml.getParameter("url");
		  
		  System.out.println(BROWSER);
		  System.out.println(URL);
		
	 }

}
//com.crm.Practice.ReadDataFromSuitXMLfileTest