package com.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class HomepageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	
	public HomepageTest() throws IOException {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		initialization();
	    loginpage = new LoginPage();
	    homepage = loginpage.setLoginIntoHyWorks(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test
	public void verifyHomepageTitleTest()
	{
		String homepagetitle = homepage.verifyTitleofHomepage();
		Assert.assertEquals(homepagetitle,"Accops HyWorks Management Console", "homepage title not matched");
	}
	
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
