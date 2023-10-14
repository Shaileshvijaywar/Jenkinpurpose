package com.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesPage {
	
	@FindBy(xpath="//img[@alt=\"Create Opportunity...\"]")
	private WebElement opportunityLookUpImg;
	
	public OpportunitiesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOpportunityLookUpImg() {
		return opportunityLookUpImg;
	}
	
   public void ClickOnOppLookUpImg()
	{
		opportunityLookUpImg.click();	
	}
}
