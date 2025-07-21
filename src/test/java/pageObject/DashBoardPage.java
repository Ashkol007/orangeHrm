package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashBoardPage extends BasePage {

	public DashBoardPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//div//h6[contains(text(),Dashboard)]") WebElement dashboard_title;
	@FindBy(xpath="//span[@class='oxd-userdropdown-tab']") WebElement logout_dropdown;
	@FindBy(xpath="//a[normalize-space()='Logout']") WebElement logout_btn;
	@FindBy(xpath="//a[@href='/web/index.php/admin/viewAdminModule']") WebElement Admin_Tab;
	
	
	public Boolean checkDashboardTitle() {
		if(dashboard_title.getText().equals("Dashboard")) return true;
		
		return false;
	}
	
	public void logout() {
		await.until(ExpectedConditions.elementToBeClickable(logout_dropdown)).click();
		await.until(ExpectedConditions.elementToBeClickable(logout_btn)).click();
	}
	
	public String getUrl() {
		return driver.getCurrentUrl();
	}
	
	public void goToAdminPage() {
		await.until(ExpectedConditions.elementToBeClickable(Admin_Tab)).click();
	}
	
	
}
