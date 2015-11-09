package pages;


import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.AssertJUnit.assertEquals;

import appLogic.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class MainPage extends ApplicationManager {


    private  WebDriver driver;

    public MainPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

//----------------  Верхние табы ------------------//
@FindBy(xpath = "//input[@ng-change='search()']")
public WebElement searchField;

@FindBy(xpath = "//h4[contains(.,'Послуги')]")
public WebElement servicesLink;

@FindBy(xpath = "//h4[contains(.,'Документи')]")
public WebElement documentsLink;

@FindBy(xpath = "//h4[contains(.,'Статуси')]")
public WebElement statusLink;

@FindBy(xpath = "//h4[contains(.,'Мій журнал')]")
public WebElement myLogLink;

@FindBy(xpath = "//h4[contains(.,'Про портал')]")
public WebElement aboutPortalLink;


//----------------  Футер ------------------//

@FindBy(xpath = "//a[contains(@href,'https://igov.org.ua/ecp')]")
public WebElement checkElectronDigitalSignatureLink;

@FindBy(xpath = "//footer/div/div/div[3]")
public WebElement portalsNewsOnFacebookLink;

@FindBy(xpath = "//a[contains(@href, 'https://docs.google.com/forms/d/1zyLyRcsL0wnB_VQeondrULHsEUi1dIaUSLJVWsdzbDY/viewform')]")
public WebElement noSuchServicesLink;

@FindBy(xpath = "//a[contains(@href, 'https://docs.google.com/forms/d/1ueU6PQa-OSA2Tsisxx2RbRWRJ9rLsFlPBlHsr7W-4gE/viewform')]")
public WebElement errorOrABugOnThePortalLink;

@FindBy(xpath = "//a[contains(@href, 'https://github.com/e-government-ua/i/wiki/%D0%AF%D0%BA-%D0%BF%D0%BE%D1%87%D0%B0%D1%82%D0%B8-%D1%80%D0%BE%D0%B1%D0%BE%D1%82%D1%83')]")
public WebElement joinOnGitHubLink;

@FindBy(xpath = "//a[contains(@href, 'https://github.com/e-government-ua/iForum/issues')]")
public WebElement commentsAndOpportunitiesLink;

//---------------- Выбор сервиса по региону  ------------------//
@FindBy(css = "button.btn.btn-default")
public WebElement regions;         // выпадающий список региона

    @FindBy(xpath = "(//button[@type='button'])[3]")
    public WebElement cities;          // выпадающий список города

    @FindBy(css = "p.ng-scope > a.ng-binding")
    public WebElement services ;         // название сервисов на главной странице

    @FindBy(xpath = "//div[@class='ng-binding']")
    public WebElement service;             // сервис на  странице выбора региона шаг №1

    //---------------- {что-то еще}  ------------------//


    //    ------------------- Метод выбора цели получения заявки -----------------------//
    public void selectGetHelp (String getHelp) {
        driver.findElement(By.xpath("//option[@label='"+getHelp+"']")).click();
    }


    //    ------------------- Метод выбора услуги  ------------------------------//
    public void clickService (String service ) {
        driver.findElement(By.xpath("//a[contains(.,'"+service+"')]")).click();
    }

    //    ------------------- Метод выбора региона  ------------------------------//
    public void selectRegion (String region) {
        regions.click();
        driver.findElement(By.xpath("//a[contains(text(),'"+region+"')]")).click();
    }


    //    ------------------- Метод выбора города  ------------------------------//
    public void selectCity (String city) {
        cities.click();
        driver.findElement(By.linkText(city)).click();
    }

    //    ------------------- Метод поиска услуги  ------------------------------//
    public void search (String service) {
        searchField.clear();
        searchField.sendKeys(service);
    }

    public void typeInSearchField(String text){
	searchField.clear();
	searchField.sendKeys(text);

}
public void clickServicesLink(){
	servicesLink.click();

}
public void goToDocuments(){
	documentsLink.click();

}
public void clickStatusLink(){
	statusLink.click();

}
public void clickMyLogLink(){
	myLogLink.click();

}
public void clickAboutPortalLink(){
	aboutPortalLink.click();

}





}






