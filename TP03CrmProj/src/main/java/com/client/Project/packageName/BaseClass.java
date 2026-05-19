package com.client.Project.packageName;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
	public HomePage hp ;
	
	
	@BeforeSuite
	public void configBS() {
		dLib.ConnectToDB("String url","String username","String password");
	}
	@BeforeClass
	public void configBC() throws Throwable {
		String BROWSER = fLib.getDataFromProperties("Browser");
		String URL = fLib.getDataFromProperties("Url");
		

		
		if(BROWSER.equals("chrome")){
  			driver=new ChromeDriver();
  		}else if(BROWSER.equals("firefox")){
  				driver=new FirefoxDriver();
  			}
  		else if(BROWSER.equals("edge")){
  			driver=new EdgeDriver();
  		}else {
  			driver= new ChromeDriver();
  		}

		driver.manage().window().maximize();
		wLib.waitForPageLoad(driver);

		driver.get(URL);
		
		sdriver=driver;
	}
	@BeforeMethod
	public void configBM() throws Throwable {
		
		String USERNAME = fLib.getDataFromProperties("Username");
		String PASSWORD = fLib.getDataFromProperties("Password");
		LoginPage lp = new LoginPage(driver);
		lp.LoginToApp(USERNAME, PASSWORD);
		hp= new HomePage(driver);
		
		
	}
	@AfterMethod
	public void configAM() {
		
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

