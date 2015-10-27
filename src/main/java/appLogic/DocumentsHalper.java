package appLogic;

public class DocumentsHalper extends DriverBasedHelper {

	public DocumentsHalper(ApplicationManager manager) {
	    super(manager.getWebDriver());
	  }
	
	
	public void getAccessCode(String name){
		pages.documentsPage.clickShareDocumentLink()
		                   .fillNameOfRecipientField(name)
		                   .clickGetCodeButton()
		                   .saveCodeToAVariable()
		                   .clickOkButton();
	}


	public boolean isAccessCodeNotNull() {
		pages.documentsPage.saveCodeToAVariable().verifyCodePresent();
		return true;
	}
	
	public void searchDocumentWithCode(){
		pages.documentsPage.clickSearchWithCodeLink()
		                   .selectionOperator("iGov")
		                   .inputCode()
		                   .searchDocumentByCode();
		                   
	}


	public boolean isDocumentFound() {
		pages.documentsPage.isElementPresent();
		return true;
	}
}
