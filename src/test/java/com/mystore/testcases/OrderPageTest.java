/**
 * 
 */
package com.mystore.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataproviders.DataProviders;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;

/**
 * @author sheetal
 *
 */
public class OrderPageTest extends BaseClass {
	
	IndexPage indexpage;
	SearchResultPage search;
	AddToCartPage addtocart;
	OrderPage orderpage;
	
	@Test(groups = "regression", dataProvider = "productData", dataProviderClass = DataProviders.class)
	public void verifyTotalPriceTest(String product, String qty, String size) throws InterruptedException
	{
		indexpage = new IndexPage();
		indexpage.clickSignIn();
		search = indexpage.searchProduct(product);
		addtocart = search.selectProduct();
		addtocart.enterQuantity(qty);
		addtocart.selectSize(size);
		addtocart.clickAddToCart();
		orderpage = addtocart.clickOnCheckout();
		double unitprice = orderpage.getUnitPrice();
		double totalprice = orderpage.getTotalPrice();
		double expTotalPrice = ((unitprice * Double.parseDouble(qty)) + 7);
		System.out.println(expTotalPrice);
		AssertJUnit.assertEquals(totalprice, expTotalPrice);
	}

}
