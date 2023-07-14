package selenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MultipleWindowsClass {
  @Test
  public void testMultipleWindows() throws InterruptedException{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/browser-windows");
		
		driver.findElement(By.id("windowButton")).click();
		driver.findElement(By.id("windowButton")).click();
		driver.findElement(By.id("windowButton")).click();
		String mainWindow=driver.getWindowHandle();
		Set<String> set =driver.getWindowHandles();
		Iterator<String> itr= set.iterator();
		
		while(itr.hasNext()) {
			String childWindow=itr.next();
			if(!mainWindow.equals(childWindow)) {
				driver.switchTo().window(childWindow);
				WebElement text = driver.findElement(By.id("sampleHeading"));
                System.out.println("Heading of child window is " + text.getText());
								//System.out.println(driver.switchTo().window(childWindow).getTitle());
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);
	}

}