package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWait {

	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://10.96.132.30:8080/ServerManager");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("loginUsername")).sendKeys("legodo");
		driver.findElement(By.id("loginPassword")).sendKeys("legodo");
		driver.findElement(By.id("loginSubmit")).click();
		driver.findElement(By.xpath("//*[@id=\"x-auto-2\"]/tbody/tr[2]/td[2]/em/button")).click();
		driver.findElement(By.id("x-auto-42")).click();
	}

}
