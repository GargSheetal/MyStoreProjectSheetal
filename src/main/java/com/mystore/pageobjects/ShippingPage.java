package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class ShippingPage extends BaseClass {
	
	public ShippingPage() 
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	
	@FindBy(id = "cgv")
	WebElement termsCheckBox;
	
	@FindBy(name = "processCarrier")
	WebElement btnProceedToCheckout;
	
	
	public void selectTermsCheckbox()
	{
		termsCheckBox.click();
	}
	
	public PaymentPage clickProceedToCheckout()
	{
		btnProceedToCheckout.click();
		return new PaymentPage();
	}
	
	

}
