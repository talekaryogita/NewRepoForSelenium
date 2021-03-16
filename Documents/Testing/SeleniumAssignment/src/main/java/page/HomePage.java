package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class HomePage extends TestBase{
	Actions action;
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	WebElement textbox;
	@FindBy(xpath="//input[@id='nav-search-submit-button']")
	WebElement search;
	@FindBy(xpath="//header/div[@id='navbar']/div[@id='nav-belt']/div[3]/div[1]/a[2]/span[2]")
	WebElement moveTologin;
	@FindBy(xpath="//header/div[@id='navbar']/div[@id='nav-flyout-anchor']/div[@id='nav-flyout-accountList']/div[2]/div[1]/div[1]/div[1]/a[1]/span[1]")
	WebElement SignIn;
	
	
	public HomePage()
	{
		init();
		PageFactory.initElements(driver, this);
		driver.manage().window().maximize();
		action = new Actions(driver);
		
	}
	
	public void sendkeysToTextbox()
	{
		textbox.sendKeys("watch");
	}
	
	public void clickSearch()
	{
		search.click();
	}
	
	public void moveToLogin() {
		action.moveToElement(moveTologin).perform();
	}
	
	public void clicksignIn() {
		SignIn.click();
	
	}	
	public String getTitle()
	{
		return driver.getTitle();
		//System.out.println(driver.getTitle());
		
	}
	

}
