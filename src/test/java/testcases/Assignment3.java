package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://timesofindia.indiatimes.com/poll.cms");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String s = driver.findElement(By.id("mathq2")).getText();
		System.out.println(s);
		System.out.println(s.length());
		int i = Integer.parseInt(String.valueOf(s.charAt(0)));
		int j = Integer.parseInt(String.valueOf(s.charAt(4)));
		switch (s.charAt(2)) {
		case '+':
			System.out.println(i + j);
			break;
		case '-':
			System.out.println(i - j);
			break;
		case '*':
			System.out.println(i * j);
			break;
		}
		driver.close();
	}

}
