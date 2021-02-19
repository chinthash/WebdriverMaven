package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTables {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://money.rediff.com/gainers/bsc/daily/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<WebElement> rowsize = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
		System.out.println("number of rows = " + rowsize.size());
		List<WebElement> colsize = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr[1]/td"));
		System.out.println("number of columns = " + colsize.size());
		for (int r = 1; r <= rowsize.size(); r++) {
			for (int c = 1; c <= colsize.size(); c++) {
				WebElement ele = driver
						.findElement(By.xpath("//table[@class='dataTable']/tbody/tr[" + r + "]/td[" + c + "]"));
				System.out.print(ele.getText() + "\t");
			}
			System.out.println();
		}

	}

}
