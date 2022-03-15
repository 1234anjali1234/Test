package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {
	
	//Step1: Declaration
		@FindBy(xpath = "//span[@class='dvHeaderText']")
		private WebElement headerText;

		//Step2; Initialization
		public ProductInfoPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}



		//Step3: Utilization ---->Using Getters

		public WebElement getHeaderText() 
		{
			return headerText;
		}

		


		//Business Library
		public String OppNameInfo()
		{
			String ProInfo = headerText.getText();
			return ProInfo;
		}





	}



