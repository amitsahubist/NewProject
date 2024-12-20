package Test.DemoProjectFramework.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Test.DemoProjectFramework.utilities.BaseTest;
import Test.DemoProjectFramework.utilities.ReusableMethods;

public class ProductPage {
	
WebDriver driver;
	
	public ProductPage ()
	{	
		PageFactory.initElements(BaseTest.driver, this);
	}
	
	@FindBy(xpath ="//span[contains(text(),'Add to cart')]")
	WebElement addToCart;
	
	@FindBy(xpath = "//button[@data-test-id='cart-remove-item']")
	WebElement removeItem;
	
	public void itemAddToCart()
	{
		addToCart.click();
		ReusableMethods.explicitWait(removeItem);
	}

	@FindBy(id="gh-cart-n")
	WebElement cart;
	
	public boolean itemExistInCart()
	{
		List<WebElement> cartItems = 	driver.findElements(By.xpath("//*[@id='gh-cart-n']"));
			
		if(cartItems.size()>0) {
			return true;
		}
		else
		{
		return false;
		}
	}
	
	public void removeItemsFromCart()
	{
		removeItem.click();
	}
	
}
