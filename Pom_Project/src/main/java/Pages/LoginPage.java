package Pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import Base.Base;

public class LoginPage extends Base {

	By logo = By.cssSelector("div.login_logo");
	By username = By.xpath("//input[@id='user-name']");
	By pass = By.xpath("//input[@id='password']");
	By button = By.xpath("//input[@id='login-button']");

	public LoginPage(WebDriver driver) {
		Base.driver = driver;
	}
	public static void ss() throws IOException { 

		Date d= new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		 TakesScreenshot scrShot =((TakesScreenshot)driver);
		   File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		 
		   FileUtils.copyFile(SrcFile, new File ("C:\\Users\\PRERAK PATEL\\Dropbox\\My PC (LAPTOP-1GOPOLA3)\\Desktop\\Selenium SS\\"+ sdf.format(d)+".png"));
	}

	public void logotext() {
		String s= driver.findElement(logo).getAttribute("class");
		System.out.println(s);
		
		if (s.contains("swag")) {
			System.out.println("pass");
		}else {
			System.out.println("fail");
		}
		
	}
	public void testlogin(String Loginid,String password,String status) throws InterruptedException, IOException {
		
WebElement  log=	driver.findElement(username);
	      log.clear();
	      log.sendKeys(Loginid);
		Thread.sleep(2000);
WebElement p=	driver.findElement(pass);
	      p.clear();
	      p.sendKeys(password);



		driver.findElement(button).click();
		Thread.sleep(2000);
		
		ss();
		
		String title=driver.getCurrentUrl();
		
		String exptitle ="https://www.saucedemo.com/inventory.html";
		
		if (status.equals("valid")) {
			
			if(title.equals(exptitle)) {
				Thread.sleep(2000);
				driver.navigate().back();
			}else {
				
		System.out.println(Loginid +" "+ "Valid :Test case is failed");
			}
			}
		
		
			else if(status.equals("invalid")) {
				if(title.equals(exptitle)) {
					Thread.sleep(2000);
					driver.navigate().back();
					System.out.println(Loginid +" invalid :test case fail");
				}
				else {
					System.out.println("test case pass");
				}
			}

		}


	public void loginforshop(String id, String pa) {
		WebElement user = driver.findElement(username);
		user.clear();
		user.sendKeys(id);
		WebElement p1 = driver.findElement(pass);
		p1.clear();
		p1.sendKeys(pa);
		driver.findElement(button).click();

	}

}
