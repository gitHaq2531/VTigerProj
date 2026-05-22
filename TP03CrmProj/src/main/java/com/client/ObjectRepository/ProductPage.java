package com.client.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	WebDriver driver;
	public ProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@title='Create Product...']")
	private WebElement CreateNewProBtn;
	
	
	
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement Headermsg;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']") 
    private WebElement saveBtn;
	
	@FindBy(name="unit_price")
	private WebElement StkPrice;
	
	@FindBy(id="qtyinstock")
	private WebElement Qtystock;
	
	
	@FindBy(name="productname")
	private WebElement ProductNameEdt;
	

	public WebElement getCreateNewProBtn() {
		return CreateNewProBtn;
	}
	

	public WebElement getProductNameEdt() {
		return ProductNameEdt;
	}


	public WebElement getHeadermsg() {
		return Headermsg;
	}
	
	 public WebElement getSaveBtn() {
		 return saveBtn;
	 }
	
	public WebElement getStkPrice() {
		return StkPrice;
	}
	

	
	public WebElement getQtystock() {
		return Qtystock;
	}


	

	public void createProduct(String ProductName) {
		ProductNameEdt.sendKeys(ProductName);
		StkPrice.sendKeys("1000");
		Qtystock.sendKeys("20");
		 saveBtn.click();
	}
	

}
