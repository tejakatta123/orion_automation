package practiceTestonSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook_automation {

	
	@Test
	public void facebook_login()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("prettyteju3@gmail.com");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("b.tech2013");
		driver.findElement(By.name("login")).click();
	}
	
	
	
}
