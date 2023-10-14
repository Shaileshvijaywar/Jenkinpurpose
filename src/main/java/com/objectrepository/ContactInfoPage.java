package com.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	
	@FindBy(xpath="//span[@class=\"dvHeaderText\"]")
	private WebElement ContactInforText;
	
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactInforText() {
		return ContactInforText;
	}
   
	public String contactInfoText()
	{
		return ContactInforText.getText();
	}
}
