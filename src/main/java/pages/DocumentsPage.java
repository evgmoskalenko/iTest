package pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;


public class DocumentsPage extends Page {

    public DocumentsPage(PageManager pages) {
        super(pages);
    }

    public DocumentsPage ensurePageLoaded() {
        super.ensurePageLoaded();
        wait.until(presenceOfElementLocated(By.xpath("//a[contains(.,'Мої документи')]")));
        return this;
    }

    @FindBy(xpath = "//a[@ng-click='loginWithBankId()']")
    private WebElement bankIdAuthorizationButton;

    @FindBy(css = "span.glyphicon.glyphicon-link")
    private WebElement shareDocumentLink;

    @FindBy(id = "name")
    private WebElement nameOfRecipientField;

    @FindBy(css = "button.btn.btn-primary")
    private WebElement getCodeButton;

    @FindBy(id = "link")
    private WebElement codeField;

    @FindBy(css = "div.modal-footer.ng-scope > button.btn.btn-primary")
    private WebElement okButton;

    @FindBy(xpath = "//a[@ui-sref='index.documents.search']")
    private WebElement searchWithCodeLink;

    @FindBy(xpath = "//button[contains(.,' Добавить документ ')]")
    private WebElement upload;

    @FindBy(id = "code")
    private WebElement inputCodeField;

    @FindBy(css = "button.btn.btn-primary")
    private WebElement searchDocumentButton;

    @FindBy(xpath = "//a[contains(.,'Завантажити')]")
    private WebElement downloadLink;

    @FindBy(name = "documentNameForUpload")
    private WebElement nameNewDocument;

    @FindBy(name = "documentTypeForUpload")
    private WebElement typeNewDocument;

    @FindBy(xpath = "//button[@ng-click='uploadDocument(documentTypeForUpload, documentNameForUpload)']")
    private WebElement saveNewDocument;



    public String accessCode;

    public DocumentsPage selectionOperator(String goal) {
        new Select(driver.findElement(By.id("operatorId"))).selectByVisibleText(goal);
        return pages.documentsPage;
    }

    public DocumentsPage searchDocumentByCode() {
        searchDocumentButton.click();
        return pages.documentsPage;
    }

    public DocumentsPage inputCode() {
        inputCodeField.sendKeys(accessCode);
        return pages.documentsPage;
    }

    public DocumentsPage clickSearchWithCodeLink() {
        searchWithCodeLink.click();
        return pages.documentsPage;
    }


    public BankIdAuthorizationPage clickBankIdAuthorizationButton() {
        bankIdAuthorizationButton.click();
        return pages.bankIdAuthorizationPage;
    }

    public DocumentsPage clickShareDocumentLink() {
        shareDocumentLink.click();
        return pages.documentsPage;
    }

    public DocumentsPage fillNameOfRecipientField(String name) {
        nameOfRecipientField.clear();
        nameOfRecipientField.sendKeys(name);
        return pages.documentsPage;
    }

    public DocumentsPage clickGetCodeButton() {
        getCodeButton.click();
        return pages.documentsPage;
    }

    public DocumentsPage saveCodeToAVariable() {
        setAccessCode(codeField.getAttribute("value"));
        return pages.documentsPage;
    }

    public DocumentsPage clickOkButton() {
        okButton.click();
        return pages.documentsPage;
    }

    public boolean verifyCodePresent() {
        if (getAccessCode().isEmpty()) {
            return false;
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

// upload Document

    public static void setClipboardData(String document) {
        StringSelection stringSelection = new StringSelection(document);
        Toolkit.getDefaultToolkit().getSystemClipboard()
                .setContents(stringSelection, null);
    }

    public DocumentsPage uploadFile(String document) throws  AWTException {
        File file = new File(document);
        //
        upload.click();
        //
        setClipboardData(file.getAbsolutePath());
        //
        Robot robot = new Robot();
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.delay(300);
        robot.keyPress(KeyEvent.VK_V);
        robot.delay(300);
        robot.keyRelease(KeyEvent.VK_V);
        robot.delay(300);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(300);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(300);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(300);
        return pages.documentsPage;
    }

// save new document
         public  DocumentsPage saveNewDocuments() {
             nameNewDocument.sendKeys("Test");
//          selectValue(By.name("documentTypeForUpload"),"ІПН");
             saveNewDocument.click();
             return pages.documentsPage;


         }


}


