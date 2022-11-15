package com.qa.pages;

import java.io.IOException;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase {
	
     
  
	
	/*
	 * Pagefactory : or
	 * 
	 * loactors for all target elements
	 */
	
	
	@FindBy(id="details-button") 
	WebElement details;
	
	@FindBy(id="proceed-link")
	WebElement proceedsafe;
	
	@FindBy(id="usernameInputBox")
	WebElement userName;
	
	@FindBy(id="passwordInputBox")
	WebElement PasswordEle;
	
	@FindBy(id="loginButton")
	WebElement Loginbtn;
	
	/* Constructor */
	
	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	
	/*
	 * function for getting login page title
	 */	
	public String getLoginpageTitle() 
	{
		return driver.getTitle();
	}
	
	
	/* 
	 * function for login into HyWorks management console 
	 * 
	 */
	
	public HomePage setLoginIntoHyWorks(String usrnm,String pwd) throws IOException   
	{
		userName.sendKeys(usrnm);
		PasswordEle.sendKeys(pwd);
		Loginbtn.click();
		
		return new HomePage();
	}
	
	

}
