package tests;


import static org.junit.Assert.*;
import org.testng.annotations.Test;
import driverLogic.TestBase;

public class AccessToDocumentByCodeTest extends TestBase {
	
	@Test
	public void getAccessToDocumentTest() throws Exception{
		
		app.getNavigationHelper().goToDocumentsPage();
		app.getBankIdAuthorizationHalper().initBankIdAuthorizationFromDocumentsPage();
		app.getBankIdAuthorizationHalper().privatBankAuthorization();
		app.getDocumentsHalper().getAccessCode("Test");
		assertTrue(app.getDocumentsHalper().isAccessCodeNotNull());
		app.getDocumentsHalper().searchDocumentWithCode();
		assertTrue(app.getDocumentsHalper().isDocumentFound());
		
		
		
		
		
	}
}