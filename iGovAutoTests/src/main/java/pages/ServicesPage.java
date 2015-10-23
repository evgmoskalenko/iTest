package pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import org.openqa.selenium.By;


public class ServicesPage extends Page {
	
	public ServicesPage(PageManager pages){
		super(pages);
		}
	public ServicesPage ensurePageLoaded(){
		super.ensurePageLoaded();
		wait.until(presenceOfElementLocated(By.xpath("/html/body/div/div[2]/div/div/div[3]/div[1]/h1")));
		return this;
	}
}