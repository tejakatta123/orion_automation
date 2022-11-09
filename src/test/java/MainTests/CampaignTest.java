package MainTests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import PageObjects.CampaignPage;
import PageObjects.HeaderPage;
import PageObjects.LoginPage;
import PageObjects.MenuOptionPage;
import TestComponents.BaseTest;
import TestComponents.ExtentListeners;

public class CampaignTest  extends BaseTest{
	public String folderName="!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!DssABAC";
	public String campaignName = "Abc_123_Nov2022";
	//CampaignPage camp = new CampaignPage(driver);
	@Test
	public void createEmailCampaignTest() throws Exception
	{
		
		LoginPage login = new LoginPage(driver);
		login.logintoApplication();
		MenuOptionPage menuOptions = new MenuOptionPage(driver);
		menuOptions.ActionsOption();
		menuOptions.clickCreatecampaign();
		CampaignPage camp = new CampaignPage(driver);
		camp.createEmailCampaign(folderName,campaignName);
		ExtentListeners.test.log(Status.PASS, campaignName+"  campaign is created");
		
		}
	@Test(dependsOnMethods = {"createEmailCampaignTest"})
	public void deleteCampaignTest() throws InterruptedException
	{
		HeaderPage header = new HeaderPage(driver);
		header.searchElement(campaignName);
		CampaignPage camp = new CampaignPage(driver);
		camp.deleteCampaign();
		ExtentListeners.test.log(Status.PASS, campaignName +"  campaign is deleted.");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
