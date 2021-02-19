package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestIsElementPresent {
	public static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.wikipedia.org");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement ele = driver.findElement(By.id("js-link-box-en"));
		// isDisplayed checks whether the element displayed in dom or not
		System.out.println(ele.isDisplayed());
		// isElementEnabled checks whether the check box is checked or not.
		System.out.println(ele.isEnabled());
		System.out.println(isElementPresent(By.id("js-link-box-enadf")));
		driver.close();

	}

	public static Boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (Throwable t) {
			return false;
		}

	}

}
