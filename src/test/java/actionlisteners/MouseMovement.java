package actionlisteners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.internal.EventFiringMouse;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseMovement {
	public static void main(String args[]) {
		WebDriverManager.chromedriver().setup();
		WebDriver webdriver = new ChromeDriver();
		EventFiringWebDriver driver = new EventFiringWebDriver(webdriver);
		WebListeners listener = new WebListeners();
		driver.register(listener);
		EventFiringMouse mouse = new EventFiringMouse(driver, listener);
		driver.navigate().to("https://google.com");
		Locatable hover = (Locatable) driver
				.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input"));
		Coordinates cord = hover.getCoordinates();

		try {
			mouse.mouseMove(cord);
		} catch (Throwable t) {

		}

	}
}