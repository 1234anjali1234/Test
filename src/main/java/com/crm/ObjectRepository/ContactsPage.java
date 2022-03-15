package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	//Declaration
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement createContactsLookUpImage;
	
	@FindBy(xpath = "//table[@class = 'lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']")
	private WebElement ClickOnCheckBoxbtn;
	
	
	

	//Initialization
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//Utilization
	public WebElement getCreateContactsLookUpImage() 
	{
		return createContactsLookUpImage;
	}
	
	public WebElement getClickOnCheckBoxbtn() 
	{
		return ClickOnCheckBoxbtn;
	}

	
	
	//Business Library
	
	public void clickOncreateContactImg()
	
	{
		createContactsLookUpImage.click();
	}
	
	public void clickOnCheckBox()
	{
		ClickOnCheckBoxbtn.click();

	}
	
	

}
