package jquerycalendar;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestJqueryCalendar {

	public static int currentday = 0, currentmonth = 0, currentyear = 0;
	public static int targetday = 0, targetmonth = 0, targetyear = 0;

	public static int monthsToJump = 0;
	public static boolean increment = true;

	public static void main(String[] args) throws InterruptedException {

		String targetdate = "11/05/2020";
		getCurrentDateMonthYear();
		getTargetDateMonthYear(targetdate);
		calcMonthsToJump();
		System.out.println(monthsToJump);
		jumptoTargetMonth();
		System.out.println(increment);

	}

	public static void getCurrentDateMonthYear() {
		Calendar cal = Calendar.getInstance();
		currentday = cal.get(Calendar.DAY_OF_MONTH);
		currentmonth = cal.get(Calendar.MONTH) + 1;
		currentyear = cal.get(Calendar.YEAR);
		System.out.println(
				"Current Date Month and year is --> " + currentday + "   " + currentmonth + "   " + currentyear);
	}

	public static void getTargetDateMonthYear(String targetdate) {
		int firstIndex = targetdate.indexOf("/");
		int lastIndex = targetdate.lastIndexOf("/");

		targetday = Integer.parseInt(targetdate.substring(0, firstIndex));
		targetmonth = Integer.parseInt(targetdate.substring(firstIndex + 1, lastIndex));
		targetyear = Integer.parseInt(targetdate.substring(lastIndex + 1, targetdate.length()));
		System.out.println("Target Date Month and year is --> " + targetday + "  " + targetmonth + "  " + targetyear);

	}

	public static void calcMonthsToJump() {
		if ((targetmonth - currentmonth) > 0) {
			monthsToJump = targetmonth - currentmonth;
		} else {
			monthsToJump = currentmonth - targetmonth;
			increment = false;
		}
	}

	public static void jumptoTargetMonth() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://way2automation.com/way2auto_jquery/datepicker.php");
		driver.findElement(By.linkText("Signin")).click();
		driver.findElement(By.xpath("//div/div[@class='popupbox']/*[@id='load_form']/fieldset[1]/input"))
				.sendKeys("shingo");
		driver.findElement(By.xpath("//div/div[@class='popupbox']/*[@id='load_form']/fieldset[2]/input"))
				.sendKeys("shingo");
		driver.findElement(By.xpath("//div/div[@class='popupbox']/*[@id='load_form']/div/div[2]/input")).click();
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[@id=\'toggleNav\']/li[3]/a"))).perform();
		driver.findElement(By.linkText("Datepicker")).click();
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		driver.findElement(By.xpath("//*[@id=\'datepicker\']")).click();
		for (int i = 0; i < monthsToJump; i++) {
			if (increment) {
				driver.findElement(By.xpath("//*[@id=\'ui-datepicker-div\']/div/a[2]/span")).click();
			} else
				driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span")).click();
			Thread.sleep(1000);
		}
		driver.findElement(By.linkText(Integer.toString(targetday))).click();
	}

}
