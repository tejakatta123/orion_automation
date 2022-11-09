package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import AbstractComponents_orion.AbstractComponents;

public class HeaderPage extends AbstractComponents {

	public HeaderPage(WebDriver driver) {
		super(driver);
	}
	
	By search = By.xpath("//div//span[contains(@class,'responsys-globalsearch-icon')]");
	By searchTextBox = By.xpath("//div//input[@placeholder='Search...']");
	
	
	
	public void searchElement(String SearchText) throws InterruptedException
	{
//		ElementtoAppear(driver.findElement(search));
		Thread.sleep(20000);
		driver.findElement(search).click();
		WebElement searchText =driver.findElement(searchTextBox);
		searchText.sendKeys(SearchText);
		searchText.sendKeys(Keys.ENTER);
		
	}
	

}
