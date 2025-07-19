package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.DashBoardPage;
import pageObject.LoginPage;

public class TC01_ValidLogin extends BaseTestcase {
	
	@Test(groups= {"Master"})
	public void validLogin() {
		
		LoginPage lp = new LoginPage(driver);
		          lp.setUsername("Admin");
		          lp.setUserpwd("admin123");
	              lp.clickLogin();
	    
	    DashBoardPage dbp = new DashBoardPage(driver);
	               
	    Assert.assertEquals(true, dbp.checkDashboardTitle());                
	              
	}

}
