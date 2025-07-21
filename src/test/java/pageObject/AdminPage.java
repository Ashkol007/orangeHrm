package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AdminPage extends BasePage {

	public AdminPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(xpath="//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']") WebElement AdminHeading;
	@FindBy(xpath="(//div[@class='oxd-select-text--after'])[1]") WebElement UserRole_Dropdown;
	@FindBy(xpath="//div[@role='listbox']//div[@role='option' ]//span[contains(text(),'Admin')]") WebElement DropdownOpt_Admin;
	@FindBy(xpath="//button[@type='submit']") WebElement Submit_Btn;
	@FindBy(xpath="//div[@class='oxd-table-body']//div[@role='row']//div[3]//div[text()='Admin']") List<WebElement> UserRoleColumn;
	@FindBy(xpath="//div[@class='oxd-toast-content oxd-toast-content--info']//p[2]") WebElement Toast_NoRecordFound;
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--focus'])[1]") WebElement Input_Username;
	
	
	public Boolean isAdminHeading(){
		if(AdminHeading.isDisplayed()) return true;
		return false;
	}
	
	public void selectAdminDropDown() {
		await.until(ExpectedConditions.elementToBeClickable(UserRole_Dropdown)).click();

		await.until(ExpectedConditions.elementToBeClickable(DropdownOpt_Admin)).click();
	}
	
	public void clickSubmit() {
		await.until(ExpectedConditions.elementToBeClickable(Submit_Btn));
	}
	
	public Boolean isUserRoleAdmin() {
		
		for(WebElement userrole : UserRoleColumn) {
			userrole.getText().equalsIgnoreCase("Admin");
		}
		
		return true;
		}
	
	public Boolean isInvalidUser() {
		await.until(ExpectedConditions.visibilityOf(Toast_NoRecordFound));
		
		if(Toast_NoRecordFound.isDisplayed())return true;
		return false;
	}  
	
	public void setUserName(String name){

		Input_Username.sendKeys(name);
		
	}
	

}
