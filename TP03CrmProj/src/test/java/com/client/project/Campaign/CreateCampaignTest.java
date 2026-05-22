package com.client.project.Campaign;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.client.ObjectRepository.CampaignPage;
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
	

}
