package com.spacesoil;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;

import com.genericutility.Excel;
import com.genericutility.JavaUtility;
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


public class VTigerSoilOrganization
{
public static void main(String[] args) throws IOException
{
	JavaUtility jUtil = new JavaUtility();
	Excel eUtil = new Excel();
	Property pUtil = new Property();
	WebDriverUtility wUtil = new WebDriverUtility();
	
	String BROWSER = pUtil.propertyfile("browser");
	String URL = pUtil.propertyfile("url");
	String USERNAME = pUtil.propertyfile("username");
	String PASSWORD = pUtil.propertyfile("password");
	
	String Eread = eUtil.excelRead("Sheet2", 4, 2);
	String Eread1 = eUtil.excelRead("sheet2", 4, 3)+jUtil.randomnumber();
	
	WebDriver driver=null;
	if(BROWSER.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	} else if(BROWSER.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		} else {
			System.out.println("invalid script");
		}
	wUtil.windowmaximize(driver);
	wUtil.waitForPageLoad(driver);
	driver.get(URL);
	
	LoginPage lp = new LoginPage(driver);
	lp.loginPageCreated(USERNAME, PASSWORD);
	
	 HomePage hp = new HomePage(driver);
	 hp.clickOnOrganizationLink();
	 
	 
	 OrganizationPage op = new OrganizationPage(driver);
	 op.orglookUpPage();
	  
	 CreateOrganizationPage cop = new CreateOrganizationPage(driver);
	 cop.CreateOrganizationInfoPage(Eread1);
	 
	 OrganizationInfoPage orgInfo = new OrganizationInfoPage(driver);
			String orgHeader = orgInfo.getOrgHeader();
			if(orgHeader.contains(orgHeader))
			{
				System.out.println("orginisation info page successfully");
			} else
			{
				System.out.println("orginzation infor page fails");
			}
	 
			hp.clickOnContactsLink();
		    ContactsPage cp = new ContactsPage (driver);
		    cp.ContactLookupPage();
			
			CreateContactPage ccp = new CreateContactPage(driver);
			ccp.CreateNewContactPage(driver, Eread, Eread1);
					
					
			ContactInfoPage cHead = new ContactInfoPage(driver);
			String contHeader = cHead.contactInfoText();
			if(contHeader.contains(contHeader))
			{
			  System.out.println("contact info page sucessfully created");
			}
			else
			{
			  System.out.println("fail");
			}
			hp.clickonOpportunitiesLnk();
			
			OpportunitiesPage oppPage = new OpportunitiesPage(driver);
			oppPage.ClickOnOppLookUpImg();
			
			CreateNewOppourtunityPage cnop = new CreateNewOppourtunityPage(driver);
			cnop.createNewOppPage(Eread1);
			cnop.switchwindow(driver, Eread1);
			
			
				
	
}

}