package tests;


import static org.junit.Assert.*;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import driverLogic.TestBase;
import pages.DocumentsPage;

import javax.swing.text.Document;
import java.io.File;

public class MyDocument extends TestBase {


    @Test
    public void getAccessToDocumentTest() throws Exception {                           // -- ПРОВЕРКА ШАРИНГА ДОКУМЕНТОВ -- //
        app.getNavigationHelper().goToDocumentsPage();                                 // Войти на страницу документов
        app.getBankIdAuthorizationHalper().initBankIdAuthorizationFromDocumentsPage(); // Перейти по Bank ID
        app.getBankIdAuthorizationHalper().privatBankAuthorization();                  // Войти через Bank ID
        app.getDocumentsHalper().getAccessCode("Test");                                // Выбрать документ и разшарил
        assertTrue(app.getDocumentsHalper().isAccessCodeNotNull());                    // Сохранить код
        app.getDocumentsHalper().searchDocumentWithCode();                             // Переход на поиск по коду , ввести код
        assertTrue(app.getDocumentsHalper().isDocumentFound());                        // Проверка , что появилась кнопка загрузки
    }

    @Test
    public void uploadDocumentTest() throws Exception {
        String document = "src/resources/Квитанция.txt";
        app.getNavigationHelper().goToDocumentsPage();
        app.getBankIdAuthorizationHalper().initBankIdAuthorizationFromDocumentsPage(); // Перейти по Bank ID
        app.getBankIdAuthorizationHalper().privatBankAuthorization();
        app.getDocumentsHalper().isDocumentUpload(document);
        app.getDocumentsHalper().saveDocument();

    }

}