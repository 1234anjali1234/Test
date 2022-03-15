package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsInfoPage {
	

	//Step1: Declaration
		@FindBy(xpath = "//span[@class='dvHeaderText']")
		private WebElement headerText;

		//Step2; Initialization
		public CampaignsInfoPage(WebDriver driver)
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
			String CampInfo = headerText.getText();
			return CampInfo;
		}








	}



