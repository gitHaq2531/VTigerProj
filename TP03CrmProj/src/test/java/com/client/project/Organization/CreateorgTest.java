package com.client.project.Organization;

import org.testng.annotations.Test;

import com.client.ObjectRepository.HomePage;
import com.client.ObjectRepository.Orgpage;
import com.client.Project.packageName.BaseClass;


/**
 * 
 * 
 * author Nilam
 */

public class CreateorgTest extends BaseClass {
	@Test
	public void createOrgTest() {
				
		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();

		Orgpage op1=new Orgpage(driver);
	  	op1.getCreateNewOrgBtn().click();
	
	}
		
}
