package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class HomePage extends BaseClass {
	
	public HomePage() 
	{
		PageFactory.initElements(getDriver(), this);
	}


	@FindBy(xpath = "//span[text()='Order history and details']")
	WebElement linkOrderHistory;
	
	@FindBy(xpath = "//span[text()='Add my first address']")
	WebElement linkAddMyFirstAdd;
	
	@FindBy(xpath = "//span[text()='My credit slips']")
	WebElement linkMyCreditSlips;
	
	@FindBy(xpath = "//span[text()='My addresses']")
	WebElement linkMyAddresses;
	
	@FindBy(xpath = "//span[text()='My personal information']")
	WebElement linkMyPersonalInfo;
	
	@FindBy(xpath = "(//p[@class='info-account'])[1]")
	WebElement welcomeMsg;

	
	public boolean validateOrderHistory()
	{
		WaitforElement(linkOrderHistory, 10);
		return linkOrderHistory.isDisplayed();
	}
	
	public boolean validateAddMyFirstAddress()
	{
		WaitforElement(linkAddMyFirstAdd, 10);
		return linkAddMyFirstAdd.isDisplayed();
	}
	
	public boolean validateMyCreditSlips()
	{
		WaitforElement(linkMyCreditSlips, 10);
		return linkMyCreditSlips.isDisplayed();
	}
	
	public boolean validateMyAddresses()
	{
		WaitforElement(linkMyAddresses, 10);
		return linkMyAddresses.isDisplayed();
	}
	
	public boolean validateMyPersonalInfo()
	{
		WaitforElement(linkMyPersonalInfo, 10);
		return linkMyPersonalInfo.isDisplayed();
	}
	
	public String verifyWecomeMsg()
	{
		return welcomeMsg.getText();
	}
	
	public String getHomePageTitle()
	{
		return getDriver().getTitle();
	}
	
	
	
	
	
	
	

}
