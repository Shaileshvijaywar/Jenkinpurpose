package com.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//..........declaration...............
	
	@FindBy(name="user_name")
	private WebElement UserNameEdt;
	
	@FindBy(name="user_password")
	private WebElement PasswordEdt;
	
    @FindBy(id="submitButton")
    private WebElement SubmitButtn;
    
    //..........initialization.............
    
    public LoginPage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }
    
    //.........utilization..............
    
	public WebElement getUserNameEdt() {
		return UserNameEdt;
	}

	public WebElement getPasswordEdt() {
		return PasswordEdt;
	}

	public WebElement getSubmitButtn() {
		return SubmitButtn;
	}
    
	//.........Business library
	
	public void loginPageCreated(String USERNAME, String PASSWORD)
	{
		UserNameEdt.sendKeys(USERNAME);
		PasswordEdt.sendKeys(PASSWORD);
		SubmitButtn.click();
	}
    
	
}
