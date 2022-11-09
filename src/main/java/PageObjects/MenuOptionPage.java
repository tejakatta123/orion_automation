package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import AbstractComponents_orion.AbstractComponents;

public class MenuOptionPage extends AbstractComponents {

	public MenuOptionPage(WebDriver driver) {
		super(driver);
	}

	By menuXpath = By
			.xpath("//span[contains(@id,'hamburgerbutton') and contains(@class,'icon-el-ri-iconbutton-small')]");
	WebElement folder = driver.findElement(By.xpath("//div[text()='Folders']"));
	WebElement account= driver.findElement(By.xpath("//div[text()='Account']"));
	WebElement actions= driver.findElement(By.xpath("//li//div[text()='Actions']"));
	WebElement createCampaignOption= driver.findElement(By.xpath("//li//div[text()='Create Campaign']"));
	public void clickFolderOption() {
		WebElement menu=driver.findElement(menuXpath);
		ElementtoAppear(menu);
		if (folder.isDisplayed()) {
			folder.click();
		} else

			driver.findElement(menuXpath).click();
		folder.click();
	}
	public void AccountOption()
	{
		WebElement menu=driver.findElement(menuXpath);
		ElementtoAppear(menu);
		if (folder.isDisplayed()) {
			account.click();
		} else

			driver.findElement(menuXpath).click();
		account.click();

	}
	
	public void ActionsOption()
	{
		WebElement menu=driver.findElement(menuXpath);
		ElementtoAppear(menu);
		if (folder.isDisplayed()) {
			actions.click();
		} else

			driver.findElement(menuXpath).click();
		actions.click();
	}
	
	public void clickCreatecampaign()
	{
		createCampaignOption.click();
	}
	

}
