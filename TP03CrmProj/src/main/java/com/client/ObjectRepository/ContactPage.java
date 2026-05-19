package com.client.ObjectRepository;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	
	WebDriver driver;
	public ContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createNewContact;
	
	
	public WebElement getCreateNewContact() {
		return createNewContact;
	}
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerMsg;
	
	public WebElement getHeaderMsg() {
		return headerMsg;
	}
	@FindBy(name = "lastname")
	private WebElement lastnameEdit;
	
	public WebElement getLastnameEdit() {
		return lastnameEdit;
	}
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	@FindBy(xpath = "//img[@title='Select']")
	private WebElement orgbtnEdit;
	
	@FindBy(linkText = "Instagram Pay")
	private WebElement orgnName;
	
	public WebElement getOrgbtnEdit() {
		return orgbtnEdit;
	}

	public WebElement getOrgnName() {
		return orgnName;
	}

	public void createContact(String lastName) {
		createNewContact.click();
		lastnameEdit.sendKeys(lastName);
		saveBtn.click();
	}
	
	public void createContactwithOrg(String lastName) throws Throwable {
		createNewContact.click();
		lastnameEdit.sendKeys(lastName);
		orgbtnEdit.click();
		String pareWin = driver.getWindowHandle();
		Set<String> allwin = driver.getWindowHandles();
		for(String win : allwin) {
			if(!win.equals(pareWin)) {
				driver.switchTo().window(win);
				
			}
		}
		orgnName.click();
		Thread.sleep(2000);
		driver.switchTo().window(pareWin);
		saveBtn.click();
		
	}
	
	
	
	
	

}
