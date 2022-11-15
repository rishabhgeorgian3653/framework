package com.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.AppPublish;
import com.qa.pages.LoginPage;

public class AppPublishTest extends TestBase{
	
	LoginPage loginpage;
	AppPublish apppublish;

	public AppPublishTest() throws IOException {
		
		super();
	}
	
	
	
	
	@BeforeMethod
	public void setUp() throws IOException    
	{
		initialization();
	    loginpage = new LoginPage();
	    apppublish = new AppPublish();
	}
	
	
	@Test
	public void isAppPublished() throws IOException
	{
		loginpage.setLoginIntoHyWorks(prop.getProperty("username"), prop.getProperty("password"));
		apppublish.getAppPublish();
		String appname = apppublish.getAppName();
		System.out.println(appname);
		Assert.assertEquals(appname, prop.getProperty("applicationname"));
	}
	
	
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	

}
