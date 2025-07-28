package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserManagementPage extends BasePage {
	
	

	public UserManagementPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//button[normalize-space()='Add']") WebElement AddUser_Btn;
	@FindBy(xpath="//label[text()='User Role']/ancestor::div[contains(@class,'oxd-input-group')] /following-sibling::div//i[contains(@class,'oxd-select-text--arrow')]")
	WebElement UserRole_Dropdown_Btn;
	@FindBy(xpath="//div[@role='listbox']//div[@role='option'][2]//span") WebElement AdminOption_Userrole;
	@FindBy(xpath="//label[text()='Status']/ancestor::div[contains(@class,'oxd-input-group')] /following-sibling::div//i[contains(@class,'oxd-select-text--arrow')]")
	WebElement Status_Dropdown_Btn;
	@FindBy(xpath="//span[normalize-space()='Enabled']")WebElement EnabledOption_Status;
	@FindBy(xpath="(//input[@type='password'])[1]") WebElement Password_Input;
	@FindBy(xpath="//input[@placeholder='Type for hints...']")WebElement Employee_Name_Input;
    @FindBy(xpath="//div[@role='listbox']") WebElement Employee_Name_Dropdown;
    @FindBy(xpath="//div[@role='option'][1]") WebElement Employee_Option;
	@FindBy(xpath="//label[contains(text(),'Username')]/ancestor::div[contains(@class,'oxd-input-group')]//input")
	WebElement Username_Input;
	@FindBy(xpath="(//input[@type='password'])[2]") WebElement Confirm_Pwd_Input;
	@FindBy(xpath="//button[normalize-space()='Save']") WebElement Save_Btn;
	@FindBy(xpath="//p[normalize-space()='Success']") WebElement Success_Toast;
	
	
	
	public void clickToAddUser() {
		await.until(ExpectedConditions.elementToBeClickable(AddUser_Btn));
		AddUser_Btn.click();
	}
	
	public void selectUserRole() {
		UserRole_Dropdown_Btn.click();
		await.until(ExpectedConditions.elementToBeClickable(AdminOption_Userrole)).click();
	}
	
	public void selectEnableStatus() {
		Status_Dropdown_Btn.click();
		await.until(ExpectedConditions.elementToBeClickable(EnabledOption_Status)).click();
		
	}
	
	public void setPassword(String pwd) {
		Password_Input.sendKeys(pwd);
	}
	
	public void setEmployeeName() {
		await.until(ExpectedConditions.elementToBeClickable(Employee_Name_Input)).sendKeys("e");
		
		
		
		 await.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='listbox']")));

	        // Wait until at least one option is present
	        List<WebElement> options = await.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//div[@role='option']"), 0));

	        // Click the first suggestion (or loop to pick a specific one)
	        System.out.println("*******"+options.get(0).getText());
	        options.get(0).click();
	}
	
	public void setUserName(String username) {
		Username_Input.sendKeys(username);
	}
	
	public void setConfirmPassword(String pwd) {
		Confirm_Pwd_Input.sendKeys(pwd);
	}
	
	public void clickSaveButton() {
		Save_Btn.click();
	}
	
	public Boolean isSuccessToast() {
		await.until(ExpectedConditions.visibilityOf(Success_Toast));
		if(Success_Toast.isDisplayed()) return true;
		return false;
	}
	
	
	
	
	
	
	
	
	
	

}
