package actiongestures;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mousehover {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.name("q")).sendKeys("way2automation");
		driver.findElement(By.name("btnK")).click();
		driver.findElement(By.xpath("//*[@id=\'rso\']/div[1]/div/div/div/div[1]/a/h3/span")).click();
		WebElement ele = driver.findElement(By.xpath("//*[@id=\"navbar-collapse-1\"]/ul/li[3]/a"));
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
		driver.findElement(By.linkText("Selenium JAVA Video Tutorials")).click();
	}

}
