package com.client.project.TroubleTicket;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.client.ObjectRepository.TroubleTickePage;
import com.client.Project.packageName.BaseClass;

public class createTroubleTicketTest extends BaseClass{
	
	@Test
	public void createtroubleticketTest() throws Throwable {
		String title = eLib.getDataFromExcel("org", 22, 2) + jLib.getRandomNum();
		hp.getTroubleticketLink().click();
		
		TroubleTickePage ttp = new TroubleTickePage(driver);
		ttp.createTroubleTicket(title);
		
		String verifmsg = ttp.getHeaderMsg().getText();
		boolean status = verifmsg.contains(title);
		Assert.assertEquals(status, true);
		System.out.println(verifmsg);
	}

}
