package com.crm.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuery {
	
	@Test
	//here void is the return type of @test
	public void sampleJDBCExecuteQuery() throws Throwable
	{
		//step1:register the database
		 Driver driverRef = new Driver();
		 DriverManager.registerDriver(driverRef);
		
		
		
		//step2: get connector from database-provide db name
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		
		
		
		//step3:issue create statement -provided to get the reference
		 Statement state = con.createStatement();
		
		//step4:execute Query---provide table name------executeQuery()method
		 ResultSet result = state.executeQuery("select * from student;");
		 //for validation use while loop
		 while(result.next())
		 {
			 System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
		 }
		
		
		//step5: close the database
		 con.close();
	}

}
