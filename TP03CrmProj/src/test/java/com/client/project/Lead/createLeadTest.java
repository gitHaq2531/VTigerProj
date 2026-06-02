package com.client.project.Lead;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.client.ObjectRepository.LeadPage;
import com.client.ObjectRepository.Orgpage;
import com.client.Project.packageName.BaseClass;
/*
 * @author : Kiran
 * */
public class createLeadTest extends BaseClass{
	
	@Test
	public void createleadTest() throws Throwable {
		String lastName = eLib.getDataFromExcel("org", 4, 2)+ jLib.getRandomNum();
		String company = eLib.getDataFromExcel("org", 19, 2)+ jLib.getRandomNum();
		
		hp.getLeadslink().click();
		
		LeadPage ldp = new LeadPage(driver);
		ldp.createLead(lastName, company);
		
		String infoMsg = ldp.getInfoMsg().getText();
		boolean status = infoMsg.contains(lastName);
		Assert.assertEquals(status, true);
		
	}
	
	@Test
	public void editleadTest() throws Throwable {
		
		 hp.getLeadslink().click();
	    driver.findElement(By.id("36625")).click();
	    Orgpage op1=new Orgpage(driver);
		op1.getEditorg().click();
	  
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
		LeadPage ldp = new LeadPage(driver);
		
		String actualMsg = ldp.getEditlead().getText();

		Assert.assertTrue(actualMsg.contains("Editing Lead Information"));

		System.out.println("Edit message verified successfully");
		
	    	
	}
		
		
	}
	
	
	
	

