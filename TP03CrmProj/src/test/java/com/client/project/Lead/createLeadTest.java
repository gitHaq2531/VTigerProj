package com.client.project.Lead;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
	
	/*
	 * @author : Nilam
	 * */
	@Test
	public void editleadTest() throws Throwable {
		
		 hp.getLeadslink().click();
	    driver.findElement(By.id("109916")).click();
	    Orgpage op1=new Orgpage(driver);
		op1.getEditorg().click();
		System.out.println("edited lead");
	  
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
		LeadPage ldp = new LeadPage(driver);
		
		String actualMsg = ldp.getEditlead().getText();

		Assert.assertTrue(actualMsg.contains("Editing Lead Information"));

		System.out.println("Edit message verified successfully");
		
	    	
	}
	/*
	 * @author : Nilam
	 * */
	@Test
	public void DeleteleadTest() {
		hp.getLeadslink().click();
		driver.findElement(By.id("109924")).click();
		LeadPage ldp=new LeadPage(driver);
		ldp.getDeleteLead().click();
		
		Alert alt = driver.switchTo().alert();

	    String actualPopupMsg = alt.getText();
	    System.out.println(actualPopupMsg);

	    Assert.assertTrue(actualPopupMsg.contains("Delete"),"Delete confirmation popup not displayed correctly" );
	  
	    alt.dismiss();
		
	}
	
	@Test
	public void VerifyDashboardandLeadIntergation() throws Throwable {
		hp.getLeadslink().click();
		
		String lastName = eLib.getDataFromExcel("org", 4, 2)+ jLib.getRandomNum();
		String company = eLib.getDataFromExcel("org", 19, 2)+ jLib.getRandomNum();
		
		
		LeadPage ldp = new LeadPage(driver);
		ldp.createLead(lastName, company);
		
		// Navigate to Dashboard/Home Page
	    driver.findElement(By.linkText("Dashboard")).click();
	    
	    // Open Last Viewed Widget
	    driver.findElement(By.xpath("//img[@title='Last Viewed']")).click();
	    
	    WebElement recentLead = driver.findElement(By.linkText("Singh_744"));
	    Assert.assertTrue(recentLead.isDisplayed(), "Recently created lead  displayed ");

	    // Click on recently created lead
	    recentLead.click();
	    // Verify Lead Information Page Header
	    String headerText = driver.findElement(By.className("dvHeaderText")).getText();
	    Assert.assertTrue(headerText.contains("Singh_"), "Lead name is displayed in Lead Information page header");

	    // Verify Lead Name field
	    String actualLeadName = driver.findElement(By.id("mouseArea_Last Name")).getText();
	    Assert.assertEquals(actualLeadName,"  Singh_744","Lead name verification failed");
	}
		
	}
		
		
	
	
	
	
	

