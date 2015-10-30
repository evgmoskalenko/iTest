package tests;




import org.testng.annotations.Test;
import driverLogic.TestBase;
import static org.junit.Assert.*;

public class SearchServiceTest extends TestBase {
	
	
	
	@Test
	public void simpleSearchArchivalCertificates() throws Exception {
	String service = "Видача архівних довідок, копій, витягів";
	app.getServiceHelper().searchService(service);
	assertTrue(app.getServiceHelper().isServiceFinded(service,service));
	}
	
	@Test
	public void simpledSearchMREO() throws Exception {
    String service = "Реєстрація авто з пробігом в МРЕВ";
	app.getServiceHelper().searchService(service);
        assertTrue(app.getServiceHelper().isServiceFinded(service,service));
	}
}
