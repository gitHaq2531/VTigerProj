package com.client.ObjectRepository;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesPage {
	
	WebDriver driver;
	public OpportunitiesPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//img[@title='Create Opportunity...']")
	private WebElement createNewOpportunities;
	
	@FindBy(name = "potentialname")
	private WebElement oppoNameEdit;
	
	@FindBy(xpath = "//img[@title='Select']")
	private WebElement relatedToEdit;
	
	@FindBy(linkText = "Instagram Pay")
	private WebElement orgnName;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerMSG;
	
	@FindBy(xpath = "//td[text()='Campaign Source 			']/parent::tr//img")
	private WebElement campaignBtnEdit;
	
	@FindBy(linkText = "Greenliving1900")
	private WebElement campaignEdit;
	
	
	
	
	
	public WebElement getCampaignEdit() {
		return campaignEdit;
	}

	public WebElement getCampaignBtnEdit() {
		return campaignBtnEdit;
	}

	public WebElement getHeaderMSG() {
		return headerMSG;
	}

	public WebElement getCreateNewOpportunities() {
		return createNewOpportunities;
	}

	public WebElement getOppoNameEdit() {
		return oppoNameEdit;
	}

	public WebElement getRelatedToEdit() {
		return relatedToEdit;
	}

	public WebElement getOrgName() {
		return orgnName;
	}
	
	public void createOpportunities(String OppName) throws Throwable {
		createNewOpportunities.click();
		oppoNameEdit.sendKeys(OppName);
		relatedToEdit.click();
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
		
		savebtn.click();
		
		
	}
	public void createOpportunitiesWithCampaign(String OppName) throws Throwable {
		createNewOpportunities.click();
		oppoNameEdit.sendKeys(OppName);
		relatedToEdit.click();
		String pareWin = driver.getWindowHandle();
		Set<String> allwin = driver.getWindowHandles();
		for(String win : allwin) {
			if(!win.equals(pareWin)) {
				driver.switchTo().window(win);
				
			}
		}
		orgnName.click();
		driver.switchTo().window(pareWin);
		campaignBtnEdit.click();
		String pareWin1 = driver.getWindowHandle();
		Set<String> allwin1 = driver.getWindowHandles();
		for(String win1 : allwin1) {
			if(!win1.equals(pareWin1)) {
				driver.switchTo().window(win1);
				
			}
		}
		campaignEdit.click();
		Thread.sleep(2000);
		driver.switchTo().window(pareWin1);
		savebtn.click();
		
		
		
	}

}
