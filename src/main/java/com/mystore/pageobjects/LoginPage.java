package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class LoginPage extends BaseClass {
	
	public LoginPage() 
		{
			PageFactory.initElements(getDriver(), this);
		}
	
	
	@FindBy(id = "email")
	WebElement txtUserName;
	
	@FindBy(id = "passwd")
	WebElement txtPassword;
	
	@FindBy(id = "SubmitLogin")
	WebElement signInBtn;
	
	@FindBy(id = "email_create")
	WebElement txtCreateUserName;
	
	@FindBy(id = "SubmitCreate")
	WebElement createAccBtn;
	
	@FindBy(linkText = "Forgot your password?")
	WebElement forgotPasswordLink;
	
	
	public HomePage doLogin(String user, String pwd) 
	{
		txtUserName.sendKeys(user);
		txtPassword.sendKeys(pwd);
		signInBtn.click();
		return new HomePage();
	}
	
	public AddressPage doLoginForOrder(String user, String pwd) 
	{
		txtUserName.sendKeys(user);
		txtPassword.sendKeys(pwd);
		signInBtn.click();
		return new AddressPage();
	}
	
	public CreateAccountPage createNewAccount(String newEmail)
	{
		txtCreateUserName.sendKeys(newEmail);
		createAccBtn.click();
		return new CreateAccountPage();
	}
	

}
