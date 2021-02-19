package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetAllLinks {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.wikipedia.org");
		List<WebElement> list = driver.findElements(By.tagName("a"));
		System.out.println(list.size());
		for (WebElement w : list) {
			System.out.println(w.getText());
		}
		System.out.println("--------------------------------------------------");
		// to get the total links in particular block
		WebElement ele = driver.findElement(By.xpath("//*[@id=\"www-wikipedia-org\"]/div[2]"));
		List<WebElement> list2 = ele.findElements(By.tagName("a"));
		System.out.println(list2.size());
		for (WebElement w2 : list2) {
			System.out.println(w2.getText());
		}
	}

}
