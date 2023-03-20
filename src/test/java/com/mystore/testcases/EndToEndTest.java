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
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.OrderSummaryPage;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.ShippingPage;

/**
 * @author sheetal
 *
 */
public class EndToEndTest extends BaseClass{
	
	IndexPage indexpage;
	SearchResultPage search;
	AddToCartPage addtocart;
	OrderPage orderpage;
	LoginPage loginpage;
	AddressPage addpage;
	ShippingPage shippingpage;
	PaymentPage paymentpage;
	OrderSummaryPage ordersummary;
	OrderConfirmationPage orderconfirm;
	
	@Test(groups = "regression")
	public void endToEndTest()
	{
		indexpage = new IndexPage();
		indexpage.clickSignIn();
		search = indexpage.searchProduct("t-shirt");
		addtocart = search.selectProduct();
		addtocart.enterQuantity("2");
		addtocart.selectSize("M");
		addtocart.clickAddToCart();
		orderpage = addtocart.clickOnCheckout();
		loginpage = orderpage.clickOnCheckout();
		addpage = loginpage.doLoginForOrder(username, password);
		shippingpage = addpage.clickProceedToCheckout();
		shippingpage.selectTermsCheckbox();
		paymentpage = shippingpage.clickProceedToCheckout();
		ordersummary = paymentpage.selectPayByBankWire();
		orderconfirm = ordersummary.clickConfirmOrder();
		
		String actMsg = orderconfirm.verifyOrderConfirmation();
		String expMsg = "Your order on My Store is complete.";
		AssertJUnit.assertEquals(actMsg, expMsg);
	}
	

}
