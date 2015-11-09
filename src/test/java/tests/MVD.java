package tests;

import appLogic.ApplicationManager;
import appLogic.Constants;
import driverLogic.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BankIdAuthorizationPage;
import pages.DocumentsPage;
import pages.MainPage;

/**
 * Created by Privat24 on 09.11.2015.
 */
public class MVD extends TestBase {


    @Test
    public void DnipropetrovskMVD() {
        // ------------------- Тестовые данные -------------------//
        String service = Constants.Settings.ServiceMVD.CriminalRecord;
        String region = Constants.Settings.Region.Dnipropetrovska;
        String city = Constants.Settings.City.Dnipropetrovsk;
        String getHelp = "Оформлення візи для виїзду за кордон.";
        // --------------------- Тест-кейс----------------------//
        mainPage.search(service);
        app.pause(5000);
        Assert.assertEquals(mainPage.services.getText(), service);
        mainPage.clickService(service);
        Assert.assertEquals(mainPage.service.getText(), service);
        mainPage.selectRegion(region);
        mainPage.selectCity(city);
        authorizationPage.privatBankAuthorization();
    }
}
