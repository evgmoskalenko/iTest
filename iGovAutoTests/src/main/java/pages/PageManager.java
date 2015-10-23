package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class PageManager {
	
	private WebDriver driver;
	
	public MainPage mainPage;
	public ServicesPage servicesPage;
	public DocumentsPage documentsPage;
	public StatusPage statusPage;
	public MyLogPage myLogPage;
	public AboutPortal aboutPortalPage;
	public BankIdAuthorizationPage bankIdAuthorizationPage;
	
	
	public PageManager(WebDriver driver){
		this.driver = driver;
		mainPage = initElements(new MainPage(this));
		servicesPage = initElements(new ServicesPage(this));
		documentsPage = initElements(new DocumentsPage(this));
		statusPage = initElements(new StatusPage(this));
		myLogPage = initElements(new MyLogPage(this));
		aboutPortalPage = initElements(new AboutPortal(this));
		bankIdAuthorizationPage = initElements(new BankIdAuthorizationPage(this));
		
	}
	
	private <T extends Page> T initElements(T page){
     PageFactory.initElements(new DisplayedElementLocatorFactory(driver, 10),page);
     return page;
	}
	
	public WebDriver getWebDriver(){
		return driver;
	}
}
