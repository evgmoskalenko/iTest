package pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import org.openqa.selenium.By;

public class AboutPortal extends Page {
	
	public AboutPortal(PageManager pages){
		super(pages);
	}
	public AboutPortal ensurePageLoaded(){
		super.ensurePageLoaded();
		wait.until(presenceOfElementLocated(By.xpath("/html/body/div/div[2]/div/div/div/div/p[1]")));
		return this;
	}

}
