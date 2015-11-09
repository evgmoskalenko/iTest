package pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.AssertJUnit.assertEquals;

import appLogic.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MyLogPage  extends ApplicationManager {

    private WebDriver driver;


    public MyLogPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

	@FindBy(linkText = "увійдіть через BankID")
	private WebElement bankIdAuthorizationButton;
	
	@FindBy(linkText = "електронно-цифровий підпис")
	private WebElement electronicDigitalSignatureButton;
	

    public boolean isMyLogDisplayed(){
    	wait.until(presenceOfElementLocated(By.cssSelector("h1")));
    	assertEquals("Мій журнал", driver.findElement(By.xpath("//h1[contains(.,'Мій журнал')]")).getText());
		return true;
    	
	 }
    	
    }

