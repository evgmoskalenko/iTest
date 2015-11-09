package pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import appLogic.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class ServicesPage extends ApplicationManager {

    private WebDriver driver;


    public ServicesPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //    ------------------- Элементы ID Bank------------------------------//

//    @FindBy(xpath = "//span[contains(.,'BankID')]")
//    public WebElement BankID;          // кнопка входа в ИД Банк


    // =============================================== МЕТОДЫ  =================================================//




}