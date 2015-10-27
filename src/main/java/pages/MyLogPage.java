package pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MyLogPage extends Page {
	public MyLogPage(PageManager pages){
		super(pages);
	}
	public MyLogPage ensurePageLoaded(){
		super.ensurePageLoaded();
		wait.until(presenceOfElementLocated(By.xpath("/html/body/div/div[2]/div/div/div/div/div[1]/div/div[1]/form/h4")));
		return this;
	}
	@FindBy(linkText = "увійдіть через BankID")
	private WebElement bankIdAuthorizationButton;
	
	@FindBy(linkText = "електронно-цифровий підпис")
	private WebElement electronicDigitalSignatureButton;
	
	public BankIdAuthorizationPage clickBankIdAuthorizationButton(){
		bankIdAuthorizationButton.click();
		return pages.bankIdAuthorizationPage;
	}

    public boolean isMyLogDisplayed(String text){
    	wait.until(presenceOfElementLocated(By.cssSelector("h1")));
    	assertEquals(text, driver.findElement(By.cssSelector("h1")).getText());
		return true;
    	
	 }
    	
    }

