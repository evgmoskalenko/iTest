package appLogic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import org.testng.Reporter;
import pages.PageManager;

import java.util.*;

public abstract class DriverBasedHelper {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected PageManager pages;

	public DriverBasedHelper(WebDriver driver){
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
		pages = new PageManager(driver);
	}
	
	
	
	
	//===========================click method==================================//
    public void click(By locator) {
		driver.findElement(locator).click();
	}   
	
	//========================select method======================================================//
    public void selectByVisibleText(String locator, String goal) {
		new Select(driver.findElement(By.id(locator))).selectByVisibleText(goal);
	}
	//========================select country method===============================================//
    protected void selectValue(By locator, By linkText) {
		click(locator);
		click(linkText);
	} 


	//================================data input method===============================//
    public void type(By locator, String text) {
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(text);
	}


    public static void addErrorToTheReport(String testName) throws Exception
    {
        Reporter.log("<b><font color=\"red\" size=\"3\">" + testName + "</font></b><br>");
    }

    public Calendar getCurrentCalendar()
    {
        // http://docs.oracle.com/javase/6/docs/api/java/util/GregorianCalendar.html
        // get the supported ids for GMT+02:00 ("Среднеевропейское (Центральноевропейское) летнее время")

        String[] ids = TimeZone.getAvailableIDs(+2 * 60 * 60 * 1000);
        // if no ids were returned, something is wrong. get out.
        if (ids.length == 0) System.exit(0);
        // create a (CEST - Central Europe Summer Time Zone) UTC/GMT+2 time zone
        SimpleTimeZone GMT = new SimpleTimeZone(+2 * 60 * 60 * 1000, ids[0]);
        // create a GregorianCalendar with the current date and time
        Calendar calendar = new GregorianCalendar(GMT);
        Date trialTime = new Date();
        calendar.setTime(trialTime);
        //// print out a bunch of interesting things
        // System.out.println("YEAR: " + calendar.get(Calendar.YEAR));
        // System.out.println("MONTH: " + calendar.get(Calendar.MONTH));
        // System.out.println("DATE: " + calendar.get(Calendar.DATE));
        // System.out.println("HOUR_OF_DAY: " + calendar.get(Calendar.HOUR_OF_DAY));
        // System.out.println("MINUTE: " + calendar.get(Calendar.MINUTE));
        // System.out.println("SECOND: " + calendar.get(Calendar.SECOND));
        // System.out.println("MILLISECOND: " + calendar.get(Calendar.MILLISECOND));
        //
        // System.out.println("Current Time, with hour reset to 3");
        // calendar.clear(Calendar.HOUR_OF_DAY); // so doesn't override
        // calendar.set(Calendar.HOUR, 3);
        return calendar;

    }



}
