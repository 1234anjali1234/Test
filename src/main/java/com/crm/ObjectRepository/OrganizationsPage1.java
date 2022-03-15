package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class OrganizationsPage1 extends WebDriverUtility {
	
	//Step1: Declaration
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createOrgLookUpImg;
	
	
	//Step2: Initialization
	public OrganizationsPage1(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	
	//Step3: Utilization-- Using getters
	
	public WebElement getCreateOrgLookUpImg() 
	{
		return createOrgLookUpImg;
	}
	
	
	
	//Business Library
	public void clickOnCreateOrgImg()
	{
		
		createOrgLookUpImg.click();
	}

}
