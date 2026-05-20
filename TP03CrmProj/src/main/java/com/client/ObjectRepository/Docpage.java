package com.client.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Docpage {
	WebDriver driver;
	public Docpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Document...']")
	private WebElement CreateDoc;
	
	
	@FindBy(name="notes_title")
	private WebElement titleEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']") 
    private WebElement saveBtn;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headermsg;
	
	@FindBy(linkText = "edit")
	private WebElement editDoc;
	
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement headerEdit;
	
	
	
	public WebElement getCreateDoc() {
		 return CreateDoc;
	}
	
	
	public WebElement getEditDoc() {
		return editDoc;
	}


	public WebElement getHeaderEdit() {
		return headerEdit;
	}


	public WebElement getTitleEdt() {
		return titleEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getHeadermsg() {
		return headermsg;
	}
	
	public void createDoc(String DocName ) {
		titleEdt.sendKeys(DocName);
		 saveBtn.click();                                         
	 }

	


}
