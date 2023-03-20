package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.mystore.base.BaseClass;

public class AddressPage extends BaseClass {

	public AddressPage() 
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	
	@FindBy(name = "processAddress")
	WebElement btnProceedToCheckout;
	
	@FindBy(id = "addressesAreEquals")
	WebElement checkboxSameAddress;
	
	
	public boolean verifyCheckBoxForDeliveryIsSelected()
	{
		return checkboxSameAddress.isSelected();
	}
	
	public ShippingPage clickProceedToCheckout()
	{
		btnProceedToCheckout.click();
		return new ShippingPage();
	}
	
	
	
}
