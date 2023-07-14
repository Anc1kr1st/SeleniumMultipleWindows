package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class demo1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/browser-windows");
		WebElement clickElement = driver.findElement(By.id("windowButton"));
		
		for(int i = 0; i < 3; i++)
		{
			clickElement.click();
			Thread.sleep(3000);
		}
	}

}
