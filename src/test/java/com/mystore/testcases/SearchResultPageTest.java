package com.mystore.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;

public class SearchResultPageTest extends BaseClass {
	
	IndexPage indexpage;
	SearchResultPage search;
	
	@Test(groups = "smoke")
	public void verifyProductSearch() throws InterruptedException
	{
		indexpage = new IndexPage();
		search = indexpage.searchProduct("t-shirt");
		boolean result = search.isProductAvailable();
		AssertJUnit.assertTrue(result);
		
	}
	

}
