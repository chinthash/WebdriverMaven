package screenshot;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeScreenshotElement {
	public static WebDriver driver;

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		WebElement ele = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[1]"));
		try {
			ele = driver.findElement(By.id("abc"));
		} catch (Throwable t) {

			TakeScreenshotElementMethod(ele);
		}
		driver.close();

	}

	public static void TakeScreenshotElementMethod(WebElement ele) throws IOException {
		Date d = new Date();
		String date = d.toString();
		System.out.println(date);
		String s = date.replace(":", "_").replace(" ", "_");
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		BufferedImage fullscreenshot = ImageIO.read(screenshot);
		Point point = ele.getLocation();
		int eleWidth = ele.getSize().getWidth();
		int eleHeight = ele.getSize().getHeight();
		BufferedImage elescreenshot = fullscreenshot.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
		ImageIO.write(elescreenshot, "jpg", screenshot);
		FileUtils.copyFile(screenshot, new File(".//screenshots//googleimg_" + s + ".jpg"));

	}

}
