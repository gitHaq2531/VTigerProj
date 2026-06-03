package com.client.ObjectRepository;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class InvoicePage {
	WebDriver driver;
	public InvoicePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//a[contains(text(),'Create Invoice')]")
	private WebElement invoicLink;
	
	@FindBy(name="subject")
	private WebElement invoiceSub;
	
	@FindBy(name="bill_street")
	private WebElement billAddress;
	
	@FindBy(xpath="//textarea[@name='ship_street']") 
     private WebElement shipstreetEdt;
	 
	@FindBy(xpath = "//img[@title='Select' and contains(@onclick, 'return')]")
	private WebElement selOrgName;
	
	@FindBy(linkText = "Sdet46_416")
	private WebElement searchorg;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement Headermsg;
	
	@FindBy(id="search_txt")
	private WebElement SearchOrg;
	
	@FindBy(name="search")
	private WebElement searchNow;
	
	public WebElement getInvoicLink() {
		return invoicLink;
	}

	public WebElement getInvoiceSub() {
		return invoiceSub;
	}

	public WebElement getBillAddress() {
		return billAddress;
	}

	public WebElement getShipstreetEdt() {
		return shipstreetEdt;
	}

	public WebElement getSelOrgName() {
		return selOrgName;
	}

	public WebElement getSearchorg() {
		return searchorg;
	}

	
	public WebElement getHeadermsg() {
		return Headermsg;
	}
	

public WebElement getSaveBtn() {
		
		return saveBtn;
	}

	

	public WebElement getSearchNow() {
		return searchNow;
	}

	public WebElement getSearchOrg() {
		return SearchOrg;
	}

	public void CreateInvoice(String InvName) {
		invoiceSub.sendKeys(InvName);
		billAddress.sendKeys("Vashi");
		shipstreetEdt.sendKeys("Navi Mumbai");
		selOrgName.click();
		
		String parentWin = driver.getWindowHandle();
		Set<String> allwin = driver.getWindowHandles();
		System.out.println(allwin.size());
		for(String win : allwin) {
			if(!win.equals(parentWin)) {
				driver.switchTo().window(win);
				System.out.println("switched");
					}
			}
		searchorg.click();
		//saveBtn.click();
		
//		WebElement searchField=driver.findElement(By.name("search_field"));
//		Select sel =new Select(searchField);
//		System.out.println(sel.getOptions().size());
//		sel.selectByVisibleText("Organization Name");
		//SearchOrg.sendKeys("Pyramid Lenovo_4927");
		
		


		
	}

	
	
}


