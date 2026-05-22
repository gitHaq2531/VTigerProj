package com.client.project.Organization;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
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
		
		/*step-1:read test script data from excel file*/
		String orgName =eLib.getDataFromExcel("org", 1, 2)+jLib.getRandomNum();
		
		/*step-2:navigate to organization homepage module*/
		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();
		

	  	/*step-3: click on "create organization" button*/
		Orgpage op=new Orgpage(driver);
	  	op.getCreateNewOrgBtn().click();
	  	
	  	 /*step-4:-enter all the details and create new organization using buisness method*/
	  	op.createOrg(orgName);
	    
	  	/*step-5:verify the header as expected result*/
 		String HeaderMsg = op.getHeadermsg().getText();
 		boolean status = HeaderMsg.contains(orgName);
		System.out.println(HeaderMsg);
		Assert.assertEquals(status, true);
  		
   }
	@Test
	public void editOrg() throws Throwable {
		
		hp.getOrgLink().click();
		
		driver.findElement(By.id("40922")).click();
		
		Orgpage op=new Orgpage(driver);
		op.getEditorg().click();
		
	     String actualMsg = op.getHeaderOrgEdit().getText().trim();
	       Assert.assertTrue( actualMsg.contains("Editing Organization Information"));
       
	    System.out.println("Edit message verified successfully");
 	
	}
	  	
	
	@Test
	public void quickcreatewithorg() throws Throwable {
		hp.getQuickcreateLink().click();
		WebElement dd = driver.findElement(By.id("qccombo"));
		Select sel =new Select(dd);
		sel.selectByVisibleText("New Organization");
		Thread.sleep(2000);
		
		String orgName =eLib.getDataFromExcel("org", 1, 2)+jLib.getRandomNum();
		Orgpage op=new Orgpage(driver);
		op.createOrg(orgName);
		
		String HeaderMsg = op.getHeadermsg().getText();
 		boolean status = HeaderMsg.contains(orgName);
		System.out.println(HeaderMsg);
		Assert.assertEquals(status, true);
		
		
	}
	
}
	
	


		

