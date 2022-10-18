package PageObjects;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import AbstractComponents_orion.AbstractComponents;

public class FolderPage extends AbstractComponents {
//	WebDriver driver;
	public String delXpath = "//div[contains(@onclick,'%s')]";
	By delButton = By.xpath("//a[contains(@class,'delete')]");
	String xpath = "//span[@id='deleteFolderQuestion']";
	By delText = By.xpath("//span[@id='deleteFolderQuestion']");
	By yes = By.xpath("//input[@id='deleteFolderConfirmBtnId']");
	By folderList = By.xpath("//div[contains(@class,'folders-link-nameDiv')]/span");

	public FolderPage(WebDriver driver) {
		super(driver);
//		this.driver=driver;
	}

	public void CreateFolder(String folderName) {
		driver.findElement(By.id("button-1864-btnInnerEl")).click();
		driver.findElement(By.xpath("//div[contains(@id,'suitecommonwindow')]//input")).sendKeys(folderName);
		driver.findElement(By.xpath("//div[contains(@id,'suitecommonwindow')]//span[text()='Done']")).click();
	}

	public boolean deleteFolder(String folderName) {
		boolean deletefolder = false;
		driver.findElement(By.xpath(String.format(delXpath, folderName))).click();
		driver.findElement(delButton).click();
		driver.switchTo().frame("main2");
		ElementtoAppear(driver.findElement(yes));
		String deleteText = driver.findElement(delText).getText();
		System.out.println(deleteText);
		if (deleteText.contains(folderName)) {
			driver.findElement(yes).click();
			deletefolder = true;
		}
		return deletefolder;

	}

	public boolean isFolderPresent(String folderName) {
		boolean isFolderExist = false;
		java.util.List<WebElement> list = driver.findElements(folderList);
		for (WebElement folderitem : list) {
			if (folderitem.getText().equalsIgnoreCase(folderName)) {
				isFolderExist = true;

			}

		}
		return isFolderExist;

	}

}
