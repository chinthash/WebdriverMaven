package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {

	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.wikipedia.org");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Select sel = new Select(driver.findElement(By.id("searchLanguage")));
		sel.selectByValue("az");

	}

}
