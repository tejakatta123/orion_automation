package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import AbstractComponents_orion.AbstractComponents;

public class CustomEventPage extends AbstractComponents {
	public CustomEventPage(WebDriver driver) {
		super(driver);

	}

	By addNewLink = By.xpath("//span[text()='Add new type']");
	By customEventName = By.xpath("//input[@type='text' and @value='AK_626']");
	By done = By.xpath("//span[text()='Done']");
	By save = By.xpath("//input[@name='save']");
	By txt_addNewEvent = By.xpath("//input[contains(@name,'AddNewEventName')]");
	By selectStandard = By
			.xpath("//a[contains(@onclick,'addNewFieldRow')]/ancestor::tr/preceding-sibling::tr[1]//td[3]/select");
	By txt_description = By.xpath("//input[contains(@name,'AddNewEventAction')]");
	By selectCheckbox = By.xpath(
			"//a[contains(@onclick,'addNewFieldRow')]/ancestor::tr/preceding-sibling::tr[1]//input[@type='checkbox']");
	String xpathDelete = "//a[contains(@onclick,'%s')]//span[@id='ui.account.delete']";

	public void clickAddNewLink() {

		driver.switchTo().frame("main2");
		ElementtoAppear(driver.findElement(save));
		pageScrolltoElement(driver.findElement(addNewLink));
		driver.findElement(addNewLink).click();
	}

	public void addCustomEvent(String eventname, String eventType, String descriptionText , String checkboxStatus) throws InterruptedException {
		driver.findElement(txt_addNewEvent).sendKeys(eventname);
		Select selectOption = new Select(driver.findElement(selectStandard));
		selectOption.selectByVisibleText(eventType);
		driver.findElement(txt_description).sendKeys(descriptionText);
		if(checkboxStatus.equalsIgnoreCase("yes"))
		{
		driver.findElement(selectCheckbox).click();
		}
		
		pageScrolltoElement(driver.findElement(save));
		driver.findElement(save).click();
		driver.findElement(done).click();
		Thread.sleep(5000);
	}

	public void deleteCustomEvent(String eventName) {

		driver.switchTo().frame("main2");
		WebElement deleteElement = driver.findElement(By.xpath(String.format(xpathDelete, eventName)));
		ElementtoAppear(deleteElement);
		deleteElement.click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.findElement(save).click();
		driver.findElement(done).click();

	}

}
