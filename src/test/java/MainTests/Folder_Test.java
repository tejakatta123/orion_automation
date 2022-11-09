package MainTests;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import PageObjects.FolderPage;
import PageObjects.Folder_UI;
import PageObjects.LoginPage;
import PageObjects.MenuOptionPage;
import Resources.ExtentReportComp;
import TestComponents.BaseTest;
import TestComponents.ExtentListeners;

public class Folder_Test extends BaseTest {

	Random rand = new Random();
	int randomNum = rand.nextInt(1000000);


	public String folderName="!!!!!!!!!!!!!!!!!!!!!!!!!!!ABC_"+randomNum;

	//	ExtentReports extent =getExtentReports();

	@Test
	public void folderTest() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.logintoApplication();

		MenuOptionPage menuOptions = new MenuOptionPage(driver);
		menuOptions.clickFolderOption();
		FolderPage folder = new FolderPage(driver);
		folder.CreateFolder(folderName);

		if(folder.deleteFolder(folderName))
		{
			ExtentListeners.test.log(Status.PASS, folderName +" folder is deleted.");
		}
		else
		{
			Assert.fail(folderName + " is not deleted");
		}

		if(!folder.isFolderPresent(folderName))
		{
			ExtentListeners.test.log(Status.PASS, "The folder which is deleted by user is not showing in Folders list.");
		}
		else
		{
			ExtentListeners.test.log(Status.FAIL, folderName + " is still present in folders list even after deleted by user.") ;
			Assert.fail(folderName + " is still present in folder list even after deleted by user.");
		}

	}
	
	@Test
	public void folderTestUi()
	{
		Folder_UI folderui = new Folder_UI(driver);
		if(folderui.folderTitle())
		{
			ExtentListeners.test.log(Status.PASS, "folder title is present");
		}
		else
		{
			Assert.fail("folder title is not present");
		}

		if(folderui.deleteBtn())
		{
			ExtentListeners.test.log(Status.PASS, "delete button is disabled");
		}
		else
		{
			Assert.fail("delete button is not disabled");
		}

		if(folderui.addToFavoritesBtn())
		{
			ExtentListeners.test.log(Status.PASS, "add to favourites button is disabled");
		}
		else
		{
			Assert.fail("add to favrourites button is not disabled");
		}





	}

}





