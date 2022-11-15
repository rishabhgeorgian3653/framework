package com.qa.util;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.Select;

public class newpool {

	public static void main(String[] args) throws InterruptedException {
	    
	    
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();                   // SSL certificate handling
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://172.23.10.43/Admin/en-US/Account/SignIn");
		driver.findElement(By.id("usernameInputBox")).sendKeys("HyWorksAdmin");
		driver.findElement(By.id("passwordInputBox")).sendKeys("accops@123");
		driver.findElement(By.id("loginButton")).click();
		driver.findElement(By.xpath("//a[@name='applications']")).click();
		driver.findElement(By.linkText("Virtual Apps")).click();
		driver.findElement(By.id("btnAddApp")).click();
		WebElement dropdownforosplatform = driver.findElement(By.id("ApplicationPlatForm"));
		dropdownforosplatform.click();
		Select dropdown = new Select(dropdownforosplatform);
		dropdown.selectByVisibleText("Windows");
		
		WebElement appstype = driver.findElement(By.id("AppType"));
		appstype.click();
		Select dropdown1 = new Select(appstype);
		dropdown1.selectByVisibleText("Installed App");
		
		WebElement sessionteam = driver.findElement(By.id("TeamId"));
		sessionteam.click();
		Select dropdown2 = new Select(sessionteam);
		dropdown2.selectByVisibleText("Windows Default");
		
		WebElement selectrdsserver = driver.findElement(By.id("RdsTeamsServer"));
		selectrdsserver.click();
		Select dropdown3 = new Select(selectrdsserver);
		dropdown3.selectByVisibleText("RK_SHD");
		
		driver.findElement(By.id("btnBrowseFileSystem")).click();
		driver.findElement(By.xpath("//a[@name='DriveName']")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'Windows')])[2]")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'notepad.exe')])[2]")).click();
		driver.findElement(By.xpath("(//button[contains(text(),'Get details')])[2]")).click();
		driver.findElement(By.id("ApplicationName")).sendKeys("kashi_notepad");
		driver.findElement(By.id("appNext")).click();
		driver.findElement(By.id("appNext")).click();
		driver.findElement(By.xpath("((//table[@id='selectserver_WindowsDefault']//tbody//tr)[1]//td)[1]//label")).click();
		driver.findElement(By.id("appNext")).click();
		driver.findElement(By.id("appNext")).click();
		driver.findElement(By.id("addEntitlmentUsers")).click();
		driver.findElement(By.id("searchAppEntitlementAvailableString")).sendKeys("rishabh");
		driver.findElement(By.id("btnSearchEntitlmentAvailableUsers")).click();
		driver.findElement(By.xpath("((//table[@id='entitlementsusers']//tbody//tr)[1]//td)[1]//label")).click();
		driver.findElement(By.id("btnEntitlement-addUser")).click();
		driver.findElement(By.xpath("((//table[@class='table table-striped b-t b-light']//tbody//tr)[1]//td)[1]//label")).click();
		driver.findElement(By.id("appNext")).click();
		driver.findElement(By.xpath("//div[@class='text-right text-center-xs']//button[@id='SaveApp']")).click();
		
		
		
	}

}
