package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import annotations.TestCaseId;


import pageObject.DashBoardPage;
import pageObject.LoginPage;

public class LoginTests extends BaseTestcase {
	
	@Test(groups= {"Master"}, priority=1,description="TC01 -- Login Valid")
	public void testvalidLogin() {
		logger.info("-----------Login Valid TestCase ------------");
		LoginPage lp = new LoginPage(driver);
		          lp.setUsername("Admin");
		          lp.setUserpwd("admin123");
	              lp.clickLogin();
	                  
	    
	    DashBoardPage dbp = new DashBoardPage(driver);
	    
	    Assert.assertTrue(dbp.checkDashboardTitle(),"Dashboard not visible after login"); 
	    
	    logger.info("---------LoginValid Testcase Passed---------");
	              
	}
	
	@Test(groups={"Master"},priority=2,description="TC02 -- Login Invalid Wrong Password")
	public void testInValidLogin() {
		logger.info("-----------Login InValid TestCase Start------------");
		LoginPage lp = new LoginPage(driver);
		          lp.setUsername("Admin");
		          lp.setUserpwd("admin1234");
	              lp.clickLogin();
	    
        
	    	
	    	Assert.assertTrue(lp.isInvalidCredential(),"Expected invalid credentials message not displayed");

		    logger.info("---------LoginInValid Testcase Passed---------");
	    }
	
	@Test(groups={"Master"},priority=3,description="TC03 -- Login with Empty Fields ")
	public void testEmptyFieldsLogin() {
		logger.info("-----------Login EmptyFields TestCase Start------------");
		LoginPage lp = new LoginPage(driver);
		          lp.setUsername("");
		          lp.setUserpwd("");
	              lp.clickLogin();
	    
        
	    	
	    	Assert.assertTrue(lp.isRequiredTxt(),"Expected required span is not displayed");

		    logger.info("---------Login EmptyFields Testcase Passed---------");
	    }
	
	@Test(groups={"Master"},priority=4,description="TC04 -- Login with only User Fields ")
	public void testOnlyUserFieldsLogin() {
		logger.info("-----------Login User Fields TestCase Start------------");
		LoginPage lp = new LoginPage(driver);
		          lp.setUsername("Admin");
		          lp.setUserpwd("");
	              lp.clickLogin();
	    
        
	    	
	    	Assert.assertTrue(lp.isRequiredTxt(),"Expected Required span for password is not displayed");

		    logger.info("---------Login User Fields Testcase Passed---------");
	    }
	
	@Test(groups={"Master"},priority=5,description="TC05 -- Login with only Password Fields ")
	public void testOnlyPasswordFieldsLogin() {
		logger.info("-----------Login Password Fields TestCase Start------------");
		LoginPage lp = new LoginPage(driver);
		          lp.clearUsername();
		          lp.setUserpwd("admin123");
	              lp.clickLogin();
	    
        
	    	
	    	Assert.assertTrue(lp.isRequiredTxt(),"Expected Required span for Username is not displayed");

		    logger.info("---------Login Password Fields Testcase Passed---------");
	    }
	
	@Test(groups={"Master"},priority=6,description="TC06 -- Url Redirection ")
	public void testUrlDirection() {
		logger.info("-----------Url Redirection TestCase Start------------");
		LoginPage lp = new LoginPage(driver);
		          lp.setUsername("Admin");
		          lp.setUserpwd("admin123");
	              lp.clickLogin();
	              
        DashBoardPage dbp = new DashBoardPage(driver);
                
        String dbpUrl = "";
              if(dbp.checkDashboardTitle()) {
                     dbpUrl = dbp.getUrl();
                 }

                 
	    	Assert.assertEquals(dbpUrl,"https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");

		    logger.info("---------Url Redirection Testcase Passed---------");
	    }
	    	
	    
		
		
	}
	
	


