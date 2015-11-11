package pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import appLogic.ApplicationManager;
import appLogic.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BankIdAuthorizationPage extends ApplicationManager {
    private WebDriver driver;


    public BankIdAuthorizationPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //    ------------------- Элементы ID Bank------------------------------//

    @FindBy(xpath = "//span[contains(.,'BankID')]")
    public WebElement BankID;          // кнопка входа в ИД Банк

    @FindBy(id = "privatBank")
    public WebElement privatBank;      // выбор ПриватБанка

    @FindBy(id = "loginLikePhone")
    public WebElement phone;           // поле логина Приват24

    @FindBy(id = "passwordLikePassword")
    public WebElement password;        // поле проля Приват24

    @FindBy(id = "confirmButton")
    public WebElement confirm;         // Кнопка перехода на шаг ОТР

    @FindBy(id = "first-section")
    public WebElement otpOne;         // первое поле ввода ОТР

    @FindBy(id = "second-section")
    public WebElement otpTwo;         // второе поле ввода ОТР

    @FindBy(id = "third-section")
    public WebElement otpThree;       // третье поле ввода ОТР

    @FindBy(id = "signInButton")
    public WebElement signIn;         //  кнопка входа после ввода ОТР

    //    ------------------- Элементы входа/выхода------------------------------//
    @FindBy(xpath = "//span[contains(.,'Дмитро Олександрович Дубілет')]")
    public WebElement fio;         //  ФИО клиента после входа


    @FindBy(xpath = "//span[contains(.,'Вийти')]")
    public WebElement logOutButton;         //  кнопка выхода



    public void logOut () {
        pause(3000);
        logOutButton.click();
         }



    //    ------------------- Метод проверки ФИО после входа  ------------------------------//
    public void verifyFIO () {
    Assert.assertEquals(fio.getText(), Constants.Settings.Data.FIO_UA); }

    //    ------------------- Метод ввода ОТР  ------------------------------//
    public void typeOTP ( ) {
        otpOne.sendKeys(Constants.Settings.BankIDprivatBank.OTP1);
        otpTwo.sendKeys(Constants.Settings.BankIDprivatBank.OTP2);
        otpThree.sendKeys(Constants.Settings.BankIDprivatBank.OTP3);
        confirm.click();

    }
    //    ------------------- Вибор метода входа - ИД Банк  ------------------------------//
    public void selectMethodBankID ( ) {
        BankID.click();

    }

    //    ------------------- Вибор Банка для входа  ------------------------------//
    public void selectPrivatBankBankID ( ) {
        privatBank.click();

    }

    //    ------------------- Метод ввода логина пароля ------------------------------//
    public void typeLoginPassword ( ) {
        phone.clear();
        phone.sendKeys(Constants.Settings.BankIDprivatBank.Login);
        password.sendKeys(Constants.Settings.BankIDprivatBank.Password);
        signIn.click();

    }

    public void privatBankAuthorization(){
                selectMethodBankID();
                selectPrivatBankBankID();
                typeLoginPassword();
                typeOTP();
                verifyFIO();
    }

}
