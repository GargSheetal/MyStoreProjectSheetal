package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class OrderConfirmationPage extends BaseClass {
	
	public OrderConfirmationPage() 
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	
	@FindBy(xpath = "(//p[@class='alert alert-success'])[1]")
	WebElement orderConfirmationMsg;
	
	
	public String verifyOrderConfirmation()
	{
		return orderConfirmationMsg.getText();	
	}

}
