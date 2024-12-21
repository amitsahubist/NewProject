package Test.DemoProjectFramework.utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableMethods {
	
	private static String parentwindow = null;
	private static String childWindow = null;


// ##### Parent child Browsers #######	
	// Paren child windows navigations
		public static void windowhandle() {
			parentwindow = BaseTest.driver.getWindowHandle();
			Set<String> windows = BaseTest.driver.getWindowHandles();
			Iterator<String> it = windows.iterator();

			while (it.hasNext()) {
				childWindow = it.next();
			}
		}

		public static void switchToChildWindow() 
		{
			windowhandle();
			BaseTest.driver.switchTo().window(childWindow);
		}

		public static void switchToParentWindow() {
			BaseTest.driver.switchTo().window(parentwindow);
		}
// ##### Parent child Browsers End #######	
		
		
// ###### Explicit wait  ##########		
		
		public static void explicitWait (WebElement element)
		{
			WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		
// ###### Explicit wait end  ##########		
		
		
// ###### Capture screenshot  ##########				
		public static void ScreenCapture()
		{
			File screenshot = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);
			
			String path = System.getProperty("user.dir") + "/Screenshot/" + "EBay_Cart_"+System.currentTimeMillis()	+ ".png";
			
			File destinationFile = new File(path);
			try {
				FileUtils.copyFile(screenshot, destinationFile);
			} catch (IOException e) {
				System.out.println("Capture Failed: " + e.getMessage());
					
		}
// ###### Explicit wait  end ##########				
}

}