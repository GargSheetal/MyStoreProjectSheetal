package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class OrderSummaryPage extends BaseClass{
	
	public OrderSummaryPage() 
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	
	@FindBy(xpath = "//span[text()='I confirm my order']")
	WebElement btnConfirmOrder;
	
	
	public OrderConfirmationPage clickConfirmOrder()
	{
		btnConfirmOrder.click();
		return new OrderConfirmationPage();
	}

}
