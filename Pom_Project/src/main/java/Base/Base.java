package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	public static WebDriver driver;
	public static Properties prop;

	public Base() {
		prop = new Properties();
		try {
			FileInputStream fi = new FileInputStream(
					"C:\\Users\\PRERAK PATEL\\eclipse-workspace\\Pom_Project\\src\\main\\java\\Pages\\coniguration");
			prop.load(fi);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {

		System.setProperty("webdriver.chrome.driver",
				prop.getProperty("chromepath"));
		driver = new ChromeDriver();

		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

}
