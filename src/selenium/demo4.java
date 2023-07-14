package selenium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class demo4 {
	
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/browser-windows");
		String parentWindowHandle = driver.getWindowHandle();
		System.out.println("Parent window's handle -> " + parentWindowHandle);
		WebElement clickElement = driver.findElement(By.id("windowButton"));
		
		for(int i = 0; i < 3; i++)
		{
			clickElement.click();
			Thread.sleep(3000);
		}
		
		Set<String> allWindowHandles = driver.getWindowHandles();
		
		for(String handle : allWindowHandles)
		{
			System.out.println("Switching to window -> " + handle);
			System.out.println("Navigating to google.com");
			driver.switchTo().window(handle);
			driver.get("https://www.google.com/");
		}
	}

}
