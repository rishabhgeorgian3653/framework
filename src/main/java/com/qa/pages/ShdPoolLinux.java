package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;

public class ShdPoolLinux extends TestBase {
	
	
LoginPage loginpage;
	
	@FindBy(name="desktopsVMs")
	WebElement vdibtn;
	
	@FindBy(id="desktoppool")
	WebElement pool;
	
	@FindBy(xpath="//span[text()='Add New Pool']")
	WebElement addnewpool;
	
	@FindBy(id="BasicPoolInfo_Name")
	WebElement poolname;
	
	@FindBy(id="BasicPoolInfo_DisplayName")
	WebElement displayname;
	
	@FindBy(xpath="//*[@id=\"userbasetypePools\"]/span/label")
	WebElement userbased;
	
	@FindBy(id="BasicPoolInfo_SelectedTeam")
	WebElement dropdownforos;
	
	@FindBy(id="nexttabTop")
	WebElement next;
	
	@FindBy(id="addUsers")
	WebElement addusers;
	
	@FindBy(id="availableUserForDesktoPool_id")
	WebElement searchkey;
	
	@FindBy(id="btnSearchAvailableUsers")
	WebElement availableusers;
	
	@FindBy(xpath="//div[@id='divAvailableUsersGrid']//table[@name='poolslistpopuptable']//th[@class='width50 text-center UserTableCheck']")
	WebElement chekboxtoaddavailableuser;
	
	@FindBy(id="btn-addUser")
	WebElement okbtntoadduser;
	
	@FindBy(xpath="((//table[@id='tblSelectedUsers']//tbody//tr)[1]//td)[1]")
	WebElement chekboxtoaddselecteduser;
	
	@FindBy(id="desktopPoolsModalFinishBtnTop")
	WebElement finishbtn;
	
	@FindBy(className="desktoppoolsiffyTip")
	WebElement checkingpoolname;
	


	public ShdPoolLinux() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	
	/*
	 * function for adding Linux shared hosted desktop pool
	 *  
	 * assigning to active directory user
	 */
	

	public void addingSHDpool() throws IOException, InterruptedException {
				vdibtn.click();
				pool.click();
				addnewpool.click();
				poolname.sendKeys(prop.getProperty("linuxpoolname"));
				displayname.click();
				userbased.click();	
				Select dropdown = new Select(dropdownforos);
				dropdown.selectByIndex(1);
				dropdown.getFirstSelectedOption().click();
				next.click();
				addusers.click();
				searchkey.sendKeys("rishabh");
				availableusers.click();
				chekboxtoaddavailableuser.click();
				okbtntoadduser.click();
				chekboxtoaddselecteduser.click();
				next.click();
				next.click();
				next.click();
				finishbtn.click();	
		
	}
	
	
	/* 
	 * function to extract text from display name of Linux shd pool
	 * 
	 */
	
	 public String isPoolGenerated() { 
		 
		return checkingpoolname.getText();
	 }
	 
	 
	

}
