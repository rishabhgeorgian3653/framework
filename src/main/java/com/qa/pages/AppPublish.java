package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;
import com.qa.util.ExtentReporterNG;

public class AppPublish extends TestBase {
	
	
	
	@FindBy(xpath="//a[@name='applications']")
	WebElement apps;
	
	@FindBy(linkText="Virtual Apps")
	WebElement virtualapps;
	
	@FindBy(id="btnAddApp")
	WebElement addapp;
	
	@FindBy(id="ApplicationPlatForm")
	WebElement applicationplatform;
	
	@FindBy(id="AppType")
	WebElement applicationtype;
	
	@FindBy(id="TeamId")
	WebElement sessionteam;
	
	@FindBy(id="RdsTeamsServer")
	WebElement selectrdsserver;
	
	@FindBy(id="btnBrowseFileSystem")
	WebElement filesystem;
	
	@FindBy(xpath="//a[@name='DriveName']")
	WebElement drivename;
	
	@FindBy(xpath="(//a[contains(text(),'Windows')])[2]")
	WebElement clickonfolder;
	
	@FindBy(xpath="(//a[contains(text(),'notepad.exe')])[2]")
	WebElement gettingapp;
	
	@FindBy(xpath="(//button[contains(text(),'Get details')])[2]")
	WebElement getdetailsbtn;
	
	@FindBy(id="ApplicationName")
	WebElement addappdisplayname;
	
	@FindBy(id="appNext")
	WebElement nextbtn;
	
	@FindBy(id="addEntitlmentUsers")
	WebElement addentitlement;
	
	@FindBy(xpath="((//table[@id='selectserver_WindowsDefault']//tbody//tr)[1]//td)[1]//label")
	WebElement selectserverandteam;
	
	@FindBy(id="searchAppEntitlementAvailableString")
	WebElement searchavailableusers;
	
	@FindBy(id="btnSearchEntitlmentAvailableUsers")
	WebElement searchbtn;
	
	@FindBy(xpath="((//table[@id='entitlementsusers']//tbody//tr)[1]//td)[1]//label")
	WebElement entitlementusers;
	
	@FindBy(id="btnEntitlement-addUser")
	WebElement okbtn;
	
	@FindBy(xpath="((//table[@class='table table-striped b-t b-light']//tbody//tr)[1]//td)[1]//label")
	WebElement adduser;
	
	@FindBy(xpath="//div[@class='text-right text-center-xs']//button[@id='SaveApp']")
	WebElement savebtn;
    
	@FindBy(xpath="//table[@class='table hostedapplicationrow b-light']//tbody//tr//td[3]//span[text()=' RK_NOTEPAD']")
	WebElement checkappname;
	
	
	public AppPublish() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public void getAppPublish()
	{
		extentreportlog = new ExtentReporterNG();
		apps.click();
		virtualapps.click();
		addapp.click();
		
		applicationplatform.click();
		Select dropdown = new Select(applicationplatform);
		dropdown.selectByVisibleText("Windows");
		
		applicationtype.click();
		Select dropdown1 = new Select(applicationtype);
		dropdown1.selectByVisibleText("Installed App");
		
		sessionteam.click();
		Select dropdown2 = new Select(sessionteam);
		dropdown2.selectByVisibleText("Windows Default");
		
		selectrdsserver.click();
		Select dropdown3 = new Select(selectrdsserver);
		dropdown3.selectByVisibleText("RK_SHD");
		
		filesystem.click();
		drivename.click();
		clickonfolder.click();
		gettingapp.click();
		getdetailsbtn.click();
		addappdisplayname.sendKeys(prop.getProperty("applicationname"));
		nextbtn.click();
		nextbtn.click();
		selectserverandteam.click();
		nextbtn.click();
		nextbtn.click();
		addentitlement.click();
		searchavailableusers.sendKeys("rishabh");
		searchbtn.click();
		entitlementusers.click();
		okbtn.click();
		adduser.click();
		nextbtn.click();
		savebtn.click();	
		
	}
	
	public String getAppName()
	{
		return checkappname.getText();
	}
	

}
