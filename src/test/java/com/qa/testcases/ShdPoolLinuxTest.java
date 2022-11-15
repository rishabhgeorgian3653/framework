package com.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.LoginPage;
import com.qa.pages.ShdPoolLinux;

public class ShdPoolLinuxTest extends TestBase {
	
	ShdPoolLinux shdpool;
	LoginPage loginpage;

	public ShdPoolLinuxTest() throws IOException {
		super();

	}
	
	
	/*
	 *  before any method it will initiate browser invoking and hitting the url 
	 *  
	 */

	@BeforeMethod
	public void setUp() throws IOException    
	{
		initialization();
		shdpool = new ShdPoolLinux();
		loginpage = new LoginPage();
	}
	
	
	/*
	 * function for validation of created pool
	 * 
	 * by using the created pool name
	 * 
	 * by extracting text from display name and comparing it with 
	 */
	
	@Test
	public void isLinuxShdPoolGenerated() throws IOException, InterruptedException
	{
		    loginpage.setLoginIntoHyWorks(prop.getProperty("username"), prop.getProperty("password"));
			shdpool.addingSHDpool();
			String poolstatus = shdpool.isPoolGenerated();
			System.out.println(poolstatus);
			Assert.assertEquals(poolstatus, prop.getProperty("linuxpoolname"));
		
	}
	
	/*
	 * 
	 *  after every method it will close the browser 
	 *  
	 */
	
	@AfterMethod
	public void teardown() 
	{
		driver.quit();
	}

}
