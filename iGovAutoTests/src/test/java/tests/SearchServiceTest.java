package tests;




import org.testng.annotations.Test;
import driverLogic.TestBase;
import static org.junit.Assert.*;

public class SearchServiceTest extends TestBase {
	
	
	
	@Test
	public void simpleValidSearchTest() throws Exception {
	String service = "Видача архівних довідок, копій, витягів";
	app.getServiceHelper().searchService(service);
	assertTrue(app.getServiceHelper().isServiceFinded(service,service));
	}
	
	//@Test Не работает.Нет идентификатора, который покажет что страница пустая(или я его не знаю)
	public void simpleInvalidSearchTest() throws Exception {
	app.getServiceHelper().searchService("Видача копій, витягів з розпоряджень міського голови, рішень, прийнятих міською радою та виконавчим комітетом");
	assertTrue(app.getServiceHelper().isServiceNotFinded());
	}
}
