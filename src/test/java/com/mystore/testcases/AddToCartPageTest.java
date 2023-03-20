/**
 * 
 */
package com.mystore.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;

/**
 * @author sheetal
 *
 */
public class AddToCartPageTest extends BaseClass {
	
	IndexPage indexpage;
	SearchResultPage search;
	AddToCartPage addtocart;
	
	@Test(groups = {"regression", "sanity"})
	public void addToCartTest()
	{
		indexpage = new IndexPage();
		indexpage.clickSignIn();
		search = indexpage.searchProduct("t-shirt");
		addtocart = search.selectProduct();
		addtocart.enterQuantity("2");
		addtocart.selectSize("M");
		addtocart.clickAddToCart();
		boolean status = addtocart.verifyProductIsAddedToCart();
		AssertJUnit.assertTrue(status);
		
		
	}

}
