package testCases;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTestcase {
	
	public static WebDriver driver;
	public static Logger logger;
	public static WebDriverWait await;
	
	@BeforeMethod(groups={"Master","Sanity","Regression"})
	@Parameters({"browser","os"})
	public void setup(String browser,String os) {
		
		logger = LogManager.getLogger(this.getClass());
		
		
		switch(browser.toLowerCase()) {
		  case "chrome"  : driver = new ChromeDriver(); break;
		  case "edge" : driver = new EdgeDriver();break;
		  case "firefox": driver = new FirefoxDriver();break;
		  default : System.out.println("Invalid Browser");
		}
			
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); 
	 
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
	}
	
	@AfterMethod
	public void teardown(){
		if (driver != null) {
            System.out.println(">> AfterMethod: Closing browser");
            driver.quit();
        }
		driver.close();
	}
	
	
    public String captureScreen(String tname) {
		
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		File sourceFile = takeScreenShot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp+".png";
		File targetFile = new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		// TODO Auto-generated method stub
		return targetFilePath;
	}

}
