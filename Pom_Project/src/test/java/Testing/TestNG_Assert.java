package Testing;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.*;

import Base.Base;
import Utilities.Uitility;



public class TestNG_Assert extends Base {
	
	
	  WebDriver driver;
	  
@BeforeClass 
	  public void BeforeClass() {
		  System.out.println("Start the execution");
	  }

@DataProvider(name="Cycle2")           //directly given inputs from this dataprovider ,no need of excel and writing exel in data provider
public Object[][] getDataFromDataprovider(){
Object arr2 [][] 	=	
	{
        { "standard_user", "secret_sauce" },
        { "problem_user", "secret_sauce" },
       
                                             };
return arr2;
    }
@DataProvider(name = "Cycle1")   //first we need to write excel data in this dataprovider through the excel code and then pass it to a method 
public Object[][] getData() throws IOException {
  
String path= ".\\Testdata\\Login.xlsx";  //change the path

Uitility util =new Uitility(path);
int totalrows =util.getRowCount("Sheet2");
int totalcols =util.getCellCount("Sheet2",1);
Object arr1 [][] =new Object[totalrows][totalcols]; 

for (int i=1;i<=totalrows;i++) {
	for (int j=0; j< totalcols;j++) {
		arr1 [i-1][j] =util.getCellData("Sheet2", i, j);
	}
}
return arr1;
}
@AfterClass
	  public void AfterClass() {
		  System.out.println("End of exceution");
	  }
	  
@BeforeTest
	  public void BeforeTest() throws InterruptedException {
		  System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\PRERAK PATEL\\Dropbox\\My PC (LAPTOP-1GOPOLA3)\\Desktop\\Drivers\\chromedriver.exe");
		         driver=  new ChromeDriver();
		         driver.get("https://www.ebay.com/"); 
		     	 driver.manage().window().maximize();
		     	 Thread.sleep(1000);
		     	 }
	  
@AfterTest
	  public void AfterTest() {
		  driver.close();
	  }
	  
@Test
  public void method1() throws InterruptedException {
	  
	 driver.findElement(By.id("gh-btn")).click();
	  
	 String a =driver.getCurrentUrl();
	 String b = driver.getTitle();
	 System.out.println(a);
	 System.out.println(b);
 // Assert.assertEquals(a ,"abab", "url is not matching" );
  try{Assert.assertNotEquals(a ,"https://www.ebay.com/n/all-categories", "url is matching" );}
  catch (AssertionError e) {
	  e.printStackTrace();
  }
  
  System.out.println("assert continue check");
 
  }
  
  @Test
  public void method2() throws InterruptedException {
	  SoftAssert sa = new SoftAssert();
	  
	  driver.findElement(By.id("gh-btn")).click();
	  String a =driver.getCurrentUrl();
	  String b = driver.getTitle();
	  System.out.println(a);
	  System.out.println(b);
	 
 sa.assertEquals(a ,"abab", "url is not matching" );
 sa.assertNotEquals(a ,"https://www.ebay.com/n/all-categories", "url is matching" );

 System.out.println("assert continue check");
 sa.assertAll();
	  
	  
  }
  
}
