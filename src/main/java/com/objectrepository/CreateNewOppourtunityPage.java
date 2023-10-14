package com.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericutility.WebDriverUtility;

public class CreateNewOppourtunityPage extends WebDriverUtility{
	
	@FindBy(name="potentialname")
	private WebElement OpportunityNameEdt;
	
	@FindBy(xpath="//img[@src=\"themes/softed/images/select.gif\"]")
	private WebElement RelatedToOrg;
	
	@FindBy(xpath="/html[1]/body[1]/table[4]/tbody[1]/tr[1]/td[2]/div[1]/form[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/input[1]")
	private WebElement SaveButton;
	
	public CreateNewOppourtunityPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOpportunityNameEdt() {
		return OpportunityNameEdt;
	}

	public WebElement getRelatedToOrg() {
		return RelatedToOrg;
	}

	public WebElement getSaveButton() {
		return SaveButton;
	}
	
	public void createNewOppPage(String OrgName)
	{
		OpportunityNameEdt.sendKeys(OrgName);
		RelatedToOrg.click();
		SaveButton.click();
	}
	

}
