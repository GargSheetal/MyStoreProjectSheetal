package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class SearchResultPage extends BaseClass {
	
	public SearchResultPage() 
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	
	@FindBy(xpath = "//img[@title='Faded Short Sleeve T-shirts']")
	WebElement fadedTShirt;
	
	
	public boolean isProductAvailable()
	{
		return fadedTShirt.isDisplayed();
	}
	
	public AddToCartPage selectProduct()
	{
		fadedTShirt.click();
		return new AddToCartPage();
	}
	
	

}
