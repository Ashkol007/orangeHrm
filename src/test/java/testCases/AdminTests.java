package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AdminPage;
import pageObject.DashBoardPage;
import pageObject.LoginPage;

public class AdminTests extends BaseTestcase{
	
	@Test(priority=1,description="TC10 -- Load Admin page",groups={"Master"})
	public void LoadAdminPage() {
		
		logger.info("-----------Load Admin page TestCase Start------------");
		LoginPage lp = new LoginPage(driver);
		          lp.setUsername("Admin");
		          lp.setUserpwd("admin123");
	              lp.clickLogin();
	              
        DashBoardPage dbp = new DashBoardPage(driver);
                      dbp.goToAdminPage();
                      
        AdminPage ap = new AdminPage(driver);
                  
                 Assert.assertTrue(ap.isAdminHeading(), "Admin heading not found on admin page.");

		    logger.info("---------Load Admin page Testcase Passed---------");
		
	}
	
	@Test(priority=2,description="TC11 -- Search Valid User",groups={"Master"})
	public void checkUserRoleForAdmin() {
		
		logger.info("-----------Search Valid User for Admin TestCase Start------------");
		LoginPage lp = new LoginPage(driver);
		          lp.setUsername("Admin");
		          lp.setUserpwd("admin123");
	              lp.clickLogin();
	              
        DashBoardPage dbp = new DashBoardPage(driver);
                      dbp.goToAdminPage();
                      
        AdminPage ap = new AdminPage(driver);
                  ap.selectAdminDropDown();
                  ap.clickSubmit();
                  
                  
                 Assert.assertTrue(ap.isUserRoleAdmin(), "Admin not found in table User Role column on admin page.");

		    logger.info("---------Search Valid User for Admin Testcase Passed---------");
		
	}
	
	@Test(priority=3,description="TC12 -- Search InValid User",groups={"Master","Sanity"})
	public void searchIinvalidUser() {
		
		logger.info("-----------Search Valid User for Admin TestCase Start------------");
		LoginPage lp = new LoginPage(driver);
		          lp.setUsername("Admin");
		          lp.setUserpwd("admin123");
	              lp.clickLogin();
	              
        DashBoardPage dbp = new DashBoardPage(driver);
                      dbp.goToAdminPage();
                      
        AdminPage ap = new AdminPage(driver);
                  ap.isAdminHeading();
                  ap.setUserName("Wrong Username");
                  ap.clickSubmit();
                  
                      
                 Assert.assertTrue(ap.isInvalidUser(), "Toast message Records Not Found for Wrong user on admin page.");

		    logger.info("---------Search InValid User for Admin Testcase Passed---------");
		
	}

}
