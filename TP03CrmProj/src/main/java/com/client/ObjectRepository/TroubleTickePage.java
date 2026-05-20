package com.client.ObjectRepository;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TroubleTickePage {
	
	WebDriver driver;
	public TroubleTickePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//img[@title='Create Ticket...']")
	private WebElement creatBtn;
	
	public WebElement getCreatBtn() {
		return creatBtn;
	}
	@FindBy(name = "ticket_title")
	private WebElement  titleEdit;
	
	@FindBy(xpath = "//img[@title='Select']")
	private WebElement conBtnEdit;
	
	@FindBy(linkText = "pppppp Prasath2429")
	private WebElement contactEdit;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerMsg;
	
	public WebElement getHeaderMsg() {
		return headerMsg;
	}

	public WebElement getTitleEdit() {
		return titleEdit;
	}

	public WebElement getConBtnEdit() {
		return conBtnEdit;
	}

	public WebElement getContactEdit() {
		return contactEdit;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public void createTroubleTicket(String title) throws Throwable {
		creatBtn.click();
		titleEdit.sendKeys(title);
		conBtnEdit.click();
		String pareWin = driver.getWindowHandle();
		Set<String> allwin = driver.getWindowHandles();
		for(String win : allwin) {
			if(!win.equals(pareWin)) {
				driver.switchTo().window(win);
				
			}
		}
		contactEdit.click();
		Thread.sleep(2000);
		driver.switchTo().window(pareWin);
		saveBtn.click();
	
	}
}
