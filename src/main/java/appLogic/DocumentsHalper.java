package appLogic;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

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

    public boolean isDocumentUpload(String document ) throws  AWTException  {
        pages.documentsPage.uploadFile(document);
        return true;
    }

    public boolean saveDocument( )   {
        pages.documentsPage.saveNewDocuments();
        return true;
    }


}
