package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass {
	
	public IndexPage() {
		
		PageFactory.initElements(getDriver(), this);
	}
	
	
	@FindBy(linkText = "Sign in")
	WebElement signInLink;
	
	@FindBy(linkText = "Contact us")
	WebElement contactUsLink;
	
	@FindBy(xpath = "//img[@class='logo img-responsive']")
	WebElement logoImg;
	
	@FindBy(id = "search_query_top")
	WebElement searchTextBox;
	
	@FindBy(name = "submit_search")
	WebElement searchBtn;
	
	
	
	public LoginPage clickSignIn()
	{
		signInLink.click();
		return new LoginPage();
	}
	
	public boolean validateLogo() 
	{
		return logoImg.isDisplayed();
	}
	
	public String verifyTitle() 
	{
		return getDriver().getTitle();
	}
	
	public SearchResultPage searchProduct(String product)
	{
		searchTextBox.clear();
		searchTextBox.sendKeys(product);
		searchBtn.click();
		return new SearchResultPage();
	}

}
