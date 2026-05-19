package com.client.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Orgpage {
	WebDriver driver;
	public Orgpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement CreateNewOrgBtn;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headermsg;
	
	 @FindBy(name="accountname")                   
     private WebElement orgNameEdt;
	 
	 @FindBy(xpath="//textarea[@name='ship_street']") 
     private WebElement streetEdt;
	 
	 @FindBy(xpath="//input[@title='Save [Alt+S]']") 
     private WebElement saveBtn;
	
	
	public WebElement getCreateNewOrgBtn() {
		return CreateNewOrgBtn;	
 }

	public WebElement getHeadermsg() {
		return headermsg;
	}
	
	 public WebElement getOrgNameEdt() {
		 return orgNameEdt;
	 }
	 

	 public WebElement getStreetEdt() {
		 return streetEdt;
	 }

	 public WebElement getSaveBtn() {
		 return saveBtn;
	 }
	 
	 public void createOrg(String orgName ) {
		 orgNameEdt.sendKeys(orgName);
		 streetEdt.sendKeys("Mumbai");
		 saveBtn.click();                                         
	 }
	
}