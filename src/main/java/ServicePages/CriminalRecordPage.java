package ServicePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import appLogic.ApplicationManager;

public class CriminalRecordPage extends ApplicationManager {
	private  WebDriver driver;

    public CriminalRecordPage (WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    
    //---------------- Элементы страницы------------------//
    
    @FindBy(xpath = "//div[@class='service-name ng-binding']")
    public WebElement serviceName; // название услуги
    
    @FindBy(name = "birthDate")
    public WebElement birthDateField; // поле даты рождения

    @FindBy(name = "birthLoc")
    public WebElement birthLocField; // поле места рождения

    @FindBy(name = "country")
    public WebElement countryField; // поле гражданства

    @FindBy(name = "goal")
    public WebElement goalField; // поле цели получения документа

    @FindBy(name = "phone")
    public WebElement phoneField;// поле ввода телефона

    @FindBy(name = "res_type")
    public WebElement resTypeField; // поле результата оработки обращения

    @FindBy(name = "email")
    public WebElement emailField; //поле эмейла
    
    @FindBy(xpath = "//button[@class='btn btn-info']")
    public WebElement confirmButton; // кнопка подтверждения создания услуги
    
    @FindBy(xpath = "//div[@class='text-center ng-binding ng-scope']")
    public WebElement successText; //текст удачной создании заявки
    
    @FindBy(xpath = "//div[@class='text-center ng-binding']")
    public WebElement referenceNumberField; //поле референс заявки

    public static String referenceNumber;
    
    
    //---------------- Методы ввода данных в поля------------------//   

    public CriminalRecordPage typeInBirthDateField(String birthDate){
    	birthDateField.clear();
    	birthDateField.sendKeys(birthDate); // ввод даты рождения
    	 return this;
        }
    
    public CriminalRecordPage typeInBirthLocField(String birthLoc){
    	birthLocField.clear();
    	birthLocField.sendKeys(birthLoc); // ввод места рождения
    	 return this;
        }
    
    public CriminalRecordPage selectСountry(String сountry){
    	countryField.click();//выбор гражданства
    	driver.findElement(By.linkText(сountry)).click();
    	    return this;
    	      }
    public CriminalRecordPage selectGoal(String goal){
    	new Select(goalField).selectByVisibleText(goal);  //выбор цели получения документа
    	    return this;
    	      }
    public CriminalRecordPage typeInPhoneField(String phone){
    	phoneField.sendKeys(phone); // ввод телефона
    	 return this;
        }
    public CriminalRecordPage selectResType(String resType){
    	new Select(resTypeField).selectByVisibleText(resType);  //выбор результата оработки обращения
    	    return this;
    	      }
    public CriminalRecordPage typeInEmailField(String email){
    	emailField.clear();
    	emailField.sendKeys(email); // ввод емайла
    	 return this;
        }
    public CriminalRecordPage clickConfirmButton(){
    	confirmButton.click(); //нажать конпку подтверждения создания услуги
    	return this;
    }
    public CriminalRecordPage verifyServiceSuccessCreated(){
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
		CriminalRecordPage.referenceNumber = referenceNumber;
	}
    
    
    
  
}
