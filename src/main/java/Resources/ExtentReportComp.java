package Resources;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportComp {
	
	public static ExtentReports extent;
	
	@BeforeTest
	public static ExtentReports getExtentReports()
	{
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("aacount page reports");
		reporter.config().setDocumentTitle("orionn reports");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("tester", "Teja");
		return extent;
		
	}
	
	
	
	

}
