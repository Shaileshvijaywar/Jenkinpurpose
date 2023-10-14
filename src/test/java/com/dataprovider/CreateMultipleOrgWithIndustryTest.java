package com.dataprovider;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.genericutility.BaseClass;
import com.objectrepository.CreateOrganizationPage;
import com.objectrepository.HomePage;
import com.objectrepository.OrganizationInfoPage;
import com.objectrepository.OrganizationPage;

public class CreateMultipleOrgWithIndustryTest extends BaseClass {

	@Test(dataProvider="sample")
	public void createMultipleOrgTest(String Org) throws EncryptedDocumentException, IOException
	{
		String ORGNAME=Org+jUtil.randomnumber();
		
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganizationLink();
		
		
		OrganizationPage op= new OrganizationPage(driver);
		op.orglookUpPage();
		
		CreateOrganizationPage cop=new CreateOrganizationPage(driver);
		cop.CreateOrgnizationInfoPage(ORGNAME, ORGNAME);
		
		
		OrganizationInfoPage cip=new OrganizationInfoPage(driver);
		String OrgHeader = cip.getOrgHeader();
		Assert.assertTrue(OrgHeader.contains(ORGNAME));
		
		System.out.println("hi");
	} 
	
	@DataProvider(name="sample")
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		 Object[][] data = eUtil.dataProvider1("Multiple");
		 return data;
	}
}
