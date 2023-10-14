package com.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	//declaration
	@FindBy(xpath="//span[@class=\"dvHeaderText\"]")
	private WebElement OrgInfoText;
	
	//initialization
	
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getOrgInfoText() 
	{
		return OrgInfoText;
	}
	
    //Business Library
	public String getOrgHeader()
	{
		return OrgInfoText.getText();
		
	}
	
}
