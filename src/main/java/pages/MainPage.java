package pages;


import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;





public class MainPage extends Page  {

	public MainPage(PageManager pages){
		super(pages);
	}
	public MainPage ensurePageLoaded(){
		super.ensurePageLoaded();
		wait.until(presenceOfElementLocated((By.cssSelector("html.no-js body.ng-scope div.full-height.ng-scope div.main.full-height div.view.ng-scope div.container.ng-scope div.row.ng-scope div.col-md-12 h1.ng-binding"))));
		return this;
	}
	
@FindBy(xpath = "//input")	
private WebElement searchField;

@FindBy(css = "h4")	
private WebElement servicesLink;

@FindBy(xpath = "//li[2]/a/h4")	
private WebElement documentsLink;

@FindBy(xpath = "//li[3]/a/h4")	
private WebElement statusLink;

@FindBy(xpath = "//li[4]/a/h4")	
private WebElement myLogLink;

@FindBy(xpath = "//li[5]/a/h4")	
private WebElement aboutPortalLink;

public MainPage typeInSearchField(String text){
	searchField.clear();
	searchField.sendKeys(text);
	return this;
}
public ServicesPage clickServicesLink(){
	servicesLink.click();
	return pages.servicesPage;
}
public DocumentsPage clickDocumentsLink(){
	documentsLink.click();
	return pages.documentsPage;
}
public StatusPage clickStatusLink(){
	statusLink.click();
	return pages.statusPage;
}
public MyLogPage clickMyLogLink(){
	myLogLink.click();
	return pages.myLogPage;
}
public AboutPortal clickAboutPortalLink(){
	aboutPortalLink.click();
	return pages.aboutPortalPage;
}
public boolean isFinded(String text,String locator) {
	wait.until(presenceOfElementLocated((By.cssSelector("html.no-js body.ng-scope div.full-height.ng-scope div.main.full-height div.view.ng-scope div.container.ng-scope div.row.ng-scope div.col-md-12 h1.ng-binding"))));
	assertEquals(text, driver.findElement(By.linkText(locator)).getText());
	return true;
	}
	
public boolean isNotFinded() {
	  try{
		   wait.until(presenceOfElementLocated(By.cssSelector("html.no-js")));
		  return true;
	  }
	  catch (TimeoutException to){	return false;}
	  }
public boolean isLoggedIn() {
	if(driver.findElement(By.cssSelector("span")).isDisplayed()){
 	   return true;
  }else{
    return false;	 
  }
}
 
}


