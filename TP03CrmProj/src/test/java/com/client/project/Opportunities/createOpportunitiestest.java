package com.client.project.Opportunities;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.client.ObjectRepository.OpportunitiesPage;
import com.client.Project.packageName.BaseClass;

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
		
	}

}
