package tests;

import org.testng.annotations.Test;
import driverLogic.TestBase;


public class SearchServiceTest extends TestBase {

	@Test
	public void simpleSearchArchivalCertificates() throws Exception {
	String service = "Видача архівних довідок, копій, витягів";
        mainPage.typeInSearchField(service);
//	assertTrue(app.typeInSearchField().isServiceFinded(service,service));
	}


}
