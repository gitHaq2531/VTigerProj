package com.client.project.Campaign;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.client.ObjectRepository.CampaignPage;
import com.client.ObjectRepository.Orgpage;
import com.client.Project.packageName.BaseClass;

public class CreateCampaignTest extends BaseClass {
	
	@Test
	public void createCampaigntest() throws Throwable {
		String campaignName = eLib.getDataFromExcel("org", 25, 2) + jLib.getRandomNum();
		
		hp.getMorelink().click();
		hp.getCampaignlink().click();
		
		CampaignPage cmp = new CampaignPage(driver);
		cmp.createCampaign(campaignName);
		
		String headerMsg = cmp.getHeaderInfo().getText();
		boolean status = headerMsg.contains(campaignName);
		System.out.println(headerMsg);
		Assert.assertEquals(status, true);
		
	}
	
    @Test
    
    public void editCampaignTest() {
    	hp.getMorelink().click();
		hp.getCampaignlink().click();
		
    	driver.findElement(By.id("110895")).click();
    	Orgpage op=new Orgpage(driver);
		op.getEditorg().click();
		
		CampaignPage cmp = new CampaignPage(driver);
		String actualMsg = cmp.getEditheaderInfocampaign().getText();

	Assert.assertTrue(actualMsg.contains("Editing Campaign Information"));

	System.out.println("Edit message verified successfully");
	
    	
    }
 
	

}


