package appLogic;

public class BankIdAuthorizationHalper extends DriverBasedHelper{


public BankIdAuthorizationHalper(ApplicationManager manager) {
		    super(manager.getWebDriver());
		  }


    //    ------------------- Авторизация через Банк ИД ПриватБанк ------------------------------//
public void privatBankAuthorization(){
	pages.bankIdAuthorizationPage
            .selectMethodBankID()
            .selectPrivatBankBankID()
            .typeLoginPassword()
            .typeOTP();
    }

}
