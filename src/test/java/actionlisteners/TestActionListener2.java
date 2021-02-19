package actionlisteners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestActionListener2 {

	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		WebDriver webdriver = new FirefoxDriver();
		EventFiringWebDriver driver = new EventFiringWebDriver(webdriver);
		WebListeners listener = new WebListeners();
		driver.register(listener);
		driver.navigate().to("https://www.facebook.com");
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div/div[2]/div/div[1]/form/div[3]/a"))
				.click();

	}

}
