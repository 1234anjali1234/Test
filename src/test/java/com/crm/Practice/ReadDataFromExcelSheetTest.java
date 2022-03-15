package com.crm.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ReadDataFromExcelSheetTest {
	
	@Test
	public void readDataFromExcel() throws IOException  
	{
		//step 1: load excel file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Data.xlsx");
		
		//step 2: create a workbook
		  Workbook wb = WorkbookFactory.create(fis);
		
		//step 3:
		  Sheet sh = wb.getSheet("Sheet1");
		  
		// step 4: get the row
		   Row ro = sh.getRow(2);
		   
		 //step 5: get the cell
		   Cell ce = ro.getCell(1);
		   
		 //step 6: read the data from the cell
		    Object value =ce.getStringCellValue();
		    System.out.println(value);

	}

}
