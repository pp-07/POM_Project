package Testing;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.Base;
import Pages.HomePage;
import Pages.LoginPage;

public class HomePage_Test extends Base {

	LoginPage obj1 = new LoginPage(driver);
	HomePage obj = new HomePage(driver);

	@BeforeClass
	public void beforeclass() {

		initialization();
		obj1.loginforshop(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority = 0)
	public void filtertest() throws InterruptedException {

		obj.FilterBoxtest();
	}

	@Test(priority = 2)
	public void cart() {

		obj.addtocart();
	}

	@Test(priority = 1)
	public void twitter() throws InterruptedException {
		obj.linknewtab();

	}

	@AfterClass
	public void teardown() throws InterruptedException {
		Thread.sleep(1000);
		driver.close();
	}
}