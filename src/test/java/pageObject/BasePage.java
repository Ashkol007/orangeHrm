package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

//	
	public  WebDriver driver;
	public  WebDriverWait await;
	
	public BasePage(WebDriver driver) {
		this.await =  new WebDriverWait(driver,Duration.ofSeconds(10));
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	
	
}
