package com.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericutility.WebDriverUtility;

public class HomePage extends WebDriverUtility{
		
		// declaration is use to develop all home page link 
		@FindBy(linkText="Organizations")
		private WebElement OrganizationLnk;
		
		@FindBy(linkText="Contacts")
		private WebElement ContactsLnk; 
		
		@FindBy(linkText="Opportunities")
		private WebElement OpportunitiesLnk;
		
		@FindBy(xpath="//img[@src=\"themes/softed/images/user.PNG\"]")
		private WebElement AdministrationImg;
		
		@FindBy(linkText="Sign Out")
		private WebElement Signoutlnk;
		

	 //	Initialization to use constructor
		
		public HomePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		//utilization

		public WebElement getOrgnizationLnk() {
			return OrganizationLnk;
		}

		public WebElement getContactsLnk() {
			return ContactsLnk;
		}

		public WebElement getOrganizationLnk() {
			return OrganizationLnk;
		}

		public WebElement getOpportunitiesLnk() {
			return OpportunitiesLnk;
		}

		public WebElement getAdministrationImg() {
			return AdministrationImg;
		}

		public WebElement getSignoutLookupImg() {
			return  AdministrationImg;
		}

		public WebElement getSignoutlnk() {
			return Signoutlnk;
		}
		
		///business library
		
		public void clickOnOrganizationLink()
		{
			OrganizationLnk.click();
		}
		public void clickOnContactsLink()
		{
			ContactsLnk.click();
		}
		public void clickonOpportunitiesLnk()
		{
			OpportunitiesLnk.click();
		}
		
		public void logout(WebDriver driver)
		{
			mousehoveraction(driver, AdministrationImg);
			Signoutlnk.click();
			
		}
	
}


