package com.client.ObjectRepository;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Organizations")
	private WebElement orgLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactLink;
	
	@FindBy(linkText = "Opportunities")
	private WebElement opportunityLink;
	
	@FindBy(linkText = "Products")
	private WebElement productLink;
	
	@FindBy(linkText = "Leads")
	private WebElement leadslink;
	
	@FindBy(linkText="More")
	private WebElement morelink;
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignlink;
	
	@FindBy(linkText = "Invoice")
	private WebElement invoiceLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutlink;
	
	
	
	
    public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getOpportunityLink() {
		return opportunityLink;
	}

	public WebElement getProductLink() {
		return productLink;
	}

	public WebElement getLeadslink() {
		return leadslink;
	}

	public WebElement getMorelink() {
		return morelink;
	}
	
	public WebElement getCampaignlink() {
		return campaignlink;
	}
	
	

	public WebElement getInvoiceLink() {
		return invoiceLink;
	}

	public WebElement getAdminImg() {
		return adminImg;
	}

	public WebElement getSignoutlink() {
		return signoutlink;
	}



    public void navigateToCampaignPage() {
	     Actions act=new Actions(driver);
	      act.moveToElement(morelink).perform();
	        campaignlink.click();
      }
    
    
    public void navigateToInvoicePage() {
    	Actions act=new Actions(driver);
    	act.moveToElement(morelink).perform();
    	invoiceLink.click();
    }


   public void logout() {
	      Actions act=new Actions(driver);
	      act.moveToElement(adminImg).perform();
	        signoutlink.click();
        }
}