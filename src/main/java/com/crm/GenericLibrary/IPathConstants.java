package com.crm.GenericLibrary;

/**
 * This is interface to store all the path constants
 * @author FCI-L538
 *
 */

public interface IPathConstants {
	
	//Excel path
	String ExcelPath = ".\\src\\test\\resources\\V_Tiger_Data.xlsx";
	                  
	
	//Property file path
    String FilePath = ".\\src\\test\\resources\\Commondata.properties";
                          
    
    //Database path
    String dbURL = "jdbc:mysql://localhost:3306/students";
    String dbUsername ="root";
    String dbPassword = "root";
}
