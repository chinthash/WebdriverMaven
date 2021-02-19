package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1 {
	public static void main(String args[]) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("way2automation");
		driver.findElement(By.name("btnK")).click();
		WebElement e = driver.findElement(By.id("rcnt"));
		List<WebElement> ele = e.findElements(By.tagName("a"));
		System.out.println(ele.size());
		System.out.println(ele.get(0).getText());
		ele.get(0).click();
		List<WebElement> ele2 = driver.findElements(By.tagName("a"));
		System.out.println(ele2.size());
		for (int i = 0; i < ele2.size(); i++) {
			System.out.println(ele2.get(i).getText());
		}
	}

}
