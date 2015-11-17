package ServicePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import appLogic.ApplicationManager;

public class InternationalPassportPage extends ApplicationManager {
	
	private  WebDriver driver;
	
    public InternationalPassportPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //---------------- Элементы страницы------------------// 
    
    @FindBy(xpath = "//div[@class='service-name ng-binding']")
    public WebElement serviceName; // название услуги
    
    @FindBy(name = "have_passport")
    public WebElement havePassportField; // поле "У Вас на даний момент є загранпаспорт?"
    
    @FindBy(name= "biometrical")
    public WebElement biometricalField; // поле "Ви бажаєте замовити біометричний паспорт?"
    
    @FindBy(name = "phone")
    public WebElement phoneField;// поле ввода телефона
    
    @FindBy(name = "email")
    public WebElement emailField; //поле эмейла
    
    @FindBy(name = "area")
    public WebElement areaField; // поле выбора раённого отделения
    
    @FindBy(xpath = "//select[@ng-model='selected.date']")
    public WebElement dayField; // поле выбора даты визита
    
    @FindBy(xpath = "//select[@ng-disabled='!selected.date || slotsLoading']")
    public WebElement timeField; // поле выбора времени визита
    
    @FindBy(xpath = "//button[@class='btn btn-info']")
    public WebElement confirmButton; // кнопка подтверждения создания услуги
    
    @FindBy(xpath = "//div[@class='text-center ng-binding ng-scope']")
    public WebElement successText; //текст удачной создании заявки
    
    @FindBy(xpath = "//div[@class='text-center ng-binding']")
    public WebElement referenceNumberField; //поле референс заявки

    public static String referenceNumber;
    
    //---------------- Методы ввода данных в поля------------------//
    
    public InternationalPassportPage selectHavePassport(String havePassport){
    	new Select(havePassportField).selectByVisibleText(havePassport);
    	 return this;
        }

	public InternationalPassportPage selectBiometrical(String biometrical) {
	    new Select(biometricalField).selectByVisibleText(biometrical);
		return this;
	}
    public InternationalPassportPage typeInPhoneField(String phone){
    	phoneField.sendKeys(phone); // ввод телефона
    	 return this;
    }	 
    public InternationalPassportPage typeInEmailField(String email){
    	emailField.clear();
    	emailField.sendKeys(email); // ввод емайла
    	 return this;
        }

	public InternationalPassportPage selectArea(String area) {
		new Select(areaField).selectByVisibleText(area);
		return this;
	}

	public InternationalPassportPage selectDay() {
		new Select(dayField).selectByValue("0");
		return this;
	}

	public InternationalPassportPage selectTime() {
		new Select(timeField).selectByValue("0");
		pause(1000);
		return this;
	}
	
	public InternationalPassportPage clickConfirmButton(){
    	confirmButton.click(); //нажать конпку подтверждения создания услуги
    	return this;
    }
    public InternationalPassportPage verifyServiceSuccessCreated(){
    	successText.isDisplayed();// проверка успешного создания заявки
    	return this;
    }
//=================методы по работе с номером заявки=======================//
    
    public String saveReferenceNumber(){
    	String refField = referenceNumberField.getText();
    	setReferenceNumber(refField.substring(16,23));
		return getReferenceNumber();
    }

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		InternationalPassportPage.referenceNumber = referenceNumber;
	}
    
}
