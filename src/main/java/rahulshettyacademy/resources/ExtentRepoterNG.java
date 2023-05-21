package rahulshettyacademy.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentRepoterNG {
    
	public static ExtentReports getReportObject()
	{
		        //ExtentsReports  , ExtentsSparkReport
		        String path =System.getProperty("user.dir")+"//reports//index.html";
				ExtentSparkReporter reporter = new ExtentSparkReporter(path);
				reporter.config().setReportName("Web Automation Results");
				reporter.config().setDocumentTitle("Test Results");
				
				    ExtentReports extent = new ExtentReports();
					extent.attachReporter(reporter);
					extent.setSystemInfo("Tester","RAHUL MATHUR");
					extent.createTest(path);
					return extent;
	}
}
