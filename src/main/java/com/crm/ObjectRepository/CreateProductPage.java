package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateProductPage {
	

public class CreateCampaignsPage extends WebDriverUtility

{
	//Step1: Declaration
	@FindBy(name = "productname")
	private WebElement ProNameEdt;
	
	@FindBy(xpath = "//input[@title = 'Save [Alt+S]']")
	private WebElement saveBtn;

	
	//Step2: Initialization
	public CreateCampaignsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}




	//Step:3 Utilization---> Using getters
	public WebElement getProNameEdt() {
		return ProNameEdt;
	}




	public WebElement getSaveBtn() {
		return saveBtn;
	}


	
	
	//Business Library

	public void createNewCamp(String ProName)
	{
		ProNameEdt.sendKeys(ProName);
		saveBtn.click();
	}


}

}



