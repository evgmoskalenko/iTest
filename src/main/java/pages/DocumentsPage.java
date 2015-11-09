package pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.AssertJUnit.assertEquals;

import appLogic.ApplicationManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;


public class DocumentsPage extends ApplicationManager {

    private WebDriver driver;


    public DocumentsPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


// =================== Элементы таба "Мои документы" ===================//

    @FindBy(xpath = "//a[@href='/documents/user']")
    private WebElement myDocumentsTab;                                 // Таб мои документы

    @FindBy(xpath = "//a[@ng-click='loginWithBankId()']")
    private WebElement bankIdAuthorizationButton;                      // Кнопка ИД Банка

    @FindBy(xpath = "//button[contains(@ng-click,'loginWithEds()')]")
    private WebElement edsAuthorizationButton;                         // Кнопка ЕЦП

    @FindBy(xpath = "//button[contains(.,' Добавить документ ')]")
    private WebElement uploadNewDocumentButton;                        // Кнопка "Добавить документ"

    @FindBy(name = "documentNameForUpload")
    private WebElement nameNewDocumentField;                           // Поле ввода названия нового документа

    @FindBy(name = "documentTypeForUpload")
    private WebElement typeNewDocumentSelector;                        // Селектор выбора типа документа

    @FindBy(xpath = "//button[@ng-click='uploadDocument(documentTypeForUpload, documentNameForUpload)']")
    private WebElement saveNewDocumentButton;                          // Кнопка сохранения нового документа

    @FindBy(css = "span.glyphicon.glyphicon-link")
    private WebElement shareDocumentLink;                              // Иконка шаринга документа

    @FindBy(id = "name")
    private WebElement nameOfRecipientField;                           // Поле ввода ФИО для шаринга

    @FindBy(css = "button.btn.btn-primary")
    private WebElement getCodeButton;                                  // Кнопка получения кода

    @FindBy(id = "link")
    private WebElement codeField;                                       // Поле с отображением кода

    @FindBy(xpath = "//button[contains(@ng-click,'close()')]")
    private WebElement okButton;                                        // Кнопка ОК форме отображения кода


// =================== Элементы таба "Поиск за кодом" ===================//

    @FindBy(xpath = "//a[@href='/documents/search']")
    private WebElement searchWithCodeTab;                             // Таб  поиска документов

    @FindBy(id = "code")
    private WebElement inputCodeField;                                 // Поле ввода  кода доступа

    @FindBy(id = "typeId")
    private WebElement typeDocumentSelector;                            // Селектор выбора документа

    @FindBy(id = "operatorId")
    private WebElement operatorSelector;                                // Селектор выбора оператора

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private WebElement searchDocumentButton;                            // Кнопка поиска документа

    @FindBy(xpath = "//a[contains(.,'Завантажити')]")
    private WebElement downloadLink;                                    // Ссылка загрузки найденного документа

    @FindBy(id = "smsPass")
    private WebElement inputSMSCodeField;                                // Пооле ввода паоля из СМС

    @FindBy(xpath = "//button[@ng-disabled='!smsPass']")
    private WebElement confirmDocumentButton;                            // Ссылка загрузки найденного документа

    @FindBy(xpath = "//div[@role='alert']")
    private WebElement alertError;                                       // Блок вывода ошибки

// =================== Элементы таба "Нотариус" ===================//

    @FindBy(xpath = "//a[@href='/documents/notary']")
    private WebElement notaryTab;                                       // Таб "Нотариусам"


    // =============================================== МЕТОДЫ  =================================================//

    public String accessCode;

    public void selectionOperator(String goal) {
        new Select(driver.findElement(By.id("operatorId"))).selectByVisibleText(goal);

    }

    public void searchDocumentByCode() {
        searchDocumentButton.click();

    }

    public void inputCode() {
        inputCodeField.sendKeys(accessCode);

    }

    public void clickSearchWithCodeLink() {
        searchWithCodeTab.click();

    }

    public void clickShareDocumentLink() {
        shareDocumentLink.click();
       ;
    }

    public void fillNameOfRecipientField(String name) {
        nameOfRecipientField.clear();
        nameOfRecipientField.sendKeys(name);

    }

    public void clickGetCodeButton() {
        getCodeButton.click();

    }

    public void saveCodeToAVariable() {
        setAccessCode(codeField.getAttribute("value"));

    }

    public void clickOkButton() {
        okButton.click();

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

    public void uploadFile(String document) throws  AWTException {
        File file = new File(document);
        //
        uploadNewDocumentButton.click();
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
        }

// save new document
         public  void saveNewDocuments() {
             nameNewDocumentField.sendKeys("Test");
         new Select(driver.findElement(By.name("documentTypeForUpload"))).selectByVisibleText("ІПН");
             nameNewDocumentField.click();

         }


// refresh Page
    public void refreshPage (){
    driver.navigate().refresh();

    }
//==================================================================
public void getAccessCode(String name){
    clickShareDocumentLink();
            fillNameOfRecipientField(name);
            clickGetCodeButton();
            saveCodeToAVariable();
            clickOkButton();
}


    public void isAccessCodeNotNull() {
        verifyCodePresent();
    }

    public void searchDocumentWithCode(){
        clickSearchWithCodeLink();
                selectionOperator("iGov");
                inputCode();
                searchDocumentByCode();

    }


    public void isDocumentFound() {
        isElementPresent();

    }

    public void isDocumentUpload(String document ) throws  AWTException  {
        uploadFile(document);

    }

    public void saveDocument( )   {
       saveNewDocuments();

    }

//    public void isMyLogDisplayed(){
//        wait.until(presenceOfElementLocated(By.cssSelector("h1")));
//        assertEquals("Мій журнал", driver.findElement(By.xpath("//h1[contains(.,'Мій журнал')]")).getText());
//
//
//    }

}


