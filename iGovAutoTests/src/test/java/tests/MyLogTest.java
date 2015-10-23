package tests;

import static org.junit.Assert.assertTrue;

import org.testng.annotations.Test;


import driverLogic.TestBase;

public class MyLogTest extends TestBase {
	
	@Test
	public void myLogTest() throws Exception{
		
		app.getNavigationHelper().goToMyLogPage();
		app.getBankIdAuthorizationHalper().initBankIdAuthorizationFromMyLogPage();
		app.getBankIdAuthorizationHalper().privatBankAuthorization();
		assertTrue(app.getServiceHelper().isMyLogDisplayed("Мій журнал"));
		
		
		
		
	}

	
}
