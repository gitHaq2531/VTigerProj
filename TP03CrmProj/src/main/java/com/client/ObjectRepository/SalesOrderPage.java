package com.client.ObjectRepository;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesOrderPage {
	WebDriver driver;
	public SalesOrderPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText ="Create Sales Order")
	private WebElement createsalesorder;
	
	@FindBy(name="subject")
	private WebElement SalesNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']") 
    private WebElement saveBtn;
	
	@FindBy(xpath = "//img[@title='Select' and contains(@onclick, 'return')]")
	private WebElement selOrgName;
	
	@FindBy(linkText = "Pyramid Lenovo_4927")
	private WebElement searchorg;
	
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement Headermsg;
	
	@FindBy(name="bill_street")
	private WebElement billAddress;
	
	@FindBy(xpath="//textarea[@name='ship_street']") 
     private WebElement shipstreetEdt;
	
	
	public WebElement getCreatesalesorder() {
		return createsalesorder;
	}
	
	public WebElement getSalesNameEdt() {
		return SalesNameEdt;
	}
	
	 public WebElement getSaveBtn() {
		 return saveBtn;
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

	
	public WebElement getBillAddress() {
		return billAddress;
	}

	public WebElement getShipstreetEdt() {
		return shipstreetEdt;
	}

	public void createSales(String Subject) {
		SalesNameEdt.sendKeys(Subject);
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
		saveBtn.click();
		
	    
}
}
