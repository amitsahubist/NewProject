package Test.DemoProjectFramework;

import org.testng.Assert;
import org.testng.annotations.Test;

import Test.DemoProjectFramework.pageObjects.*;
import Test.DemoProjectFramework.utilities.*;

public class EBayTest extends BaseTest  {
	
	@Test
	public void orderAnItem() {

	String url = "https://www.ebay.com/";
	
	LandingPage itemSearch = new LandingPage();
	ProductPage itemToAdd = new ProductPage();
	
	itemSearch.gotoUrl(url);					//Open eBay url
	itemSearch.searchItem("books");				//Search book on website
	itemSearch.OpenFirstItem();					//Open the first book which take us to new tab
	ReusableMethods.switchToChildWindow();		//Go to child window tab where item is opened
	itemToAdd.itemAddToCart(); 					//Add item in cart
	ReusableMethods.ScreenCapture();
	boolean flag = itemToAdd.itemExistInCart();	//Verify if item added in cart
	Assert.assertTrue(flag);					//	
	itemToAdd.removeItemsFromCart();			//After test Remove the item from cart
	driver.quit();  							//Close all instance of browser
	
	}
	
}
