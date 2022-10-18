package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import AbstractComponents_orion.AbstractComponents;

public class AccountPage extends AbstractComponents {

	public AccountPage(WebDriver driver) {
		super(driver);

	}

	By searchAccountOption = By.xpath("//div[contains(@id,'textfield')]//input[@placeholder='Search menu...']");
	By customEventTypeOption = By
			.xpath("//div[contains(@class,'treelist-item-text')]//span[text()='Custom event types']");
	By addNewLink = By.xpath("//span[text()='Add new type']");
	By save = By.xpath("//input[@name='save']");
	By clear = By.xpath("//div[@data-ref='triggerWrap']//div[contains(@id,'trigger-clear')]");

	public void ClickCustomEventPage() throws InterruptedException {
		
		ElementtoAppear(driver.findElement(searchAccountOption));
		driver.findElement(searchAccountOption).sendKeys("custom event types");
		Thread.sleep(3000);
		driver.findElement(searchAccountOption).sendKeys(Keys.ENTER);
		ElementtoAppear(driver.findElement(customEventTypeOption));
		driver.findElement(customEventTypeOption).click();
		Thread.sleep(10000);

	}

}
