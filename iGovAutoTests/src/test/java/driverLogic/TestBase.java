package driverLogic;



import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import appLogic.ApplicationManager;



public class TestBase {
	
protected static ApplicationManager app;




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

	}
