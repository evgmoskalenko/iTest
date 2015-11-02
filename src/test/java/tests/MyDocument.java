package tests;


import static org.junit.Assert.*;


import com.sun.xml.internal.bind.v2.TODO;
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
        app.getBankIdAuthorizationHalper().privatBankAuthorization();                  // Войти через Bank ID
        app.getDocumentsHalper().getAccessCode("Test");                                // Выбрать документ и разшарил
        assertTrue(app.getDocumentsHalper().isAccessCodeNotNull());                    // Сохранить код
                                                                                       // TODO выйти из акк
                                                                                       // TODO проверить что вышел (наличие авторизации в меню документов)
        app.getDocumentsHalper().searchDocumentWithCode();                             // Переход на поиск по коду , ввести код
        assertTrue(app.getDocumentsHalper().isDocumentFound());                        // Проверка , что появилась кнопка загрузки и разшариный документ
    }

    // TODO
    // -- ППРОВЕРКА ШАРИНГА ДОКУМЕНТОВ С ВВОДОМ ПОЧТЫ -- //
    // Войти на страницу документов
    // Войти через Bank ID
    // Выбрать документ, ввести ФИО и почту/разшарить
    // Сохранить код
    // Выйти из акк /обновить страницу
    // Проверить наличие кнопок для входа в ИД Банк ЭЦП
    // Переход на поиск по коду , ввести код
    // Проверка , что появилась кнопка загрузки и разшариный документ

    // TODO
    // -- ППРОВЕРКА ШАРИНГА ДОКУМЕНТОВ С ВВОДОМ НОМЕРА ТЕЛЕФОНА -- //
    // Войти на страницу документов
    // Войти через Bank ID
    // Выбрать документ, ввести ФИО и телефон
    // Сохранить код
    // Выйти из акк /обновить страницу
    // Проверить наличие кнопок для входа в ИД Банк ЭЦП
    // Переход на поиск по коду , ввести код
    // Проверить что появилось поле ввода номера телефона
    // Ввести любой код
    // Проверка наличие ошибки "Неправильний код"

    @Test
    public void uploadDocumentTest() throws Exception {
        String document = "src/resources/Квитанция.txt";
        app.getNavigationHelper().goToDocumentsPage();
        app.getBankIdAuthorizationHalper().privatBankAuthorization();
        app.getDocumentsHalper().isDocumentUpload(document);
        app.getDocumentsHalper().saveDocument();     // дописать выбор нужного документа в DocumentsPage
        //TODO  дописать тест:
        // Проверить что появился новый загруженный документ
        // Выйти из акк /обновить страницу
        // Проверить наличие кнопок для входа в ИД Банк ЭЦП

    }

    // TODO
    // -- ПРОВЕРКА ВХОДА/ВЫХОДА ИЗ МЕНЮ ДОКУМЕНТОВ -- //
    // Войти на страницу документов
    // Проверить наличие кнопок для входа в ИД Банк ЭЦП
    // Войти через Bank ID
    // Проверить наличие полей : Документа/Дата завантаження копії/Ким завантажена копія/Автор ЕЦП/Дії   и кнопки "Добавить документ"
    // Выйти из акк /обновить страницу
    // Проверить наличие кнопок для входа в ИД Банк ЭЦП


    // TODO
    // -- ПРОВЕРКА ВКЛАДКИ НОТАРИУС -- //
    // Войти на страницу документов
    // Проверить наличие вкладок "Мои документи" "Поиск за кодом" "Нотариус"
    // Кликнуть по вкладке  "Нотариус"
    // Проверить наличие текста "Тут нотаріуси зможуть..."


    // TODO ЭТО БУДЕ ПОЗЖЕ ... (пока не трогать)
    // -- ПРОВЕРКА ЗАГРУЗКИ КОПИИ ДОКУМЕНТА -- //
    // Войти на страницу документов
    // Проверить наличие кнопок для входа в ИД Банк ЭЦП
    // Войти через Bank ID
    // Проверить наличие иконки загрузки копии документа
    // Кликнуть по иконке занрузки паспорта
    // Проверить что файл загрузилска корретный
    // Выйти из акк /обновить страницу
    // Проверить наличие кнопок для входа в ИД Банк ЭЦП




}