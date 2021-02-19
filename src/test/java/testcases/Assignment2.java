package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://qa.way2automation.com");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.name("name")).sendKeys("shravan");
		driver.findElement(By.name("phone")).sendKeys("98765432310");
		driver.findElement(By.name("email")).sendKeys("abcd@gmail.com");
		driver.findElement(By.name("city")).sendKeys("hdyerabad");
		WebElement u = driver.findElement(By.className("fancybox-skin"));
		u.findElement(By.name("username")).sendKeys("bingo123");
		u.findElement(By.name("password")).sendKeys("bingo123");
		WebElement e = driver.findElement(By.id("load_box"));
		e.findElement(By.className("button")).click();
	}
}
