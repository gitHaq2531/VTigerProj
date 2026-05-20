package com.client.project.Document;

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
}

