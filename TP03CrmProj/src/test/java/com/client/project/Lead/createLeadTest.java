package com.client.project.Lead;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.client.ObjectRepository.LeadPage;
import com.client.Project.packageName.BaseClass;

public class createLeadTest extends BaseClass{
	
	@Test
	public void createleadTest() throws Throwable {
		String lastName = eLib.getDataFromExcel("org", 4, 2)+ jLib.getRandomNum();
		String company = eLib.getDataFromExcel("org", 16, 2)+ jLib.getRandomNum();
		
		hp.getLeadslink().click();
		
		LeadPage ldp = new LeadPage(driver);
		ldp.createLead(lastName, company);
		
		String infoMsg = ldp.getInfoMsg().getText();
		boolean status = infoMsg.contains(lastName);
		Assert.assertEquals(status, true);

		
	}
	
	

}
