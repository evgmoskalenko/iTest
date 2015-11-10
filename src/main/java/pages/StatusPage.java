package pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import appLogic.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class StatusPage extends ApplicationManager {

    private WebDriver driver;


    public StatusPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    //    ------------------- Элементы ID Bank------------------------------//

    @FindBy(id = "code")
    public WebElement refIdField;          // кнопка входа в ИД Банк


    // =============================================== МЕТОДЫ  =================================================//


}
