package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import driverLogic.TestBase;


public class MainPage extends TestBase {

	@Test
	public void simpleSearchArchivalCertificates() throws Exception {
	String service = "Видача архівних довідок, копій, витягів";
        mainPage.typeInSearchField(service);
        app.pause(4000);
        Assert.assertEquals(mainPage.services.getText(), service);
	}


    @Test
    public void availabilityStatisticTab() throws Exception {
        // ------------------- Тестовые данные -------------------//
        String service = "Надання довідки про відсутність (наявність) судимості або обмежень, передбачених кримінально-процесуальним законодавством";
        String serviceTab = "Статистика";
        String taimingColumn = "Таймінг ?";
        String taimingRow = "годин";
        String numberOfServicesProvidedColumn = "Кількість наданих послуг";
        String regionRow = "Дніпропетровська";

        // --------------------- Тест-кейс----------------------//
        mainPage.typeInSearchField(service);
        app.pause(4000);
        mainPage.clickService(service);
        Assert.assertEquals(selectAreaPage.serviceName.getText(), service);
        selectAreaPage.clickServiceTab(serviceTab);
        Assert.assertEquals(statisticTab.taimingColumn.getText(), taimingColumn);
        Assert.assertTrue(statisticTab.taimingRow.getText().contains(taimingRow));
        Assert.assertEquals(statisticTab.numberOfServicesProvidedColumn.getText(), numberOfServicesProvidedColumn);
        Assert.assertEquals(statisticTab.regionRow.getText(), regionRow);
    }
}
