package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashBoardPage extends BasePage {

	public DashBoardPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//div//h6[contains(text(),Dashboard)]") WebElement dashboard_title;
	
	
	public Boolean checkDashboardTitle() {
		if(dashboard_title.getText().equals("Dashboard")) return true;
		
		return false;
	}
	
	
	
}
