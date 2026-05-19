package com.client.project.Contact;

import org.testng.Assert;
import org.testng.annotations.Test;


import com.client.ObjectRepository.ContactPage;
import com.client.Project.packageName.BaseClass;

/*
 * @author : Kiran
 * */

public class CreateContactTest extends BaseClass{
	@Test
	public void createContactTest() throws Throwable {
		String lastName = eLib.getDataFromExcel("org", 4, 2)+jLib.getRandomNum();
		System.out.println(lastName);
		hp.getContactLink().click();
		
		ContactPage cp = new ContactPage(driver);
		cp.createContact(lastName);
		
		String headerMsg = cp.getHeaderMsg().getText();
		boolean status = headerMsg.contains(lastName);
		Assert.assertEquals(status, true);
		System.out.println(status);
		
		
	}
	
	@Test
	public void createContactWithOrgTest() throws Throwable {
		String lastName = eLib.getDataFromExcel("org", 4, 2)+jLib.getRandomNum();
		String orgName =eLib.getDataFromExcel("org", 1, 2)+jLib.getRandomNum();
		
		hp.getContactLink().click();
		
		ContactPage cp = new ContactPage(driver);
		cp.createContactwithOrg(lastName);
		
		String doneMsg = cp.getHeaderMsg().getText();
		boolean status = doneMsg.contains(lastName);
		Assert.assertEquals(status, true);
		System.out.println(status);
	

		
	}
	
	

}
