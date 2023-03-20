package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class PaymentPage extends BaseClass {
	
	public PaymentPage() 
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	
	@FindBy(xpath = "//a[@title='Pay by bank wire']")
	WebElement payByBankWire;
	
	@FindBy(xpath = "//a[@title='Pay by check.']")
	WebElement payByCheck;
	
	
	public OrderSummaryPage selectPayByBankWire()
	{
		payByBankWire.click();
		return new OrderSummaryPage();
	}
	
	public OrderSummaryPage selectPayByCheck()
	{
		payByCheck.click();
		return new OrderSummaryPage();
	}

}
