package com.mystore.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class HomePageTest extends BaseClass{

	IndexPage indexpage;
	LoginPage loginpage;
	HomePage homepage;
	
	@Test(groups = "smoke")
	public void verifyWelcomeMsg()
	{
		indexpage = new IndexPage();
		loginpage = indexpage.clickSignIn();
		
		homepage = loginpage.doLogin(username, password);
		
		String actWelcomeMsg = homepage.verifyWecomeMsg();
		System.out.println(actWelcomeMsg);
		String expWelcomeMsg = "Welcome to your account. Here you can manage all of your personal information and orders.";
		AssertJUnit.assertEquals(actWelcomeMsg, expWelcomeMsg);
	}
	
	@Test(groups = "smoke")
	public void verifyOrderHistoryIsDisplayed()
	{
		indexpage = new IndexPage();
		loginpage = indexpage.clickSignIn();
		
		homepage = loginpage.doLogin(username, password);
		boolean status = homepage.validateOrderHistory();
		AssertJUnit.assertTrue(status);
	}
	
	@Test(groups = "smoke")
	public void verifyMyAddressesIsDisplayed()
	{
		indexpage = new IndexPage();
		loginpage = indexpage.clickSignIn();
		
		homepage = loginpage.doLogin(username, password);
		boolean status = homepage.validateMyAddresses();
		AssertJUnit.assertTrue(status);
	}
	
	
	
}
