package com.mystore.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.CreateAccountPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class CreateAccountPageTest extends BaseClass {
	
	IndexPage indexpage;
	LoginPage loginpage;
	CreateAccountPage createacct;
	
	@Test(groups = "sanity")
	public void verifyCreateAccountPageIsLaunched() throws InterruptedException
	{
		indexpage = new IndexPage();
		loginpage = indexpage.clickSignIn();
		createacct = loginpage.createNewAccount("abc123@gmail.com");
		boolean status = createacct.validateCreateAccountPage();
		System.out.println(status);
		AssertJUnit.assertTrue(status);
		
	}

}
