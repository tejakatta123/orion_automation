package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import AbstractComponents_orion.AbstractComponents;

public class LoginPage extends AbstractComponents {

//	WebDriver driver;
	private static final By txt_username = By.id("txtUserName");
	
	public LoginPage(WebDriver driver) {
		super(driver);
//		this.driver=driver;
	}
	
	public void logintoApplication() {

		driver.get("https://interact5.responsys.net/authentication/login/LoginPage");
		driver.findElement(txt_username).sendKeys("admin@qa50");
		driver.findElement(By.id("txtPassword")).sendKeys("Welcome1234!");
		driver.findElement(By.xpath("//button[contains(@onclick,'LoginModule')]")).click();
	}
	
	
	
		//MenuOptionPage menu = new MenuOptionPage(driver);
		//return menu;

	

}
