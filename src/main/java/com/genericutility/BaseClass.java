package com.genericutility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.objectrepository.HomePage;
import com.objectrepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class consist of basic configuration annotation of TestNG
 */
public class BaseClass {
	
	public JavaUtility jUtil = new JavaUtility();
	public Excel eUtil = new Excel();
	public Property pUtil = new Property();
	public WebDriverUtility wUtil = new WebDriverUtility();
	
	public WebDriver driver;
	
	@BeforeSuite(groups={"SmokeSuite","RegressionSuite"})
	public void bsConfig()
	{
	System.out.println("DataBase connection successfully");
	}
	
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(groups={"SmokeSuite","RegressionSuite"})
	public void bcConfig(/*String Browser*/)throws IOException
	{
		String BROWSER = pUtil.propertyfile("browser");
		String URL = pUtil.propertyfile("url");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println("-------"+BROWSER+" launch");
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println("---"+BROWSER+"launch");
		} 
		
		else if(BROWSER.equalsIgnoreCase("edge")) 
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			System.out.println("---"+BROWSER+"launch");
		} 
		else
		{
				System.out.println("invalid script");
		}
		wUtil.windowmaximize(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);
	}
	
	@BeforeMethod(groups={"SmokeSuite","RegressionSuite"})
	public void bmConfig() throws IOException
	
	{
		String USERNAME = pUtil.propertyfile("username");
		String PASSWORD = pUtil.propertyfile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginPageCreated(USERNAME, PASSWORD);
		System.out.println("Login sucessfully");
	}
    
	@AfterMethod(groups={"SmokeSuite","RegressionSuite"})
	public void amConfig()
	{
		HomePage hp=new HomePage(driver);
		hp.logout(driver);
		System.out.println("logout sucessfully");
	}
	
	@AfterClass(groups={"SmokeSuite","RegressionSuite"})
	public void acConfig()
	{
		driver.quit();
		System.out.println("browser close");
	}
	
	@AfterSuite(groups={"SmokeSuite","RegressionSuite"})
	public void asConfig()
	{
		System.out.println("data base disconected");
	}
}
