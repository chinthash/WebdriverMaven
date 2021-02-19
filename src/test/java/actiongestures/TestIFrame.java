package actiongestures;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestIFrame {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_intro_inner_html_quotes");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Either we have to use the below code before clicking on the iframe here or we can use switchtodefaultContent.
		// List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
		// System.out.println(iframes.size());
		// for (WebElement iframe : iframes) {
		// System.out.println(iframe.getAttribute("id"));
		// }
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("/html/body/button")).click();
		// defaultContent switch back the focus from iframe to the window back.
		driver.switchTo().defaultContent();
		List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
		System.out.println(iframes.size());
		for (WebElement iframe : iframes) {
			System.out.println(iframe.getAttribute("id"));
		}
	}

}
