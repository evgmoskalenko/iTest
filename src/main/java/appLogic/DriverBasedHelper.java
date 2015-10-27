package appLogic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import pages.PageManager;

public abstract class DriverBasedHelper {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected PageManager pages;

	public DriverBasedHelper(WebDriver driver){
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
		pages = new PageManager(driver);
	}
	
	
	
	
	//===========================click method==================================//
    public void click(By locator) {
		driver.findElement(locator).click();
	}   
	
	//========================select method======================================================//
    public void selectByVisibleText(String locator, String goal) {
		new Select(driver.findElement(By.id(locator))).selectByVisibleText(goal);
	}
	//========================select country method===============================================//
    protected void selectValue(By locator, By linkText) {
		click(locator);
		click(linkText);
	} 


	//================================data input method===============================//
    public void type(By locator, String text) {
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(text);
	}
    
  




}
