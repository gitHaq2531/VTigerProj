package com.client.project.Email;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.client.Project.packageName.BaseClass;

/*
 * @author : Kiran
 * */
public class createEmailTest extends BaseClass{
	
	@Test
	public void createemailTest() {
		hp.getEmailLink().click();
		
		driver.findElement(By.linkText("Incoming Mail Server Settings")).click();
		driver.findElement(By.linkText("All Mails")).click();
	}
	

}
