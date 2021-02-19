package screenshot;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeScreenshot {
	public static WebDriver driver;

	public static void TakeScreenshotMethod() throws IOException {
		Date d = new Date();
		String date = d.toString();
		System.out.println(date);
		String s = date.replace(":", "_").replace(" ", "_");
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(".//screenshots/error_" + s + ".jpg"));
	}

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_canvas_get");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.switchTo().frame("iframeResult");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("myFunction()");
		try {
			driver.findElement(By.id("abc"));
		} catch (Throwable t) {

			TakeScreenshotMethod();
		}
		driver.close();
	}

}
