package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import AbstractComponents_orion.AbstractComponents;

public class Folder_UI extends AbstractComponents {

	public Folder_UI(WebDriver driver) {
		super(driver);
	}
	
	
	By folderTit = By.xpath("//label[contains(@class,'header-title ')]");
	By folderText = By.xpath("//label[contains(@class,'folders-header-desc')]");
	By export  =  By.xpath("//a[contains(@class,'export')]");
	By importopt  =  By.xpath("//a[contains(@class,'import')]");	
	By createFolder = By.xpath("//a[contains(@class,'newFolder')]");
	By folderDropDwn = By.xpath("//div[contains(@class,'foldersListCombo')]//div[contains(@class,'form-text-field')]");
	By folderList = By.xpath("//div[contains(@class,'foldersListCmp')]");
	By contents = By.xpath("//div[contains(@class,'contentsListCmp')]");
	By addtoFavorites = By.xpath("//a[contains(@class,'addToFavorites')]");
	By copy = By.xpath("//a[contains(@class,'copy')]");
	By rename = By.xpath("//a[contains(@class,'rename')]");
	By delete = By.xpath("//a[contains(@class,'delete')]");
	
	
	public boolean folderTitle()
	{
		boolean folderTitle = false;
		if(driver.findElement(folderTit).isDisplayed())
		{
			folderTitle=true;
		}
		return folderTitle;
	}
	
	public String folderDescription() {
		
		String foldertext = driver.findElement(folderText).getText();
		return foldertext;
			}
	
	public boolean exportOption() {
		
		boolean exportOpt = false;
		if(!driver.findElement(export).isEnabled())
		{
			exportOpt=true;
		}
		return exportOpt;
		
	}
	
		public boolean importOption() {
		
		boolean importOpt = false;
		if(driver.findElement(importopt).isEnabled())
		{
			importOpt=true;
		}
		return importOpt;
		
	}
	
		public boolean createFoldertoption()
		{
			boolean createFolderOpt = false;
			if(driver.findElement(createFolder).isEnabled())
			{
				createFolderOpt=true;
			}
			return createFolderOpt;
		}
	
	public boolean folderDropDown()
	{
		boolean folderDpdwn = false;
		if(driver.findElement(folderDropDwn).isDisplayed())
		{
			folderDpdwn=true;
		}
		return folderDpdwn;
	}
	
	public boolean folderListContainer()
	{
		boolean folderlist = false;
		if(driver.findElement(folderList).isDisplayed())
		{
			folderlist=true;
		}
		return folderlist;
	}
	public boolean contentsBox()
	{
		boolean contentsbox = false;
		if(driver.findElement(contents).isDisplayed())
		{
			contentsbox=true;
		}
		return contentsbox;
	}
	
	public boolean addToFavoritesBtn()
	{
		boolean addToFav = false;
		if(driver.findElement(addtoFavorites).getAttribute("aria-disabled").equalsIgnoreCase("true"))
		{
			addToFav=true;
		}
		return addToFav;
	}
	
	public boolean CopyBtn()
	{
		boolean copybtn = false;
		if(!driver.findElement(copy).isEnabled())
		{
			copybtn=true;
		}
		return copybtn;
	}
	
	public boolean renameBtn()
	{
		boolean renamebtn = false;
		if(!driver.findElement(rename).isEnabled())
		{
			renamebtn=true;
		}
		return renamebtn;
	}
	
	public boolean deleteBtn()
	{
		boolean deletebtn = false;
		if(driver.findElement(delete).getAttribute("aria-disabled").equalsIgnoreCase("true"))
		{
			deletebtn=true;
		}
		return deletebtn;
	}
	
	
	
	
	

}
