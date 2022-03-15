package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	//Step1: Declaration
		@FindBy(xpath = "//img[@title='Create Product...']")
		private WebElement createOrgLookUpImg;


		//Step2: Initialization
		public ProductPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}



		//Step3: Utilization-- Using getters

		public WebElement getCreateOrgLookUpImg() 
		{
			return createOrgLookUpImg;
		}



		//Business Library
		public void clickOnCreateProImg()
		{

			createOrgLookUpImg.click();
		}




	}


