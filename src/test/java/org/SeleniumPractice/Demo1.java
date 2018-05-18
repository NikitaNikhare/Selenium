package org.SeleniumPractice;

import org.testng.annotations.Test;

import utility.ExcelUtility;
import utility1.ExcelUtility1;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Demo1 {
		private WebDriver driver;
		private static int rownum = 0;
		private int colnum= 2;
		
		
 	  @Test(dataProvider = "Credential")
		public void loginPage1(String uname, String pass) throws Exception {

//			try 
//			{
 		  		ExcelUtility1.setExcelPath1("Sheet1", "C:\\Users\\A06438_P5.Training\\Desktop\\Driver\\testdata.xlsx");
				WebElement username = driver.findElement(By.id("userName"));
				username.clear();
				username.sendKeys(uname);

				WebElement password = driver.findElement(By.id("password"));
				password.clear();
				password.sendKeys(pass);

				driver.findElement(By.cssSelector("input.btn:nth-child(1)")).click();
				//driver.navigate().back();

				String title = driver.getTitle();
				Assert.assertEquals(title,"Home");
//				//ExcelUtility1.setExcelCell(rownum,colnum, "Pass");
//				Thread.sleep(5000);
//			} catch (AssertionError e)
//			{
//				ExcelUtility.setExcelCell(rownum,colnum, "Fail");
//			}
//			}finally
//		{
//				rownum++;
//				driver.navigate().to("http://localhost:8083/TestMeApp/login.htm");
//			}
		}
  
  
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\A06438_P5.Training\\Desktop\\Driver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

		//	  System.setProperty("webdriver.ie.driver", "C:\\Users\\A06438_P5.Training\\Desktop\\Driver\\IEDriverServer_Win32_3.12.0\\IEDriverServer.exe");
		//	  driver = new InternetExplorerDriver();
		//	  
//			  System.setProperty("webdriver.gecko.driver", "C:\\Users\\A06438_P5.Training\\Desktop\\Driver\\geckodriver-v0.20.1-win64\\geckodriver.exe");
//			  driver = new FirefoxDriver();

		driver.get("http://localhost:8083/TestMeApp/login.htm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  
  
  @AfterTest
  public void afterTest() {
	  driver.close();
	  driver.quit();
	  
  }

}
