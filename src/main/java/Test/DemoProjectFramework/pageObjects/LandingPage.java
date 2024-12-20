package Test.DemoProjectFramework.pageObjects;


import Test.DemoProjectFramework.utilities.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	

	
	public LandingPage ()
	{
//		this.BaseTest.driver = BaseTest.driver;
		PageFactory.initElements(BaseTest.driver, this);
	}
	
	@FindBy(css=".gh-tb")
	WebElement searchBox;
	
	@FindBy(css=".gh-spr")
	WebElement searchBtn;
	
	@FindBy(xpath="//span[contains(@class,'s-item__watchheart')]/preceding-sibling::div")
	WebElement firstItem;
	
	public void gotoUrl (String url)
	{
		BaseTest.driver.get(url);
	}
	
	public void searchItem(String item)
	{
		searchBox.sendKeys(item);
		searchBtn.click();
	}
	
	public void OpenFirstItem()
	{
		ReusableMethods.explicitWait(firstItem);;
		firstItem.click();
	}
	
}
