package com.crm.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {

	@Test
	//here void is the return type of @test
	public void sampleJDBCExecuteQuery() throws Throwable
	{
		Connection con=null; //we declare it globally
		try
		{
		//step1:register the database
		 Driver driverRef = new Driver();
		 DriverManager.registerDriver(driverRef);
		
		
		
		//step2: get connector from database-provide db name
		  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		  System.out.println("connection established");
		
		
		//step3:issue create statement -provided to get the reference
		 Statement state = con.createStatement();
		
		//step4:execute Query---provide table name----------executeupdate()method
		 //insert into students values(4,'Kundan','Male';
		   int result = state.executeUpdate("insert into studen values(4,'Kundan','Male');");
		                                                 //intensely we have done mistake here given student as studen
		   //for validation use if else
		 if(result==1)
		 {
			 System.out.println("data added successfully");
		 }
		 else
		 {
			 System.out.println("data not added");
		 }
		}
		catch (Exception e) 
		{
			// TODO: handle exception
		} 
		
		finally //to handle close()
		{
			//Step5:close the database
			 con.close();
			 System.out.println("connection closed");
		}
		 
		 }
	
}
