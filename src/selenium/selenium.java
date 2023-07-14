package selenium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;

public class selenium {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		//driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println(title);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Diablo IV");
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,40)");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
	
		WebElement link = driver.findElement(By.xpath("//span[contains(text(),'PlayStation 5 Games')]"));
		Actions newwin = new Actions(driver);
		newwin.keyDown(Keys.SHIFT).click(link).keyUp(Keys.SHIFT).build().perform();
		Thread.sleep(1000);
		
		Set<String> windows = driver.getWindowHandles();
		System.out.println(windows);
		System.out.println("a1");
		
		System.out.println(driver.getTitle());
		
		for(String window : windows) {
			driver.switchTo().window(window);
			if(driver.getTitle().contains("Amazon.com : Diablo IV")) {
				System.out.println("a2");
				js.executeScript("window.scrollBy(0,1000)");
				Thread.sleep(3000);
				System.out.println("b1");
				driver.findElement(By.xpath("//body/div[@id='a-page']/div[@id='search']/div[1]/div[2]/div[1]/div[3]/span[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/span[1]/li[1]/span[1]/a[1]/span[1]")).click();
				driver.manage().window().setPosition(new Point(-2000,0));
			}
			}
		Thread.sleep(3000);
		Set<String> windows1 = driver.getWindowHandles();
		System.out.println(windows1);
		System.out.println("a3");
		for (String window : windows1) {
			driver.switchTo().window(window);
			System.out.println("a4");
			js.executeScript("window.scrollBy(0,400)");
		}
		driver.quit();
	}

}
