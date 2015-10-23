package appLogic;

import pages.DocumentsPage;
import pages.MyLogPage;

public class NavigationHelper extends DriverBasedHelper {
 
	private String baseUrl;
	
	
	public NavigationHelper(ApplicationManager manager){
		super(manager.getWebDriver());
		this.baseUrl = manager.getBaseUrl();
	}
	
	public void openMainPage(){
		driver.get(baseUrl);
	}
	
	public void goToServicesPage(){
		pages.mainPage.ensurePageLoaded().clickServicesLink();
	}
	public DocumentsPage goToDocumentsPage(){
		pages.mainPage.ensurePageLoaded().clickDocumentsLink();
		return pages.documentsPage;
		 
	}
	public MyLogPage goToMyLogPage(){
		pages.mainPage.ensurePageLoaded().clickMyLogLink();
		return pages.myLogPage;
	}
	public void goToStatusPage(){
		pages.mainPage.ensurePageLoaded().clickStatusLink();
	}
	public void goToAboutPortalPage(){
		pages.mainPage.ensurePageLoaded().clickAboutPortalLink();
	}

}
