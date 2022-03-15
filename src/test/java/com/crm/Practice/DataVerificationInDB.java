package com.crm.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class DataVerificationInDB 
{
	
 @Test
 
 public void dataVerificationInDB() throws Throwable
{
	 String expdata = "Kundan";
  Driver driverRef = new Driver();
  DriverManager.registerDriver(driverRef);
  
   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
   
    Statement state = con.createStatement();
    
    ResultSet result = state.executeQuery("select * from student;");
	 //for validation use while loop
	 while(result.next())
	 { 
		 String actdata = result.getString(2);
		 if(actdata.equalsIgnoreCase(expdata))
		 {
		 System.out.println(actdata+" data is verified");
		 break;
	 }
		 }
	
	
	//step5: close the database
	 con.close();
}
}
 

