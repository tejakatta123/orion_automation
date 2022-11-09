package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import AbstractComponents_orion.AbstractComponents;

public class CampaignPage extends AbstractComponents {

	public CampaignPage(WebDriver driver) {
		super(driver);
	}
	
	
	By  emailOption =By.xpath("//div[contains(@class,'channelpicker-item-email')]");
	By  nameTextbox= By.xpath("//div//input[@name='name']");
	By  description= By.xpath("//div//textarea[@name='description']");
	By purpose = By.xpath("//div//input[@name='purpose']");
	By Cancel = By.xpath("//a//span[text()='Cancel']");
	By folderDropDwn = By.xpath("//div//input[@name='folderId']/../following-sibling::div");
	By done = By.xpath("//a//span[text()='Done']");
	public String folderOptionsXpath="//ul//div[@data-qtip='%s']";
	By promotional = By.xpath("//ul//div[@data-qtip='Promotional']");
	By moreOptions = By.xpath("//div//div[@data-qtip='More options']");
	By deleteOption = By.xpath("//div[contains(@id,'suiteglobalobjectsearchcontextmenu')]//div//a[@data-qtip='Delete']//span[text()='Delete']");
	By yes = By.xpath("//span//span[text()='Yes']");	
		public void createEmailCampaign(String foldername, String campaignName)
		{
			driver.findElement(emailOption).click();
			driver.findElement(nameTextbox).sendKeys(campaignName);
			driver.findElement(description).sendKeys("i m creating campaign for email.");
			driver.findElement(purpose).click();
			driver.findElement(promotional).click();
			pageScrolltoElement(driver.findElement(folderDropDwn));
			driver.findElement(folderDropDwn).click();
			driver.findElement(By.xpath(String.format(folderOptionsXpath, foldername))).click();
			driver.findElement(done).click();
							
	}
		
		
		public void deleteCampaign()
		{
			ElementtoAppear(driver.findElement(moreOptions));
			driver.findElement(moreOptions).click();
			driver.findElement(deleteOption).click();
			driver.findElement(yes).click();
		}
	
	

}
