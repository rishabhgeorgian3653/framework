package com.qa.pages;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.HyliteTestBase;

public class HyliteLogin extends HyliteTestBase {
	
	
	@FindBy(xpath="//frame[@name='base']")
	WebElement frame1;
	
	@FindBy(xpath="//input[@name='uname']")
	WebElement user;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement pass;
	
	@FindBy(xpath="//select[@id='realmList']")
	WebElement dropdownforad;
	
	@FindBy(xpath="//button[@id='sendloginhello']")
	WebElement sendlogin;
	
	@FindBy(xpath="(//table[@id='HOSTED_DESKTOPS']//tr)[1]")
	WebElement hosteddesktop;
	
	@FindBy(xpath="(//table[@id='HOSTED_APPLICATIONS']//tr)[1]")
	WebElement hostedapp1;
	
	public HyliteLogin() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	
	/*
	 * function for logging in into hylite and clickikg on linux pool to launch it
	 *  into browser
	 */
	
	public String getHyliteLogin(String usrnm,String password)
	{
		driver.switchTo().frame(frame1);
		user.sendKeys(usrnm);
		pass.sendKeys(password);
		dropdownforad.click();
		Select dropdown = new Select(dropdownforad);
		dropdown.selectByVisibleText("rishabh_ad");
		sendlogin.click();
		String parent = driver.getWindowHandle();
		hosteddesktop.click();
		Set<String> allwindows = driver.getWindowHandles();
		
		for(String child : allwindows)
		{
			if(!parent.equalsIgnoreCase(child))
			{
				driver.switchTo().window(child);
			}
		}
		
		String pooltitle = driver.getTitle();
		driver.switchTo().window(parent);
		return pooltitle;
		
		
	}
	
	

}
