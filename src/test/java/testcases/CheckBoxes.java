package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxes {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Normal way of clicking checkboxes
		driver.findElement(By.xpath("//div[2]/div[2]/div[1]/label/input")).click();
		driver.findElement(By.xpath("//div[2]/div[2]/div[2]/label/input")).click();
		driver.findElement(By.xpath("//div[2]/div[2]/div[3]/label/input")).click();
		driver.findElement(By.xpath("//div[2]/div[2]/div[4]/label/input")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("check1")).click();
		Thread.sleep(3000);

		// Using for loop
		for (int i = 1; i <= 4; i++) {
			driver.findElement(By.xpath("//div[2]/div[2]/div[" + i + "]/label/input")).click();
		}
		Thread.sleep(3000);
		driver.findElement(By.id("check1")).click();
		Thread.sleep(3000);

		// if we have dynamic checkboxes
		WebElement e = driver.findElement(By.xpath("//*[@id=\'easycont\']/div/div[2]/div[2]/div[2]"));
		List<WebElement> ele = e.findElements(By.className("cb1-element"));
		System.out.println(ele.size());
		for (WebElement element : ele) {
			element.click();
		}
	}

}
