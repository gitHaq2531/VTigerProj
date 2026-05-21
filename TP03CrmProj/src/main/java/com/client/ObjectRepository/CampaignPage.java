package com.client.ObjectRepository;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {
	
	WebDriver driver;
	public CampaignPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//img[@alt='Create Campaign...']")
	private WebElement createCampaignBtn;
	
	@FindBy(name = "campaignname")
	private WebElement campaignnameEdit;
	
	@FindBy(xpath = "//img[@title='Select']")
	private WebElement selProductbtn;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(linkText = "Grinder2849")
	private WebElement productNameEdit;
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerInfo;
	
	
	
	
	public WebElement getHeaderInfo() {
		return headerInfo;
	}

	public WebElement getProductNameEdit() {
		return productNameEdit;
	}

	public WebElement getCreateCampaignBtn() {
		return createCampaignBtn;
	}

	public WebElement getCampaignnameEdit() {
		return campaignnameEdit;
	}

	public WebElement getSelProductbtn() {
		return selProductbtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public void createCampaign(String campaignName) throws Throwable {
		createCampaignBtn.click();
		campaignnameEdit.sendKeys(campaignName);
		selProductbtn.click();
		String pareWin = driver.getWindowHandle();
		Set<String> allwin = driver.getWindowHandles();
		for(String win : allwin) {
			if(!win.equals(pareWin)) {
				driver.switchTo().window(win);
				
			}
		}
		productNameEdit.click();
		Thread.sleep(2000);
		driver.switchTo().window(pareWin);
		saveBtn.click();
		
	}

}
