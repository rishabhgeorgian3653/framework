package com.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.HyliteTestBase;
import com.qa.pages.HyliteLogin;

public class HyliteLoginTest extends HyliteTestBase {
	
	HyliteLogin hylitelogin;
	

	public HyliteLoginTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException    
	{
		initialization();
	    hylitelogin = new HyliteLogin();
	}
	

	@Test
	public void isHyliteLogin()
	{
	   String title =  hylitelogin.getHyliteLogin(prop.getProperty("hyliteusername"),prop.getProperty("hylitepassword"));
	   Assert.assertEquals(title, prop.getProperty("linuxpoolname"));
	}
	

	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
