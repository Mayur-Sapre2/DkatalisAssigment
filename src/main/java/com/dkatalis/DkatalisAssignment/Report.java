package com.dkatalis.DkatalisAssignment;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



/**
 * @Description:- Used to Create Extent Report
 * @Used_In:- Reporting
 * @author Mayur Sapre
*/

public class Report extends TestListenerAdapter {
	
	public static ExtentHtmlReporter htmlreporter;
	public static ExtentTest logger;
	public static ExtentReports extent;
	public static WebDriver driver;
	
	Screenshot screen=new Screenshot();
	
	public void onStart(ITestContext context) {
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String report_name="Automation_Report_" + timestamp +".html";
		htmlreporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/Automation_Reports/"+report_name);
		htmlreporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
	
		
		extent=new ExtentReports();
		
		extent.attachReporter(htmlreporter);

		extent.setSystemInfo("Application","Avocado");
		extent.setSystemInfo("Opearating System",System.getProperty("os.name"));
		extent.setSystemInfo("Hostname","Avocado");
		extent.setSystemInfo("Tester Name","Mayur Sapre");
		
		htmlreporter.config().setDocumentTitle("Avocado");
		htmlreporter.config().setReportName("Avocado AUtomation Project");
		htmlreporter.config().setTheme(Theme.DARK);
	}
	
	public void onTestSuccess(ITestResult result) {
		logger=extent.createTest(result.getName());
		logger.log(Status.PASS,MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));			
	}
	
	public void onTestFailure(ITestResult result) {
		logger=extent.createTest(result.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName(),ExtentColor.RED));
		
		String screenshotpath=System.getProperty("user.dir")+"/FailedTestsScreenshots/"+result.getName()+".png";
		Screenshot.takeScreenShot(screenshotpath);
		
		File f=new File(screenshotpath);
		if(f.exists()) {
			try {
				logger.fail("Screenshot Below:"+logger.addScreenCaptureFromPath(screenshotpath));
				logger.log(Status.FAIL,result.getThrowable());
			}
			catch(Exception e) {
			e.printStackTrace();	
			}
		}
	}
	
	public void onTestSkipped(ITestResult result)	{
		logger=extent.createTest(result.getName());
		logger.log(Status.SKIP,MarkupHelper.createLabel(result.getName(),ExtentColor.ORANGE));
	}
	
	public void onFinish(ITestContext testContext){
		extent.flush();
	}
		
}
