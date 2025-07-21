package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

	
    public LoginPage(WebDriver driver){
	    super(driver);   	
	}
    
    
    


	@FindBy(xpath= "//input[@name='username']") WebElement username_inp;
    @FindBy(xpath= "//input[@name='password']") WebElement password_inp;
    @FindBy(xpath="//button[@type='submit']") WebElement login_btn;
    @FindBy(xpath="//p[@class='oxd-text oxd-text--p oxd-alert-content-text']") WebElement InvalidCredentials_txt;
    @FindBy(xpath="//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']") WebElement required_txt;
    
    
    
    public void setUsername(String userInput) {
    	username_inp.sendKeys(userInput);
    }
    
    public void clearUsername() {
    	username_inp.clear();
    }
    
    public void setUserpwd(String pwdInput) {
    	password_inp.sendKeys(pwdInput);
    }
    
    public void clickLogin() {
    	login_btn.click();
    }
    
    public Boolean isInvalidCredential() {
    	await.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")));

    	if(InvalidCredentials_txt.isDisplayed()) return true;
    	return false;
    } 
    
    public String invalidCredentialsTxt() {
    	await.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")));
    	return InvalidCredentials_txt.getText();
    } 
    
    public Boolean isRequiredTxt() {
    	await.until(ExpectedConditions.visibilityOf(required_txt));
    	if(required_txt.isDisplayed()) return true;
    	return false;
    }
    
    
    
    
    
    
    
	
}
