package actiongestures;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CTRLActions {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://gmail.com");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("identifierId")).sendKeys("chinthashravan");
		driver.findElement(By.xpath("//*[@id=\'initialView\']/div[2]")).click();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.chord(Keys.CONTROL + "a")).build().perform();
		action.sendKeys(Keys.chord(Keys.CONTROL + "c")).build().perform();
		driver.findElement(By.id("identifierId")).click();
		action.sendKeys(Keys.chord(Keys.CONTROL + "v")).build().perform();

	}

}
