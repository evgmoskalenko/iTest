package pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.AssertJUnit.assertEquals;

import appLogic.ApplicationManager;

import appLogic.Constants;
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
    public WebElement myDocumentsTab;                                 // Таб мои документы

    @FindBy(xpath = "//div[@ng-hide='authProcess']")
    public WebElement formSignInBankId;                                 // форма входа в банк ИД

    @FindBy(xpath = "//p[@align='justify']")
    public WebElement infoBlockDocument;                                 // форма входа в банк ИД

    @FindBy(xpath = "//a[@ng-click='loginWithBankId()']")
    public WebElement bankIdAuthorizationButton;                      // Кнопка ИД Банка

    @FindBy(xpath = "//button[contains(@ng-click,'loginWithEds()')]")
    public WebElement edsAuthorizationButton;                         // Кнопка ЕЦП

    @FindBy(xpath = "//button[contains(.,' Добавить документ ')]")
    public WebElement uploadNewDocumentButton;                        // Кнопка "Добавить документ"

    @FindBy(name = "documentNameForUpload")
    public WebElement nameNewDocumentField;                           // Поле ввода названия нового документа

    @FindBy(name = "documentTypeForUpload")
    public WebElement typeNewDocumentSelector;                        // Селектор выбора типа документа

    @FindBy(xpath = "//button[@ng-click='uploadDocument(documentTypeForUpload, documentNameForUpload)']")
    public WebElement saveNewDocumentButton;                          // Кнопка сохранения нового документа

    @FindBy(xpath = "//tbody[1]/tr[1]/td[5]/a[2]/span")
    public WebElement shareDocumentLink;                              // Иконка шаринга документа

    @FindBy(xpath = "//table/tbody[1]/tr[2]/td/div/center/div//form/div[1]/div/input")
    public WebElement nameOfRecipientField;                           // Поле ввода ФИО для шаринга

    @FindBy(xpath = "//tbody[1]/tr[2]/td/div/center//div/form/div[6]/button")
    public WebElement getCodeButton;                                  // Кнопка получения кода

    @FindBy(id = "link")
    public WebElement codeField;                                       // Поле с отображением кода

    @FindBy(xpath = "//button[contains(@ng-click,'close()')]")
    public WebElement okButton;                                        // Кнопка ОК форме отображения кода

    @FindBy(xpath = "//label[@for='link']")
    public WebElement alertInfoBlock;                                // Инфо на всплывающем окне


    @FindBy(xpath = "//input[@id='phone']")
    public WebElement phoneField;                                // поле ввода телефона

    @FindBy(xpath = "//tbody[1]/tr[2]/td/div/center/div//form/div[5]/div/input")
    public WebElement emailField;                                // поле ввода почты


    @FindBy(xpath = "//tbody[1]/tr[2]/td/div/center/div//form/div[3]/label[2]")
    public WebElement yesRadioButton;                                // поле ввода почты




// =================== Элементы таба "Поиск за кодом" ===================//

    @FindBy(xpath = "//a[@href='/documents/search']")
    public WebElement searchWithCodeTab;                             // Таб  поиска документов

    @FindBy(id = "code")
    public WebElement inputCodeField;                                 // Поле ввода  кода доступа

    @FindBy(id = "typeId")
    public WebElement typeDocumentSelector;                            // Селектор выбора документа

    @FindBy(id = "operatorId")
    public WebElement operatorSelector;                                // Селектор выбора оператора

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement searchDocumentButton;                            // Кнопка поиска документа

    @FindBy(xpath = "//a[contains(.,'Завантажити')]")
    public WebElement downloadLink;                                    // Ссылка загрузки найденного документа

    @FindBy(id = "smsPass")
    public WebElement inputSMSCodeField;                                // Пооле ввода паоля из СМС

    @FindBy(xpath = "//button[@ng-disabled='!smsPass']")
    public WebElement confirmDocumentButton;                            // Ссылка загрузки найденного документа по смс


    @FindBy(xpath = "//label[@for='smsPass']")
    public WebElement infoBlockSMS;                                       // Блок sms инфо


    @FindBy(xpath = " //div[@role='alert']")
    public WebElement errorBlockSMS;                                       // Блок sms erorr


// =================== Элементы таба "Нотариус" ===================//

    @FindBy(xpath = "//a[@href='/documents/notary']")
    public WebElement notaryTab;                                       // Таб "Нотариусам"

    @FindBy(xpath = "//div[2]/div[2]/div/div/div/div")
    public WebElement notaryInfoBlock;                                    // Инфо блок



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

// refresh Page
    public void refreshPage (){
    driver.navigate().refresh();

    }



    public void  goToNotaryTab (){
     notaryTab.click();
    }


//==================================================================
public void getAccessCode(String name){
            clickShareDocumentLink();
            fillNameOfRecipientField(name);
            clickGetCodeButton();
            saveCodeToAVariable();
            clickOkButton();
}



    public void getAccessCodeWithPhoneEmail(String name) {
        clickShareDocumentLink();
        fillNameOfRecipientField(name);
        yesRadioButton.click();
        typePhone();
        emailField.sendKeys(Constants.Settings.Data.E_MAIL);
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
                pause(2000);

    }


    public void isDocumentFound() {
        isElementPresent();

    }

    public void typePhone() {
        phoneField.clear();
        phoneField.sendKeys("+"+Constants.Settings.Data.Phone);
    }

    public void typeSMSCode() {
        inputSMSCodeField.sendKeys("11111");
        confirmDocumentButton.click();

    }


}


