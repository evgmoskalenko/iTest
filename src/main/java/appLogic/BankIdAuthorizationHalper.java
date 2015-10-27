package appLogic;



import org.openqa.selenium.By;






public class BankIdAuthorizationHalper extends DriverBasedHelper{
	 
	public BankIdAuthorizationHalper(ApplicationManager manager) {
		    super(manager.getWebDriver());
		  }
public void privatBankAuthorization(){
	pages.bankIdAuthorizationPage.clickPrivatBankLogo();
	 type(By.id("loginLikePhone"), "+380102030405");
	 type(By.id("passwordLikePassword"), "value");
	 click(By.id("signInButton"));
	 type(By.id("first-section"),"12");
	 type(By.id("second-section"),"34");
	 type(By.id("third-section"),"56");
	 click(By.id("confirmButton"));

	}
public void initBankIdAuthorizationFromMyLogPage(){
	 pages.myLogPage.ensurePageLoaded().clickBankIdAuthorizationButton();
}
public void initBankIdAuthorizationFromDocumentsPage(){
	 pages.documentsPage.ensurePageLoaded().clickBankIdAuthorizationButton();
}
}
