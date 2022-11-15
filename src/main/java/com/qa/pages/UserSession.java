package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class UserSession extends TestBase{
	
	
	
	@FindBy(className="parentmenuactive")
	WebElement monitor;
	
	@FindBy(linkText="Live Sessions")
	WebElement livesessions;
	
	@FindBy(xpath="//a[text()='Users']")
	WebElement users;
	
	@FindBy(xpath="//table[@id='AppSessionPatial']//tbody//tr//td[2]//span")
	WebElement username;
	
	@FindBy(xpath="//table[@id='AppSessionPatial']//tbody//tr//td[9]//span")
	WebElement status;
	
	@FindBy(xpath="//a[text()='Desktops']")
	WebElement desktops;
	
	@FindBy(xpath="//table[@id='tableSessionPartial']//tbody//tr//td[6]")
	WebElement poolname;
	
	@FindBy(xpath="//table[@id='tableSessionPartial']//tbody//tr//td[11]//div[@class='session-desktopconnected-div text-right']")
	WebElement statusdesktop;
	
	
	
	public UserSession() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	
	/* 
	 * function to get status of user
	 * 
	 */
	
	public String [] getUserSessionDetails()
	{
		monitor.click();
		livesessions.click();
		users.click();
				
		String[] details = new String[2];
		details[0] = username.getText();
		details[1] = status.getText();
		
		return details;
	}
	
	
	
	/* 
	 * Function to get Desktop status 
	 * 
	 */
	
	public String[] getDesktopSessionDetails()
	{
		monitor.click();
	    livesessions.click();
	    desktops.click();
	    
	    String[] desktopdetails = new String[2];
	    desktopdetails[0] = poolname.getText();
	    desktopdetails[1] = statusdesktop.getText();
	    
	    return desktopdetails;
		
	}

}
