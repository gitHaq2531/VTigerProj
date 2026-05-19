package com.client.project.Product;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.client.ObjectRepository.HomePage;
import com.client.ObjectRepository.ProductPage;
import com.client.Project.packageName.BaseClass;

/**
 * 
 * 
 * author Nilam
 */
public class CreateProductTest extends BaseClass {
	@Test
	
	public void createProductTest() throws Throwable {
		
		/*step-1:read test script data from excel file*/
		String ProductName =eLib.getDataFromExcel("org", 7, 2)+jLib.getRandomNum();
		
		/*step-2:navigate to product homepage module*/
		HomePage hp=new HomePage(driver);
		hp.getProductLink().click();
		
		/*step-3: click on "create product" button*/
		ProductPage pp=new ProductPage(driver);
		pp.getCreateNewProBtn().click();
		
		/*step-4:-enter all the details and create new product using buisness method */
	    pp.createProduct(ProductName);
		
		/*step-5:verify the header as expected result*/
 		String HeaderMsg = pp.getHeadermsg().getText();
 		boolean status = HeaderMsg.contains(ProductName);
		System.out.println(HeaderMsg);
		Assert.assertEquals(status, true);
 
	}
		}
	
	
