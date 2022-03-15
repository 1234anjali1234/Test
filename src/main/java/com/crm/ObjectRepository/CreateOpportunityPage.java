package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateOpportunityPage extends WebDriverUtility {


	//Step1: Declaration
	@FindBy(xpath= "//input[@name = 'potentialname']")
	private WebElement OppNameEdt;

	@FindBy(name = "related_to_display")
	private WebElement relatedToDisplayDropDown;

	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement createOrgLookUpImg;
	
	//Child window of Contacts in Opportunity module
	@FindBy(id = "search_txt")
	private WebElement searchEdt;

	@FindBy(name = "search")
	private WebElement searchBtn;

	@FindBy(name = "leadsource")
	private WebElement leadsourceDropDown;

	@FindBy(xpath= "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//input[@name='campaignname']/following-sibling::img[@title='Select']")
	private WebElement createCampSourceLookUpImg;
	
	@FindBy(xpath = "//select[@name='sales_stage']")
	private WebElement Sales_StagesDropDown;
	
	


	//Step2: Initialization
	public CreateOpportunityPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	//Step:3 Utilization---> Using getters
	public WebElement getOppNameEdt() {
		return OppNameEdt;
	}


	public WebElement getRelatedToDisplayDropDown() {
		return relatedToDisplayDropDown;
	}


	public WebElement getCreateConLookUpImg() {
		return createOrgLookUpImg;
	}


	public WebElement getSearchEdt() {
		return searchEdt;
	}


	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getLeadsourceDropDown() {
		return leadsourceDropDown;
	}

	public WebElement getCreateCampSourceLookUpImg() {
		return createCampSourceLookUpImg;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
    public WebElement getSales_StagesDropDown() {
		return Sales_StagesDropDown;
	}


	//Business Library
	
	public void createNewOpp(String OppName)
	{
		OppNameEdt.sendKeys(OppName);
	}
	
	public void createNewOpp(String OppName, String RelatedTo)
	{
	   OppNameEdt.sendKeys(OppName);
	   select(RelatedTo, relatedToDisplayDropDown);
	}
	
	
	public void createNewOpp(WebDriver driver,String OppName, String Organization, String Sales_Stages)
	{
		OppNameEdt.sendKeys(OppName);
		createOrgLookUpImg.click();
		switchToWindow(driver, "Accounts&action");
		searchEdt.sendKeys(Organization);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+Organization+"']")).click();
		switchToWindow(driver, "Potentials&action");
		Sales_StagesDropDown.sendKeys(Sales_Stages);
		saveBtn.click();
	}

}



