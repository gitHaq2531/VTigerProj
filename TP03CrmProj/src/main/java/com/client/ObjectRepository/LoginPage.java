package com.client.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage  {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(name="user_name")
	private WebElement useredit;
	
	@FindBy(name="user_password")
	private WebElement passwordedit;
	
	@FindBy(id="submitButton")
	private WebElement login;
	
	
	public WebElement getUserEdit() {
		return useredit;
	}


	public WebElement getPasswordedit() {
		return passwordedit;
	}

	public WebElement getLogin() {
		return login;
	}

	
	public void LoginToApp(String Username, String Password) {
		 useredit.sendKeys(Username);
		 passwordedit.sendKeys(Password);
		 login.click();
		
	}
	
	
}
