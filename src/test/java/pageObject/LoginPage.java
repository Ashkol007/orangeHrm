package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	
    public LoginPage(WebDriver driver){
	    super(driver);   	
	}
    
    
    @FindBy(xpath= "//input[@name='username']") WebElement username_inp;
    @FindBy(xpath= "//input[@name='password']") WebElement password_inp;
    @FindBy(xpath="//button[@type='submit']") WebElement login_btn;
    
    
    public void setUsername(String userInput) {
    	username_inp.sendKeys(userInput);
    }
    
    public void setUserpwd(String pwdInput) {
    	password_inp.sendKeys(pwdInput);
    }
    
    public void clickLogin() {
    	login_btn.click();
    }
    
    
    
    
	
}
