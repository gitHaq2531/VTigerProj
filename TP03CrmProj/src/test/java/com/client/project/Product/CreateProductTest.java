package com.client.project.Product;

import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.client.ObjectRepository.HomePage;
import com.client.ObjectRepository.InvoicePage;
import com.client.ObjectRepository.ProductPage;
import com.client.ObjectRepository.SalesOrderPage;
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
	
	@Test
	
	public void CreateInvoiceWithProduct()throws Throwable {
		
		/*read test script data from excel file*/
		String ProductName =eLib.getDataFromExcel("org", 7, 2)+jLib.getRandomNum();
		
		/*navigate to product homepage module*/
		HomePage hp=new HomePage(driver);
		hp.getProductLink().click();
		
		/* click on "create product" button*/
		ProductPage pp=new ProductPage(driver);
		pp.getCreateNewProBtn().click();
		
		/*enter all the details and create new product using buisness method */
	    pp.createProduct(ProductName);
	   
	    
	    /*invoice page details*/
		String InvName =eLib.getDataFromExcel("org", 16, 2)+jLib.getRandomNum();
		
		InvoicePage ip=new InvoicePage(driver);
		ip.getInvoicLink().click();
		ip.CreateInvoice(InvName);
		
	}
	
	@Test
	public void CreateSalesOrder() throws Throwable {
		String ProductName =eLib.getDataFromExcel("org", 7, 2)+jLib.getRandomNum();
		hp.getProductLink().click();
		
		ProductPage pp=new ProductPage(driver);
		pp.getCreateNewProBtn().click();
		
		 pp.createProduct(ProductName);
		 
		 /*salesorder page details*/
	
	String Subject =eLib.getDataFromExcel("org", 24, 2)+jLib.getRandomNum();
			
		  SalesOrderPage sop=new SalesOrderPage(driver);
		  sop.getCreatesalesorder().click();
		  sop.createSales(Subject);
		  

		  String headerMsg = sop.getHeadermsg().getText();
		  System.out.println(headerMsg);
		  Assert.assertTrue(headerMsg.contains(Subject), "Sales Order was not created successfully");
		  	
	}	
	}
	
		

	
	
