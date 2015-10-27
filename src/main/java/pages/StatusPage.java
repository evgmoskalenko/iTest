package pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import org.openqa.selenium.By;


public class StatusPage extends Page {
	public StatusPage(PageManager pages){
		super(pages);
	}
	public StatusPage ensurePageLoaded(){
		super.ensurePageLoaded();
		wait.until(presenceOfElementLocated((By.xpath("/html/body/div/div[2]/div/div/div/div/div/div[1]/div/p"))));
		return this;
	}


}
