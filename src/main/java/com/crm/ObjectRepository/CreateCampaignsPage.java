package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateCampaignsPage extends WebDriverUtility

{
	//Step1: Declaration
	@FindBy(name = "campaignname")
	private WebElement CampNameEdt;

	@FindBy(xpath = "//img[@title='Select']")
	private WebElement CampProductLookUpImg;


	@FindBy(xpath = "//input[@title = 'Save [Alt+S]']")
	private WebElement saveBtn;

	@FindBy(name = "search_txt")
	private WebElement searchEdt;

	@FindBy(name = "search")
	private WebElement searchBtn;






	//Step2: Initialization
	public CreateCampaignsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}




	//Step:3 Utilization---> Using getters
	public WebElement getCampNameEdt() {
		return CampNameEdt;
	}




	public WebElement getCampProductLookUpImg() {
		return CampProductLookUpImg;
	}



	public WebElement getSearchEdt() {
		return searchEdt;
	}




	public WebElement getSearchBtn() {
		return searchBtn;
	}



	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	//Business Library

	public void createNewCamp(WebDriver driver, String CampName, String ProName)
	{
		CampNameEdt.sendKeys(CampName);
		CampProductLookUpImg.click();

		switchToWindow(driver, "Products&action");
		searchEdt.sendKeys(ProName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[.='"+ProName+"'")).click();
		switchToWindow(driver, "Campaigns&action");
		

		saveBtn.click();
	}


}


