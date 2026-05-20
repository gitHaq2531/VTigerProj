package com.client.project.Document;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.client.ObjectRepository.Docpage;
import com.client.Project.packageName.BaseClass;

/**
 * 
 * 
 * author Nilam
 */
public class CreateDocTest extends BaseClass {
	@Test
	public void createDocTest() throws Throwable {
		/*step-1:read test script data from excel file*/
		String DocName=eLib.getDataFromExcel("org", 10, 2)+jLib.getRandomNum();
		hp.getDocLink().click();
		
		Docpage dp=new Docpage(driver);
		dp.getCreateDoc().click();
		
		dp.createDoc(DocName);
		
		String HeaderMsg = dp.getHeadermsg().getText();
 		boolean status = HeaderMsg.contains(DocName);
		System.out.println(HeaderMsg);
		Assert.assertEquals(status, true);

}
	@Test
	public void verifyEditRecord() throws Throwable {
		hp.getDocLink().click();
		
		driver.findElement(By.id("31262")).click();
		
		Docpage dp=new Docpage(driver);
		dp.getEditDoc().click();
		Thread.sleep(2000);
		
	    String actualMsg = dp.getHeaderEdit().getText().trim();

		Assert.assertTrue(actualMsg.contains("Editing Document Information"));
		
	    System.out.println("Edit message verified successfully");
 	
	}
	
	@Test
	public void VerifyDeleteRecord() throws Throwable {
		hp.getDocLink().click();
	    driver.findElement(By.id("35983")).click();

	    Docpage dp = new Docpage(driver);
	    dp.getDeleteDoc().click();

	    Alert alt = driver.switchTo().alert();

	    String actualPopupMsg = alt.getText();
	    System.out.println(actualPopupMsg);

	    Assert.assertTrue(actualPopupMsg.contains("Delete"),"Delete confirmation popup not displayed correctly" );
	  
	    alt.dismiss();
		
	}
}

