package com.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.LoginPage;
import com.qa.pages.UserSession;

public class UserSessionTest extends TestBase {
	
	UserSession usersession;
	LoginPage loginpage;
	

	public UserSessionTest() throws IOException {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() throws IOException    
	{
		initialization();
		usersession = new UserSession();
		loginpage = new LoginPage();
	}
	
	
	/*
	 *  function to validate whether user is active or not active 
	 *  
	 */
	
	@Test
	public void isActiveUserSession() throws IOException
	{
		loginpage.setLoginIntoHyWorks(prop.getProperty("username"), prop.getProperty("password"));
		String [] details = usersession.getUserSessionDetails();
		System.out.println(details[0]);
		System.out.println(details[1]);
		boolean flag = false;
		if(details[0].equals("rishabh1") && details[1].equals("Active"))
		{
			flag = true;
		}
		
		Assert.assertEquals(flag, true);
			
	}
	
	
	
	/*
	 *  function to validate whether desktop pool is connected or not connected 
	 *  
	 */
	
	@Test
	public void isConnectedToDesktop() throws IOException
	{
		loginpage.setLoginIntoHyWorks(prop.getProperty("username"), prop.getProperty("password"));
		String [] desktopdetails = usersession.getDesktopSessionDetails();
		System.out.println(desktopdetails[0]);
		System.out.println(desktopdetails[1]);
		boolean flag1 = false;
		if(desktopdetails[0].equals("RK_POOL_LINUX") && desktopdetails[1].equals("Desktop Connected"))
		{
			flag1 = true;
		}
		
		Assert.assertEquals(flag1, true);
	}
	
	
	
	
	@AfterMethod
	public void teardown() 
	{
		driver.quit();
	}
	

}
