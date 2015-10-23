package pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BankIdAuthorizationPage extends Page {
	public BankIdAuthorizationPage(PageManager pages){
		super(pages);
	}
	public BankIdAuthorizationPage ensurePageLoaded(){
		super.ensurePageLoaded();
		wait.until(presenceOfElementLocated(By.id("info")));
		return this;
	}
	@FindBy(css = "#privatBank > img")
	private WebElement privatBankLogo; 

	public void clickPrivatBankLogo(){
		privatBankLogo.click();
	}
}
