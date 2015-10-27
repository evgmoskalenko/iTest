package driverLogic;



import java.io.File;
import java.io.FileReader;
import java.util.Calendar;
import java.util.Properties;

import appLogic.Screen;
import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import appLogic.ApplicationManager;



public class TestBase {
	
protected static ApplicationManager app;
private static WebDriver driver;



	@BeforeSuite
	public void setUp() throws Exception {

		Properties properties = new Properties();
		properties.load(new FileReader(new File("application.properties")));
		app = new ApplicationManager(properties);
	    
	  }
	

	@AfterSuite
	public void tearDown() throws Exception {
		app.stop();

	    }
	@AfterClass
	public void afterMethod() throws Exception{
		app.signOut();
	}
	@BeforeClass
	public void beforeMethod()throws Exception{
		app.mainPage();
	}

    @AfterMethod(alwaysRun = true)
    public void takeScreenshot(ITestResult result) throws Exception
    {
        //Для того чтобы передавать html теги и спец-символы в reporter.log
        //Или можно передать параметр в командную строку при выполнении TestNG:
        //-Dorg.uncommons.reportng.escape-output=false
        System.setProperty("org.uncommons.reportng.escape-output", "false");

        Reporter.setCurrentTestResult(result);

        //Create a directory; all non-existent ancestor directories are
        //automatically created
        boolean success = (new File("TestReport/html/Screens/")).mkdirs();
        if (!success)
        {
            //Directory creation failed
            //System.out.println("Directory creation failed. Папка уже создана?");
        }

        Calendar calendar = new Screen().getCurrentCalendar();
        String SuccsessLogMessage =
                "The test - \"" +
                        result.getMethod().getMethodName().toString() +
                        "\" was successfully ended" +
                        "(" +
                        calendar.get(Calendar.DATE) +
                        "." +
                        (calendar.get(Calendar.MONTH)+1) +
                        "." +
                        calendar.get(Calendar.YEAR) +
                        " " +
                        calendar.get(Calendar.HOUR_OF_DAY) +
                        ":" +
                        calendar.get(Calendar.MINUTE) +
                        ":" +
                        calendar.get(Calendar.SECOND) +
                        ")";

        String ErrorLogMessage =
                "The test - \"" +
                        result.getMethod().getMethodName().toString() +
                        "\" was failed!" +
                        "(" +
                        calendar.get(Calendar.DATE) +
                        "." +
                        (calendar.get(Calendar.MONTH) + 1) +
                        "." +
                        calendar.get(Calendar.YEAR) +
                        " " +
                        calendar.get(Calendar.HOUR_OF_DAY) +
                        ":" +
                        calendar.get(Calendar.MINUTE) +
                        ":" +
                        calendar.get(Calendar.SECOND) +
                        ")";

        try
        {
            if (!result.isSuccess())
            {
                File screenshot1 = new File("TestReport/html/Screens/" +result.getMethod().getMethodName() + ".png");
                screenshot1.delete();
                File screenshotTempFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                try
                {
                    Files.copy(screenshotTempFile, screenshot1);
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
                Reporter.log(
                        "<center>Скриншот снят при падении теста " +
                                screenshot1.getName() +
                                ", URL = " +
                                driver.getCurrentUrl() +
                                "<br><div><a target=\"_blank\" href=\"Screens/" +
                                result.getMethod().getMethodName() +
                                ".png\"><img  style=\"height:400px; width: 600px;\"  src=\"" + "Screens/" +
                                result.getMethod().getMethodName() +
                                ".png" +
                                "\"></a></div><center><br><br>",
                        true);
                System.out.println(ErrorLogMessage);
            }
            else
            {
                System.out.println(SuccsessLogMessage);
                Reporter.log(SuccsessLogMessage);
            }
        }
        catch (Exception e)
        {
            new Screen().addErrorToTheReport("Connection with browser was lost.");
        }
    }



	}
