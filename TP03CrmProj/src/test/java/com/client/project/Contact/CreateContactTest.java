package com.client.project.Contact;

import org.testng.annotations.Test;

import com.client.ObjectRepository.HomePage;
import com.client.Project.packageName.BaseClass;

/*
 * @author : Kiran
 * */

public class CreateContactTest extends BaseClass{
	@Test
	public void createContactTest() {
		HomePage hp = new HomePage(driver);
		hp.getContactLink();
		
		
	}
	
	

}
