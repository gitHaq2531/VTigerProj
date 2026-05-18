package com.client.Project.packageName;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.client.ObjectRepository.HomePage;
import com.client.ObjectRepository.LoginPage;

public class BaseClass {
	
	public DatabaseUtility dLib = new DatabaseUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public FileUtility fLib = new FileUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public WebDriver driver;
	public static WebDriver sdriver;
	
	
	@BeforeSuite
	public void configBS() {
		dLib.ConnectToDB("String url","String username","String password");
	}
	@BeforeClass
	public void configBC() throws Throwable {
		String BROWSER = fLib.getDataFromProperties("Browser");
		String URL = fLib.getDataFromProperties("Url");
		sdriver=driver;
	}
	@BeforeMethod
	public void configBM() throws Throwable {
		
		String USERNAME = fLib.getDataFromProperties("Username");
		String PASSWORD = fLib.getDataFromProperties("Password");
		LoginPage lp = new LoginPage(driver);
		lp.LoginToApp(USERNAME, PASSWORD);
	}
	@AfterMethod
	public void configAM() {
		HomePage hp = new HomePage(driver);
		hp.logout();
		
	}
	@AfterClass
	public void configAC() {
		driver.quit();
	}
	@AfterSuite
	public void configAS() {
		dLib.CloseDB();
	}
}

