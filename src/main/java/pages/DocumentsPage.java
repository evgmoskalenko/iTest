package pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class DocumentsPage extends Page {
	
	public DocumentsPage(PageManager pages){
		super(pages);
	}
	public DocumentsPage ensurePageLoaded(){
		super.ensurePageLoaded();
		wait.until(presenceOfElementLocated(By.xpath("//a[contains(.,'Мої документи')]")));
		return this;
	}
	@FindBy(xpath = "//a[@ng-click='loginWithBankId()']")
	private WebElement bankIdAuthorizationButton;
	
	@FindBy(css = "span.glyphicon.glyphicon-link")
	private WebElement shareDocumentLink;
	
	@FindBy (id = "name")
	private WebElement nameOfRecipientField;
	
	@FindBy (css = "button.btn.btn-primary")
	private WebElement getCodeButton;
	
	@FindBy (id = "link")
	private WebElement codeField;
	
	@FindBy (css = "div.modal-footer.ng-scope > button.btn.btn-primary")
	private WebElement okButton;
	
	@FindBy (linkText = "Пошук документу за кодом")
	private WebElement searchWithCodeLink;
	

	
	@FindBy (id = "code")
	private WebElement inputCodeField;
	
	@FindBy (css = "button.btn.btn-primary")
	private WebElement searchDocumentButton;
	
	@FindBy (css = "p.text-muted")
	private WebElement downloadLink;

	public String accessCode;
	
	public DocumentsPage selectionOperator(String goal){
		new Select(driver.findElement(By.id("operatorId"))).selectByVisibleText(goal);
		return pages.documentsPage;
	}
	public DocumentsPage searchDocumentByCode(){
		searchDocumentButton.click();
		return pages.documentsPage;
	}
	public DocumentsPage inputCode(){
		inputCodeField.sendKeys(accessCode);
		System.out.println(accessCode);
		return pages.documentsPage;
	}
	public DocumentsPage clickSearchWithCodeLink(){
		searchWithCodeLink.click();
		return pages.documentsPage;
	}
	
	
	public BankIdAuthorizationPage clickBankIdAuthorizationButton() {
		bankIdAuthorizationButton.click();
		return pages.bankIdAuthorizationPage;
     }
	public DocumentsPage clickShareDocumentLink(){
		shareDocumentLink.click();
		return pages.documentsPage;
	}
	public DocumentsPage fillNameOfRecipientField(String name){
		nameOfRecipientField.clear();
		nameOfRecipientField.sendKeys(name);
		return pages.documentsPage;
		}
	public DocumentsPage clickGetCodeButton(){
		getCodeButton.click();
		return pages.documentsPage;
	}
	public DocumentsPage saveCodeToAVariable(){
		setAccessCode(codeField.getAttribute("value"));
		return pages.documentsPage;
	}
	public DocumentsPage clickOkButton(){
		okButton.click();
		return pages.documentsPage;
	}
	public boolean verifyCodePresent() {
	  if(getAccessCode().isEmpty()){
	return false ;  
	}
	return true;
		
	}
	public String getAccessCode() {
		return accessCode;
	}
	public void setAccessCode(String accessCode) {
		this.accessCode = accessCode;
	}
	public boolean isElementPresent() {
		 downloadLink.isDisplayed();
		 return true;
		
	}

}
