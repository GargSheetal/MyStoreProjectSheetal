package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class OrderPage extends BaseClass {
	
	public OrderPage() 
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	
	@FindBy(xpath = "(//li[@class='price'])[1]")
	WebElement unitPrice;
	
	@FindBy(id = "total_shipping")
	WebElement totalShipping;
	
	@FindBy(id = "total_price")
	WebElement totalPrice;
	
	@FindBy(xpath = "//span[text()='Proceed to checkout']")
	WebElement btnProceedToCheckout;
	
	
	public double getUnitPrice()
	{
		String price = unitPrice.getText();
		//replacing $ in the price with empty string. This method will also remove the decimal also. So divide the finalUnitPrice with 100
		String unitprice = price.replaceAll("[^a-zA-Z0-9]", "");
		double finalUnitPrice = Double.parseDouble(unitprice);
		return finalUnitPrice/100;
	}
	
	public double getTotalPrice()
	{
		String totalprice = totalPrice.getText();
		//replacing $ in the price with empty string. This method will also remove the decimal also. So divide the finalUnitPrice with 100
		String totalPri = totalprice.replaceAll("[^a-zA-Z0-9]", "");
		double finalTotalPrice = Double.parseDouble(totalPri);
		return finalTotalPrice/100;
	}
	
	public LoginPage clickOnCheckout() 
	{
		btnProceedToCheckout.click();
		return new LoginPage();
	}
	
	

}
