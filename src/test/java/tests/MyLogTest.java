package tests;

import org.testng.annotations.Test;
import driverLogic.TestBase;

public class MyLogTest extends TestBase {


	@Test
	public void myLogTest() throws Exception{

//        navigator.goToMyLogPage();

        authorizationPage.privatBankAuthorization();
//        servicePage.isMyLogDisplayed();
	}

	
}
