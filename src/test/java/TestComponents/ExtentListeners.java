package TestComponents;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.Status;


public class ExtentListeners extends BaseTest implements ITestListener{
	
	public void onTestStart(ITestResult result) { 
		test =extent.createTest(result.getTestClass().getName()+ " @TestCase : " +result.getMethod().getMethodName()); 
	}

	public void onTestSuccess(ITestResult result) { 
		test.log(Status.PASS, "Test is Passed.");
		test.pass(result.getMethod().getMethodName() + " - PASSED"); 
	}

	public void onTestFailure(ITestResult result) {

		try {
			driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchFieldException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SecurityException e1) {
			// TODO Auto-generated catch blo
			e1.printStackTrace();
		}

		String filepath=null;
		try {
			filepath=getScreenShot(result.getMethod().getMethodName(),driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
		test.fail(result.getThrowable());
		test.log(Status.FAIL, "Test is Failed.");
		test.fail(result.getMethod().getMethodName() + " - FAILED"); 
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}


	public void onFinish(ITestContext context) { 
		extent.flush();
	}

}



