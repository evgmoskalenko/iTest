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
import pages.SelectAreaPage;;


public class MVD extends TestBase {


    @Test
    public void DnipropetrovskMVD() {
        // ------------------- Тестовые данные -------------------//
        String service = Constants.Settings.ServiceMVD.CriminalRecord;
        String region = Constants.Settings.Region.Dnipropetrovska;
        String city = Constants.Settings.City.Dnipropetrovsk;
        String getHelp = "Оформлення візи для виїзду за кордон.";
        // --------------------- Тест-кейс----------------------//
        mainPage.typeInSearchField(service);
        app.pause(5000);
        //Assert.assertEquals(mainPage.services.getText(), service);
        mainPage.clickService(service);
        Assert.assertEquals(selectAreaPage.serviceName.getText(), service);
        selectAreaPage.selectRegion(region);
        selectAreaPage.selectCity(city);
        authorizationPage.privatBankAuthorization();
    }
}
