package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class HomePage extends WebDriverUtility {

	//Step1: Declaration - Use @FindBy annotation
	@FindBy(linkText = "Organizations")
	private WebElement OrganizationsLnk;

	@FindBy(linkText = "Contacts")
	private WebElement ContactsLnk;

	@FindBy(linkText = "Opportunities")
	private WebElement OpportunitiesLnk;

	@FindBy(linkText = "products")
	private WebElement productsLnk;

	@FindBy(linkText = "More")
	private WebElement moreLnk ;

	@FindBy(linkText = "Campaigns")
	private WebElement campaignsLnk;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;

	@FindBy(linkText = "Sign Out")
	private WebElement signOutLnk;
	



	//Step2: Initialization - Use Constructor ///initialize only one time

	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	//Step3: Utilization - provide getters

	public WebElement getOrganizationsLnk() {
		return OrganizationsLnk;
	}


	public WebElement getContactsLnk() {
		return ContactsLnk;
	}


	public WebElement getOpportunitiesLnk() {
		return OpportunitiesLnk;
	}


	public WebElement getProductsLnk() {
		return productsLnk;
	}


	public WebElement getMoreLnk() {
		return moreLnk;
	}


	public WebElement getCampaignLnk() {
		return campaignsLnk;
	}


	public WebElement getAdministratorImg() {
		return administratorImg;
	}


	public WebElement getSignOutLnk() {
		return signOutLnk;
	}
	
	

	//Business Library-----what action we will perform we have to give in this business library
    public void ClickOnOrgLnk()
    {
    	OrganizationsLnk.click();
    }
    
    public void ClickOnContactLnk()
    {
    	ContactsLnk.click();
    }
    
    public void ClickOnOpportunitiesLnk()
    {
    	OpportunitiesLnk.click();
    }
    public void ClickOnMoreLnk()
    {
    	moreLnk.click();
    }
    
    public void ClickOnproductsLnk()
    {
    	productsLnk.click();
    }
    
    
    public void ClickOncampaignsLnk()
    {
    	campaignsLnk.click();
    }
    
    public void signOutOfApp(WebDriver driver)
    {
    	mouseHover(driver, administratorImg);
    	signOutLnk.click();
    }
    


}
