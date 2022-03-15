package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateContactPage extends WebDriverUtility{
	
	@FindBy(name ="lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath = "//input[@name = 'account_name']/following-sibling::img[@alt='Select']")
	private WebElement orgNameLookUpImg;
	
	@FindBy(name = "leadsource")
	private WebElement leadSourceDropdown;
	
	//Child window of organization in contacts module
	@FindBy(id = "search_txt")
	private WebElement searchEdt;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	@FindBy(xpath= "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//Initialization
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//Utilization- Using Getters 
	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getOrgNameLookUImg() {
		return orgNameLookUpImg;
	}

	public WebElement getLeadSourceDropdown() {
		return leadSourceDropdown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	
	//Business library
	
	public void createNewContact(String lastName)
	{
		lastNameEdt.sendKeys(lastName);
		saveBtn.click();
	}
	
	public void createNewContact(String lastName, String leadsource)
	{
		lastNameEdt.sendKeys(lastName);
		select(leadsource, leadSourceDropdown);
		saveBtn.click();
	}
	
	
	public void createNewContact(WebDriver driver, String lastName, String orgName)
	{
		lastNameEdt.sendKeys(lastName);
		orgNameLookUpImg.click();
		switchToWindow(driver, "Accounts");
		searchEdt.sendKeys(orgName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		switchToWindow(driver, "Contacts");
		saveBtn.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
