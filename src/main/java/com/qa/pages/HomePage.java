package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase {

	
	@FindBy(xpath="//p[text()='Monitor']")
	WebElement Monitor;
	
	@FindBy(xpath="//p[text()='Users']")
	WebElement Users;
	
	@FindBy(xpath="//p[text()='Apps']")
	WebElement Apps;
	
	@FindBy(xpath="//p[text()='Devices']")
	WebElement Devices;
	
	@FindBy(xpath="//p[text()='Policies']")
	WebElement Policies;
	
	@FindBy(xpath="//p[text()='VDI']")
	WebElement vdibtn;
	
	@FindBy(xpath="//p[text()='Settings']")
	WebElement Settings;
	
	@FindBy(xpath="//p[text()='Logs']")
	WebElement Logs;
	
	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyTitleofHomepage()
	{
		return driver.getTitle();
	}
	public void monitoropen()
	{
		Monitor.click();
	}
	
	public void usersopen()
	{
		Users.click();
	}
	
	public void appsopen()
	{
		Apps.click();
	}
	
	public void devicesopen() {
		Devices.click();
	}
	
	public void policiesopen() {
		Policies.click();
	}
	
	public VdiPage vdiopen() {
		vdibtn.click();
		
		return new VdiPage();
	}
	
	public void settingsopen()
	{
		Settings.click();
	}
	
	public void Logsopen() {
		
		Logs.click();
	}
	
	
}
