package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import driverLogic.TestBase;

public class MyLogTest extends TestBase {


	@Test
	public void myLogTest() throws Exception{
        mainPage.goToMyLog();
        Assert.assertEquals(logPage.formSignInBankId.getText(), "Щоб почати користуватись сервісом “Мій журнал”, увійдіть через BankID\n" +
                "Сертифікат електронно-\n" +
                "цифрового підпису");
        authorizationPage.privatBankAuthorization();
        Assert.assertEquals(logPage.myLog.getText(), "Мій журнал");
        Assert.assertEquals(logPage.nextLink.getText(), "Показати ще");
        authorizationPage.logOut();
        mainPage.goToMyLog();
        Assert.assertEquals(logPage.formSignInBankId.getText(), "Щоб почати користуватись сервісом “Мій журнал”, увійдіть через BankID\n" +
                "Сертифікат електронно-\n" +
                "цифрового підпису");


	}

	
}
