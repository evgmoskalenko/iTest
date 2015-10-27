package appLogic;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.util.Properties;
import java.util.concurrent.TimeUnit;






public class ApplicationManager {

	private WebDriver driver;
	private String baseUrl;
	private NavigationHelper navigationHalper;
    private ServiceHelper serviceHelper;
    private BankIdAuthorizationHalper bankIdAuthorizationHalper;
    private DocumentsHalper documentsHalper;
	
	public ApplicationManager(Properties properties){       
		String browser = properties.getProperty("browser");
		if("firefox".equals(browser)){
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}else if ("ie".equals(browser)){
			driver = new InternetExplorerDriver();
		}else if ("chrome".equals(browser)){
			driver = new ChromeDriver();
		}else{
			throw new Error("Unsupported browser:" + browser);
		}
		
		baseUrl = properties.getProperty("baseUrl");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);
		
		
		navigationHalper = new NavigationHelper(this);
		serviceHelper = new ServiceHelper(this);
		bankIdAuthorizationHalper = new BankIdAuthorizationHalper(this);
		documentsHalper = new DocumentsHalper(this);
	  	}
	

public NavigationHelper getNavigationHelper(){
	return navigationHalper;
}
public ServiceHelper getServiceHelper(){
	return serviceHelper;
}
public BankIdAuthorizationHalper getBankIdAuthorizationHalper(){
	return bankIdAuthorizationHalper;
}
public DocumentsHalper getDocumentsHalper(){
	return documentsHalper;
}

protected WebDriver getWebDriver(){
	return driver;
}
protected String getBaseUrl(){
	return baseUrl;
}

public void stop() {
	if(driver != null){
		driver.quit();
   }
}


	public void mainPage() {
 driver.get("https://test-version.igov.org.ua/");	
	}

	 public void signOut() {
		 if(singIn()){
driver.findElement(By.cssSelector("span")).click();		 
		 }
	 }
	 private boolean singIn() {
		 return(driver.findElement(By.cssSelector("span")).isDisplayed());
   
	}
}
