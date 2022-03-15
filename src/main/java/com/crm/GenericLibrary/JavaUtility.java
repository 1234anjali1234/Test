package com.crm.GenericLibrary;

import java.util.Date;
import java.util.Random;

/**
 * This class consists of generic methods wrt to java
 * @author FCI-L538
 *
 */
public class JavaUtility {
	
	/**
	 * This method will generate a random number and return it to user
	 * @return
	 */
	public int getRandomNumber() //change from void to int so that it will give random number and return it to user
	{
	 Random ran = new Random();
	 int random = ran.nextInt(500);
	 return random;
	}
	
	/**
	 * This method will generate a current system date  and return it to user
	 * @return
	 */
	
    public String getSystemDate() //change from void to string so that it will give random date and return it to user
    {
    	Date d = new Date();
    	String date = d.toString();
    	return date;
    }
    
    /**
     * This method will generate system date and return date in format
     * @return
     */
    
    public  String getSystemDateInFormat() //change from void to string so that it will give random date format and return it to user
    
    {
    	Date d = new Date();
    	String d1 = d.toString();
    	String[] date = d1.split(" ");
    	
    	String mon = date[1];
    	String day = date[2];
    	String time = date[3].replace(":","-");
    	String year = date[5];
    	
    	 String DateFormate = day+"-"+mon+"-"+year+"-"+time;
		 return DateFormate;
    }

}
