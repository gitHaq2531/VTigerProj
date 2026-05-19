package com.client.project.Organization;

import org.testng.Assert;
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
	public void createOrgTest() throws Throwable {
		
		String orgName =eLib.getDataFromExcel("org", 1, 2)+jLib.getRandomNum();
				
		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();
		
	
		Orgpage op=new Orgpage(driver);
	  	op.getCreateNewOrgBtn().click();
	  	op.createOrg(orgName);
	    //op.getStreetEdt().sendKeys("Mumbai");
	    
  		//String actOrgName = op.getHeadermsg().getText();
//  		if(actOrgName.equals(orgName)) {
//  			System.out.println(orgName+"name is verified==PASS");
//  		}else {
//  			System.out.println(orgName+"name is not verified==FAIL");
//  		      }
  		
  		String FB  = op.getHeadermsg().getText();
		System.out.println(FB);
		Assert.assertEquals("FB","fb1");
  		hp.logout();
  		
  		
   }


		
	
	}

		

