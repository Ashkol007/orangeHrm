package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import annotations.TestCaseId;
import java.lang.reflect.Method;

import testCases.BaseTestcase;

public class ExtentReportManager implements ITestListener {

	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String repName;
	
	private String getTestCaseId(ITestResult result) {
	    try {
	        Method method = result.getMethod().getConstructorOrMethod().getMethod();
	        if (method.isAnnotationPresent(TestCaseId.class)) {
	            return method.getAnnotation(TestCaseId.class).value();
	        }
	    } catch (Exception ignored) {}
	    return "N/A";
	}
	
	public void onStart(ITestContext testContext) {
		
//		SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
//		Date dt = new Date();
//		String currentdatetimestamp = df.format(dt);
		
		 
		
		
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repName = "Test-Report-"+timestamp+".html";
		sparkReporter = new ExtentSparkReporter(".\\reports\\"+repName);
		
		sparkReporter.config().setDocumentTitle("orangeHrm Automation Report");
		sparkReporter.config().setReportName("orangeHrm Functional Testing");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "orangeHrm");
		extent.setSystemInfo("Module","Admin");
		extent.setSystemInfo("Sub module","Human Resources");
		extent.setSystemInfo("UserName", System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");
		
		String os = testContext.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating System", os);
		
		String browser = testContext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);
		
		List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
		if(!includedGroups.isEmpty()) {
			extent.setSystemInfo("Groups",includedGroups.toString());
		}
		
				
		
	}
	
	
	public void onTestSuccess(ITestResult result) {
		
		test = extent.createTest(result.getMethod().getDescription());
		
		test.assignCategory(result.getMethod().getGroups());
		test.assignCategory(result.getMethod().getMethodName());
		
		String tcId = result.getMethod().getDescription();
		test.info("📄 TestCase ID: " + tcId);
		
		test.log(Status.PASS, result.getName()+"got successfully executed");
		
		}
	
	public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getMethod().getDescription());
		
		test.assignCategory(result.getMethod().getGroups());
		test.assignCategory(result.getMethod().getMethodName());

		String tcId = result.getMethod().getDescription();
		test.info("📄 TestCase ID: " + tcId);
		
		test.log(Status.FAIL, result.getName()+" got Failed");
		test.log(Status.INFO, result.getThrowable().getMessage());
		
		try {
			String imgPath = new BaseTestcase().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath);
			
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		
		
	}
	
	public void onTestSkip(ITestResult result){
test = extent.createTest(result.getMethod().getDescription());
		
		test.assignCategory(result.getMethod().getGroups());
		test.assignCategory(result.getMethod().getMethodName());

		String tcId = result.getMethod().getDescription();
		test.info("📄 TestCase ID: " + tcId);
		
		test.log(Status.SKIP,result.getName()+" test skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());
		
	}
	
	public void onFinish(ITestContext testContext) {
		
		extent.flush();
		String pathOfExtentReport = System.getProperty("user.dir")+"\\reports\\"+repName;
		File extentReport = new File(pathOfExtentReport);
		
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}
		
	}
	
	
	
	
	
	
	
	
	

}
