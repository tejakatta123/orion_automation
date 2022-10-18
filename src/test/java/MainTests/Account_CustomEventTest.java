package MainTests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import PageObjects.AccountPage;
import PageObjects.CustomEventPage;
import PageObjects.FolderPage;
import PageObjects.LoginPage;
import PageObjects.MenuOptionPage;
import TestComponents.BaseTest;
import TestComponents.ExtentListeners;

public class Account_CustomEventTest extends BaseTest {


	@Test(dataProvider="getData")
	public void CustomEventTest(HashMap<String,String> input) throws IOException, InterruptedException {
		LoginPage login = new LoginPage(driver);
		login.logintoApplication();
		
		MenuOptionPage menuOptions = new MenuOptionPage(driver);
			
		menuOptions.AccountOption();
		AccountPage account=new AccountPage(driver);
		account.ClickCustomEventPage();
		CustomEventPage customevent = new CustomEventPage(driver);
		customevent.clickAddNewLink();
		customevent.addCustomEvent(input.get("EventName"),input.get("eventType"),input.get("descriptionText"),input.get("checkboxStatus")); 
		ExtentListeners.test.log(Status.PASS, input.get("EventName")+" Custom Event is added Succesfully");
		account.ClickCustomEventPage();
		customevent.deleteCustomEvent(input.get("EventName"));
		ExtentListeners.test.log(Status.PASS, input.get("EventName")+" Created Custom Event is deleted Successfully");
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
		List<HashMap<String,String>> data=getjsonDataToMap("D:\\WORKSPACE\\orion_automation\\src\\test\\java\\test_data\\testData.json");
		return  new Object[][] {{data.get(0)},{data.get(1)}};
			
			
	}

}
