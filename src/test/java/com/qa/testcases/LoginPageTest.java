package com.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.LoginPage;
import com.qa.util.excelData;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	
	
	public LoginPageTest() throws IOException {
		
		super();	
	}
	
	
	/* 
	 * Used data provider and also fetched data from excel here 
	 */

	@DataProvider (name = "data-provider")  
    public Object[][] dpMethod() throws IOException{
		 excelData read = new excelData("C:\\Users\\Admin\\eclipse-workspace\\FrameworkDesign\\src\\main\\java\\com\\qa\\testdata\\userdetails1.xlsx");
		 int row = read.getRowCount();
		 int column = read.getColumnCount();
		 Object Data[][] = new Object[row][column];
		 
		 Data = read.getData();
		 
		 return Data;
    }
   
	
	/* 
	 * 
	 * before any method it will initiate browser invoking and hitting the url
	 * 
	 */
	
	@BeforeMethod
	public void setUp() throws IOException    
	{
		initialization();
	    loginpage = new LoginPage();
	}
	
	
	
	/* 
	 * validating login page Title 
	 * 
	 */
	
	@Test(priority=1)
	public void isValidLoginPageTitle()
	{
		String title = loginpage.getLoginpageTitle();
		Assert.assertEquals(title, "Admin Login");
	}
	
	
	/*
	 * validating login into HyWorks management console with the help of the title of page
	 * 
	 * giving priority to every method
	 */
	
	@Test(priority=2, dataProvider="data-provider") 
	public void isValidLogin(String usrname,String pasWord) throws IOException    
	{
		loginpage.setLoginIntoHyWorks(usrname, pasWord);
		String title1 = loginpage.getLoginpageTitle();
		Assert.assertEquals(title1, "Accops HyWorks Management Console");
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
}
