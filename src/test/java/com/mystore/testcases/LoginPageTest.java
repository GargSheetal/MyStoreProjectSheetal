package com.mystore.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utilities.Log;

public class LoginPageTest extends BaseClass {
	
	IndexPage indexpage;
	LoginPage loginpage;
	HomePage homepage;
	
	@Test(groups = {"smoke", "sanity"})
	public void loginTest()
	{
		Log.startTestCase("loginTest");
		indexpage = new IndexPage();
		
		Log.info("Clicking on sign in on index page");
		loginpage = indexpage.clickSignIn();
		
		Log.info("Entering user's email and password");
		homepage = loginpage.doLogin(username, password);
		
		Log.info("Getting the title of home page after successful login");
		String actTitle = homepage.getHomePageTitle();
		String expTitle = "My account - My Store";
		
		Log.info("Verifying the actual title with expected");
		AssertJUnit.assertEquals(actTitle, expTitle);
		
		Log.info("Login is Successful");
		Log.endTestCase("loginTest");
		
	}

}
