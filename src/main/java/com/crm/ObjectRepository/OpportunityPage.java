package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityPage {

	//Step1: Declaration
	@FindBy(xpath = "//img[@title='Create Opportunity...']")
	private WebElement createOrgLookUpImg;


	//Step2: Initialization
	public OpportunityPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}



	//Step3: Utilization-- Using getters
	public WebElement getCreateOrgLookUpImg() 
	{
		return createOrgLookUpImg;
	}



	//Business Library
	public void clickOnCreateOppImg()
	{

		createOrgLookUpImg.click();
	}

}
