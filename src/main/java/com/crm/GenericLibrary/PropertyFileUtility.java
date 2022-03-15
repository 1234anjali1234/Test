package com.crm.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * This class will read data from property file and return value to user
 * @author FCI-L538
 *
 */
public class PropertyFileUtility {
	
	/**this method will read data from property file for the key given by user and return value to user
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	//change from void to string so that it will take data from user
	public String readDataFromPropertyFile(String key) throws Throwable
	{
		 FileInputStream fis = new FileInputStream (IPathConstants.FilePath);//(".\\src\\test\\resources\\Commondata.properties");
		 Properties pObj = new Properties();
		 pObj.load(fis);                                //Instead of using all these :-
		 String value1 = pObj. getProperty(key);         //String BROWSER = pObj.getProperty("browser");
		//String URL = pObj.getProperty("url");
		//String USERNAME = pObj.getProperty("user");
		//String PASSWORD = pObj.getProperty("password");
		return value1;
}                                                        //we used getProperty(key) and return value
		                          
 		                                       

}
