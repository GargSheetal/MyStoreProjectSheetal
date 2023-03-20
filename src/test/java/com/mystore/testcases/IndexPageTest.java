package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;


import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;

public class IndexPageTest extends BaseClass {
	
	IndexPage ip;
	
	@Test(groups = "smoke")
	public void verifyLogo()
	{
		ip = new IndexPage();
		boolean result = ip.validateLogo();
		Assert.assertTrue(result);
	}
	
	@Test(groups = "smoke")
	public void verifyTitle()
	{
		String title = ip.verifyTitle();
		Assert.assertTrue(title.equals("Store"));
	}

}
