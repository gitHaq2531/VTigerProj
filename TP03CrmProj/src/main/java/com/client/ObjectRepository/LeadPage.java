package com.client.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadPage {
	WebDriver driver;
	public LeadPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//img[@title='Create Lead...']")
	private WebElement createLeadEdit;
	
	@FindBy(name = "lastname")
	private WebElement lastNameEdit;
	
	@FindBy(name = "company")
	private WebElement companyEdit;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBTN;
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement infoMsg;
	
	
	public WebElement getInfoMsg() {
		return infoMsg;
	}

	public WebElement getCreateLeadEdit() {
		return createLeadEdit;
	}

	public WebElement getLastNameEdit() {
		return lastNameEdit;
	}

	public WebElement getCompanyEdit() {
		return companyEdit;
	}

	public WebElement getSaveBTN() {
		return saveBTN;
	}
	
	public void createLead(String lastName, String company) {
		createLeadEdit.click();
		lastNameEdit.sendKeys(lastName);
		companyEdit.sendKeys(company);
		saveBTN.click();
		
	}
	

}
