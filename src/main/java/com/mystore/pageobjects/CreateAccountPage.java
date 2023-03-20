package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class CreateAccountPage extends BaseClass {
	
	public CreateAccountPage() 
	{
		PageFactory.initElements(getDriver(), this);
	}


	@FindBy(xpath = "(//h1[normalize-space()='Create an account'])[1]")
	WebElement createAccountHeading;
	
	@FindBy(id = "id_gender1")
	WebElement radioBtnMr;
	
	@FindBy(id = "id_gender2")
	WebElement radioBtnMrs;
	
	@FindBy(id = "customer_firstname")
	WebElement txtFirstName;
	
	@FindBy(id = "customer_lastname")
	WebElement txtlastName;
	
	@FindBy(id = "passwd")
	WebElement txtPassword;
	
	@FindBy(id = "submitAccount")
	WebElement btnRegister;
	
	
	
	public boolean validateCreateAccountPage()
	{
		return createAccountHeading.isDisplayed();
	}

}
