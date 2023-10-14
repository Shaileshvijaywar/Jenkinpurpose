package com.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericutility.WebDriverUtility;

public class CreateOrganizationPage extends WebDriverUtility {
	
	@FindBy(name="accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name="industry")
	private WebElement IndustryNameEdt;
	
	@FindBy(xpath="//input[@title=\"Save [Alt+S]\"]")
	private WebElement SavePage;
	
	// 
	
	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getIndustryNameEdt() {
		return IndustryNameEdt;
	}

	public WebElement getSavePage() {
		return SavePage;
	}

	public void CreateOrgnizationInfoPage(String OrgName, String value)
	{
		OrgNameEdt.sendKeys(OrgName);
		handledropdown(IndustryNameEdt, value);
		SavePage.click();
		
	}
	public void CreateOrganizationInfoPage(String OrgName)
	{
		OrgNameEdt.sendKeys(OrgName);
		SavePage.click();
		
		
	}
}
