package launchbrowserswithoutexecutables;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchIEBrowser {

	public static void main(String[] args) {
		WebDriverManager.iedriver().setup();
		WebDriver driver = new InternetExplorerDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.close();
	}

}
