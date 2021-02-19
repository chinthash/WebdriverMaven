package actiongestures;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchWindows {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.switchTo().frame("login_page");
		driver.findElement(By.name("fldLoginUserId")).sendKeys("12345678");
		driver.findElement(
				By.xpath("/html/body/form/table[2]/tbody/tr/td[3]/table/tbody/tr[1]/td/table[2]/tbody/tr/td[3]/p/a"))
				.click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		String first_window = iterator.next();
		String second_window = iterator.next();
		System.out.println("first window name is " + first_window);
		System.out.println("second window name is " + second_window);
		driver.switchTo().window(second_window);
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//a[@title='NRI']")).click();
		driver.close();
		driver.switchTo().window(first_window);
		System.out.println(driver.getTitle());
		driver.switchTo().frame("login_page");
		driver.findElement(By.name("fldLoginUserId")).sendKeys("9876543210");
		driver.close();

	}

}
