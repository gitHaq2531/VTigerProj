package com.client.project.Opportunities;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.client.ObjectRepository.CampaignPage;
import com.client.ObjectRepository.OpportunitiesPage;
import com.client.ObjectRepository.Orgpage;
import com.client.Project.packageName.BaseClass;
/*
 * @author : Kiran
 * */
public class createOpportunitiestest extends BaseClass{
	
	@Test
	public void createOpportunitiesTest() throws Throwable {
		
		String OppName = eLib.getDataFromExcel("org", 13, 2)+ jLib.getRandomNum();
		hp.getOpportunityLink().click();
		
		OpportunitiesPage op = new OpportunitiesPage(driver);
		op.createOpportunities(OppName);
		
		String actMsg = op.getHeaderMSG().getText();
		boolean status = actMsg.contains(OppName);
		Assert.assertEquals(status, true);
		System.out.println(status);
		System.out.println("updated");
		System.out.println("updated2");
			
		}
	@Test
	public void createOpportunitiesWithCamapignTest() throws Throwable {
		String OppName = eLib.getDataFromExcel("org", 13, 2)+ jLib.getRandomNum();
		hp.getOpportunityLink().click();
		
		OpportunitiesPage op = new OpportunitiesPage(driver);
		op.createOpportunitiesWithCampaign(OppName);
		
		String actMsg = op.getHeaderMSG().getText();
		boolean status = actMsg.contains(OppName);
		Assert.assertEquals(status, true);
		System.out.println(actMsg);
			
	}
	
	 @Test
	    
	    public void editOpportunityTest() {
		 hp.getOpportunityLink().click();
			
	    	driver.findElement(By.id("62044")).click();
	    	Orgpage op1=new Orgpage(driver);
			op1.getEditorg().click();
		
			OpportunitiesPage op = new OpportunitiesPage(driver);
			
			String actualMsg = op.getEditheaderInfoOpprtunity().getText();

		Assert.assertTrue(actualMsg.contains("Editing Opportunity Information"));

		System.out.println("Edit message verified successfully");
		
	    	
	    }
		
	}


