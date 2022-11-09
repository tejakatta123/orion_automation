package PageObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import AbstractComponents_orion.AbstractComponents;
import utils_orion.CommonUtils;

public class LoginPage extends AbstractComponents {

//	WebDriver driver;
	private static final By txt_username = By.id("txtUserName");
	
	public LoginPage(WebDriver driver) {
		super(driver);
//		this.driver=driver;
	}
	
	public void logintoApplication() throws Exception {
		Properties prop = CommonUtils.loadProperties();
		String url=prop.getProperty("loginUrl");
		driver.get(url);
		driver.findElement(txt_username).sendKeys("admin@qa50");
		driver.findElement(By.id("txtPassword")).sendKeys("Welcome1234!");
		driver.findElement(By.xpath("//button[contains(@onclick,'LoginModule')]")).click();
	}
	
	
	
		//MenuOptionPage menu = new MenuOptionPage(driver);
		//return menu;

	

}
