package com.objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericutility.WebDriverUtility;

public class CreateContactPage extends WebDriverUtility {
	@FindBy(name="lastname")
    private WebElement LastNameEdt;
	
	@FindBy(xpath="//input[@title=\"Save [Alt+S]\"]")
	private WebElement SaveButtn;

	@FindBy(xpath=" //input[@name=\"account_name\"] /following-sibling::img[@src=\"themes/softed/images/select.gif\"]")
	private WebElement OrglookUpName;

	@FindBy(name="search_text")
	private WebElement SearchEdt;
	
	@FindBy(name="search")
	private WebElement SearchNowEdt;
	
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastNameEdt() {
		return LastNameEdt;
	}

	public WebElement getSaveButtn() {
		return SaveButtn;
	}

	public WebElement getOrgalookUpName() {
		return OrglookUpName;
	}

	public WebElement getSearchEdt() {
		return SearchEdt;
	}

	public WebElement getSearchNowEdt() {
		return SearchNowEdt;
	}
	
	//Business library
	
	public void CreateNewContactPage(WebDriver driver, String LASTNAME,String ORGNAME)
	{
		LastNameEdt.sendKeys(LASTNAME);
		OrglookUpName.click();
		switchwindow(driver, "Accounts");
		SearchEdt.sendKeys(ORGNAME);
		SearchNowEdt.click();
		driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();
		switchwindow(driver, "Contacts");
		SaveButtn.click();
		
		
		
	}



}
