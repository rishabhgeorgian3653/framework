package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;

public class HyliteTestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	
	public HyliteTestBase() throws IOException
	{
		prop = new Properties();
		FileInputStream ip = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\FrameworkDesign\\src\\main\\java\\com\\qa\\config\\config.properties");
		prop.load(ip);
	}
	
	
	
	
	/*
	 * function for invoking browser and selecting browser
	 * 
	 * Handling SSL certificate
	 */
	 
	 
	
	public static void initialization()
	{
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();                       // SSL certificate handling
			options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			driver = new ChromeDriver(options);
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Admin\\Downloads\\geckodriver-v0.32.0-win32\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get(prop.getProperty("urlhylite"));
	}
	
	
	
	   /*
	    *  function for taking screenshots 
	    *  
	    */
	  
	  public String getScreenshots(String testCaseName) throws IOException {
	  TakesScreenshot ts = (TakesScreenshot)driver; File source =
	  ts.getScreenshotAs(OutputType.FILE); File file = new
	  File(System.getProperty("user.dir") + "//reports//" + testCaseName +".png");
	  FileUtils.copyFile(source, file); return System.getProperty("user.dir") +
	  "//reports//" + testCaseName +".png"; 
	  }

}
