package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserManagementPage extends BasePage {
	
	

	public UserManagementPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="xpath=\"//button[normalize-space()='Add']\"") WebElement AddUser_Btn;
	@FindBy(xpath="//label[text()='User Role']/ancestor::div[contains(@class,'oxd-input-group')] /following-sibling::div//i[contains(@class,'oxd-select-text--arrow')]")
	WebElement UserRole_Dropdown_Btn;
	@FindBy(xpath="//div[@role='listbox']//div[@role='option'][2]//span") WebElement AdminOption_Userrole;
	@FindBy(xpath="//label[text()='Status']/ancestor::div[contains(@class,'oxd-input-group')] /following-sibling::div//i[contains(@class,'oxd-select-text--arrow')]")
	WebElement Status_Dropdown_Btn;
	@FindBy(xpath="//span[normalize-space()='Enabled']")WebElement EnabledOption_Status;
	@FindBy(xpath="(//input[@type='password'])[1]") WebElement Password_Input;
	@FindBy(xpath="//label[contains(text(),'Employee Name')]/ancestor::div[contains(@class,'oxd-input-group')]//input")
	WebElement Employee_Name_Input;
	@FindBy(xpath="//label[contains(text(),'Username')]/ancestor::div[contains(@class,'oxd-input-group')]//input")
	WebElement Username_Input;
	@FindBy(xpath="xpath=\"//input[@class='oxd-input oxd-input--focus']\"") WebElement Confirm_Pwd_Input;
	@FindBy(xpath="xpath=\"//button[normalize-space()='Save']\"") WebElement Save_Btn;
	@FindBy(xpath="//div[@role='listbox']//div[@role='option']") List<WebElement> Employee_Name_Dropdown;
	
	
	
	
	
	
	
	

}
