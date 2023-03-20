/**
 * 
 */
package com.mystore.dataproviders;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.mystore.utilities.XLUtils;

/**
 * @author sheetal
 *
 */

public class DataProviders {
	
	@DataProvider(name = "productData")
	public Object[][] getProductData() throws IOException 
	{
		String path = "./src/test/resources/TestData/TestData.xlsx"; // specifying the path of the xls data sheet
		
		int rownum = XLUtils.getRowCount(path, "ProductDetails");
		int colcount = XLUtils.getCellCount(path, "ProductDetails", 1);
		
		Object[][] productdata = new Object[rownum][colcount];
		
		for(int i=1; i<=rownum; i++)
		{
			for(int j=0; j<colcount; j++)
			{
				productdata[i-1][j] = XLUtils.getCellData(path, "ProductDetails", i, j);
			}
		}
		return productdata;
	}

}
