package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mystore.base.BaseClass;
import com.mystore.utilities.JavaScriptUtil;

public class AddToCartPage extends BaseClass {
	
	public AddToCartPage() 
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	
	@FindBy(id = "quantity_wanted")
	WebElement txtQuantity;
	
	@FindBy(id = "group_1")
	WebElement size;
	
	@FindBy(name = "Orange")
	WebElement colorOrange;
	
	@FindBy(name = "Blue")
	WebElement colorBlue;
	
	@FindBy(name = "Submit")
	WebElement btnAddToCart;
	
	@FindBy(xpath = "//span[@id='availability_value']")
	WebElement inStock;
	
	@FindBy(xpath = "//h2[normalize-space()='Product successfully added to your shopping cart']")
	public WebElement addToCartVerifivationText;
	
	@FindBy(xpath = "//span[normalize-space()='Proceed to checkout']")
	WebElement btnProceedToCheckout;
	
	
	public void enterQuantity(String quantity)
	{
		txtQuantity.clear();
		txtQuantity.sendKeys(quantity);
	}
	
	public void selectSize(String size1)
	{
		Select select = new Select(size);
		select.selectByVisibleText(size1);
	}
	
	public void clickAddToCart()
	{
		btnAddToCart.click();
	}
	
	public boolean verifyProductIsAddedToCart()
	{
		WaitforElement(addToCartVerifivationText, 10);
		return addToCartVerifivationText.isDisplayed();
	}
	
	public OrderPage clickOnCheckout() 
	{
		WaitforElement(btnProceedToCheckout, 10);
		JavaScriptUtil.clickElementByJS(btnProceedToCheckout, getDriver());
		return new OrderPage();
	}
	

}
