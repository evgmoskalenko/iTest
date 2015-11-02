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


    //    ------------------- Метод ввода ОТР  ------------------------------//
    public BankIdAuthorizationPage typeOTP ( ) {
        otpOne.sendKeys("12");
        otpTwo.sendKeys("34");
        otpThree.sendKeys("56");
        confirm.click();
        return pages.bankIdAuthorizationPage;
    }
    //    ------------------- Вибор метода входа - ИД Банк  ------------------------------//
    public BankIdAuthorizationPage selectMethodBankID ( ) {
        BankID.click();
        return pages.bankIdAuthorizationPage;
    }

    //    ------------------- Вибор Банка для входа  ------------------------------//
    public BankIdAuthorizationPage selectPrivatBankBankID ( ) {
        privatBank.click();
        return pages.bankIdAuthorizationPage;
    }

    //    ------------------- Метод ввода логина пароля ------------------------------//
    public BankIdAuthorizationPage typeLoginPassword ( ) {
        phone.clear();
        phone.sendKeys("+380102030405");
        password.sendKeys("value");
        signIn.click();
        return pages.bankIdAuthorizationPage;
    }

}
