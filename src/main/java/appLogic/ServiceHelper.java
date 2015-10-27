package appLogic;


public class ServiceHelper extends DriverBasedHelper{
	
	 public ServiceHelper(ApplicationManager manager) {
		    super(manager.getWebDriver());
		  }

	 public void searchService(String service){
		 pages.mainPage.typeInSearchField(service);
		 
		 
	 }


	  public boolean isServiceFinded(String text,String locator) {
	  return pages.mainPage.isFinded(text,locator);
	  }

	
	  public boolean isServiceNotFinded() {
	  return pages.mainPage.isNotFinded();
	  }
	  
	  public boolean isMyLogDisplayed(String text) {
	  pages.myLogPage.isMyLogDisplayed(text);
	  return true;
	  }
}
