package com.spacesoil;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.genericutility.BaseClass;
import com.genericutility.Excel;
import com.genericutility.JavaUtility;
import com.genericutility.ListnersImplementation;
import com.genericutility.Property;
import com.genericutility.WebDriverUtility;
import com.objectrepository.ContactInfoPage;
import com.objectrepository.ContactsPage;
import com.objectrepository.CreateContactPage;
import com.objectrepository.CreateNewOppourtunityPage;
import com.objectrepository.CreateOrganizationPage;
import com.objectrepository.HomePage;
import com.objectrepository.LoginPage;
import com.objectrepository.OpportunitiesPage;
import com.objectrepository.OrganizationInfoPage;
import com.objectrepository.OrganizationPage;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.genericutility.ListnersImplementation.class)
public class TestNGVtigerSoilOrganizationTest extends BaseClass{
	@Test(groups="SmokeSuite")
	public void clickOnSoilOrg() throws IOException {
	
		String Eread = eUtil.excelRead("Sheet2", 4, 2);
		String Eread1 = eUtil.excelRead("sheet2", 4, 3)+jUtil.randomnumber();
		
		 HomePage hp = new HomePage(driver);
		 hp.clickOnOrganizationLink();
		 
		 
		 OrganizationPage op = new OrganizationPage(driver);
		 op.orglookUpPage();
		  
		 CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		 cop.CreateOrganizationInfoPage(Eread1);
		 
		 OrganizationInfoPage orgInfo = new OrganizationInfoPage(driver);
				String orgHeader = orgInfo.getOrgHeader();
				Assert.assertTrue(orgHeader.contains(orgHeader));
				System.out.println(orgHeader+"org header created sucessfully");
				
				hp.clickOnContactsLink();
			    ContactsPage cp = new ContactsPage (driver);
			    cp.ContactLookupPage();
				
				CreateContactPage ccp = new CreateContactPage(driver);
				ccp.CreateNewContactPage(driver, Eread, Eread1);
						
						
				ContactInfoPage cHead = new ContactInfoPage(driver);
				String contHeader = cHead.contactInfoText();
				Assert.assertTrue(contHeader.contains(contHeader));
				System.out.println(contHeader+"created successfuly");
				
				hp.clickonOpportunitiesLnk();
				OpportunitiesPage oppPage = new OpportunitiesPage(driver);
				oppPage.ClickOnOppLookUpImg();		
	 }	
	}		
		
	


