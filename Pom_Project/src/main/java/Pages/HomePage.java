package Pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Base.Base;

public class HomePage extends Base {

	By Filterbox = By.xpath("//select[@class='product_sort_container']/option");
	By addtocart = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
	By clickcart = By.cssSelector("a.shopping_cart_link");
	By twitter = By.partialLinkText("Twitter");
	By twtsearch = By.cssSelector("input.r-30o5oe");

	public HomePage(WebDriver driver) {
		Base.driver = driver;
	}

	public void FilterBoxtest() throws InterruptedException {

		List<String> actual = new ArrayList<String>();
		List<String> exp = new ArrayList<String>();

		Thread.sleep(2000);
		List<WebElement> items = driver.findElements(Filterbox);
		for (WebElement x : items) {
			String text = x.getText().trim();
			actual.add(text);

		}

		System.out.println(actual);

		exp.add("Name (A to Z)");
		exp.add("Name (Z to A)");
		exp.add("Price (low to high)");
		exp.add("Price (high to low)");

		System.out.println(exp);
		if (actual.equals(exp)) {
			System.out.println("All items are present");
		} else {
			System.out.println("Fail : All items are not present");
		}

	}

	public void addtocart() {
		driver.findElement(addtocart).click();
		driver.findElement(clickcart).click();

	}

	public void linknewtab() throws InterruptedException {
		String parent = driver.getWindowHandle();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		driver.findElement(twitter).click();

		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			if (!window.equals(parent)) {

				driver.switchTo().window(window);
				Thread.sleep(5000);
				WebElement k = driver.findElement(twtsearch);
				Thread.sleep(2000);
				k.sendKeys("cowin");

				k.sendKeys(Keys.ENTER);
				driver.findElement(By.linkText("Videos")).click();

				Thread.sleep(2000);
				driver.close();

				driver.switchTo().window(parent);

			}
		}

	}

}
