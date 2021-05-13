package Testing;

import org.testng.annotations.Test;

import Base.Base;
import Pages.LoginPage;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Login_Test extends Base {

	@BeforeClass
	public void beforeclass() {

		initialization();
	}

	@Test
	public void login() {

		LoginPage ob = new LoginPage(driver);
		ob.loginforshop(prop.getProperty("username"), prop.getProperty("password"));

	}

	@AfterClass
	public void teardown() throws InterruptedException {
		Thread.sleep(1000);
		driver.close();
	}

}
