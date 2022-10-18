package AbstractComponents_orion;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {
	
	protected WebDriver driver;
	
	public AbstractComponents(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//By menuXpath = By.xpath("//span[contains(@id,'hamburgerbutton') and contains(@class,'icon-el-ri-iconbutton-small')]");
	
	public void ElementtoAppear(WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public void pageScrolltoElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
}




