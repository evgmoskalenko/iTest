package tests;

import org.testng.annotations.Test;
import driverLogic.TestBase;

public class FooterTest extends TestBase {


	@Test
	public void portalsNewsOnFacebookLinkTest () {
        mainPage.clickServicesLink();
        app.verifyTextPresent("Громадянам");
    }



}

