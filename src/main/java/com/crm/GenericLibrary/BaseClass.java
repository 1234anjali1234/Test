package com.crm.GenericLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	//Create Object of all Utilities
	
	public DatabaseUtility dbLib = new DatabaseUtility();
	public ExcelFileUtility eLib  = new ExcelFileUtility();
	public JavaUtility jLib = new JavaUtility();
	public PropertyFileUtility pLib =  new PropertyFileUtility();
	public WebDriverUtility wLib  = new WebDriverUtility();
	public WebDriver driver; 
	public static WebDriver sDriver;   //We needs for ITestListners(Interface) - for taking screenshot
	
	
	@BeforeSuite(groups = {"SmokeSuit","RegressionSuite"})
	public void connectDataBase()
	{
		//dbLib.connectToDb();  // ConnectToDb is the method present in database utility.
		System.out.println("===============ConnectToDb==================");
	}
	
	
	//@Parameters("browser")                                      //-----> Cross browser
	//@BeforeTest                                                //------> Cross browser
	//public void launchBrower(String BROWSER) throws Throwable  //------> Cross browser give parameter
	
     @BeforeClass(groups = {"SmokeSuit","RegressionSuite"}) //-->Simple parallel execution, batch execution,Regression, smoke(Group Execution) etc.
	 public void launchBrower() throws Throwable
	 
	
	{
		//Read data from property
		String BROWSER = pLib.readDataFromPropertyFile("browser"); //-------> Comment it for Cross Browser
		String URL= pLib.readDataFromPropertyFile("url");
		
		
		/*Step 2: launch the browser*/
		//WebDriver driver=null;
		
		if(BROWSER.equalsIgnoreCase("chrome"))   //--------> Create runtime Polymorphism
		{
			WebDriverManager.chromedriver().setup(); //----->Due to some version problem mismatch we use this sometime
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else		

		{
			System.out.println("invalid browser");
		}
		
		
		sDriver=driver;
		
		wLib.maximizeWindow(driver);
		wLib.waitForpageLoad(driver);
		driver.get(URL);
		Reporter.log("===============browser launch successful======", true);
	}
	
	@BeforeMethod(groups = {"SmokeSuit","RegressionSuite"}) //--------->Login
	public void login() throws Throwable                 
	{
		
		 String USERNAME = pLib.readDataFromPropertyFile("user");
		 String PASSWORD = pLib.readDataFromPropertyFile("password");
		 
		 LoginPage lp = new LoginPage(driver);
		 lp.loginToApp(USERNAME, PASSWORD);
		 Reporter.log("======Login successful======", true);
	}

	@AfterMethod(groups = {"SmokeSuit","RegressionSuite"}) //--------------> Logout to Application
	public void logout()
	{
		 HomePage hp = new HomePage(driver);
		 hp.signOutOfApp(driver);
		 Reporter.log("======Logout successful======", true);
	}
	
	//@AfterTest
	@AfterClass(groups = {"SmokeSuit","RegressionSuite"}) //---Simple Parallel execution------> Close Browser
	public void closeBrowser() 
	{
	 driver.quit();
	 Reporter.log("======Browser close successful======", true);
    }
	
	@AfterSuite(groups = {"SmokeSuit","RegressionSuite"}) //------> Close Database
	public void CloseDb()
	{
		//dbLib.closeDB();
		Reporter.log("======Database close successful======", true);
	}
	
	
}
