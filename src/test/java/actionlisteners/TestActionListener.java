package actionlisteners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestActionListener {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver webdriver = new ChromeDriver();
		EventFiringWebDriver driver = new EventFiringWebDriver(webdriver);
		WebListeners listener = new WebListeners();
		driver.register(listener);
		driver.get("https://google.com");
		driver.findElement(By.xpath("//*[@id=\'prm\']/div/a")).click();
		driver.navigate().back();
		driver.findElement(By.xpath("//*[@id=\'tsf\']/div[2]/div[1]/div[3]/center/input[2]")).click();
		driver.navigate().back();
		Thread.sleep(5000);
		driver.navigate().forward();
	}

}
