package org.SeleniumMaven;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Example1 {
	
	private WebDriver driver;
  @Test
  public void register() {
	  driver.findElement(By.linkText("REGISTER")).click();
	  driver.findElement(By.name("firstName")).sendKeys("Nikita");
	  driver.findElement(By.name("lastName")).sendKeys("Nikhare");
	  
	  
	  
	  driver.findElement(By.name("phone")).sendKeys("8585478541");
	  driver.findElement(By.id("userName")).sendKeys("nikita@gmail.com");
	  
	  driver.findElement(By.name("address1")).sendKeys("SaiNath Chowk Kharadi");
	  driver.findElement(By.name("city")).sendKeys("Pune");
	  
	  driver.findElement(By.cssSelector("input[name='state']")).sendKeys("Maharashtra");
	  driver.findElement(By.cssSelector("input[name='postalCode']")).sendKeys("444000");

	  Select country = new Select(driver.findElement(By.name("country")));
	  country.selectByVisibleText("INDIA");
	  
	  driver.findElement(By.id("email")).sendKeys("Nikita12345");
	  driver.findElement(By.name("password")).sendKeys("Pune");
	  driver.findElement(By.name("confirmPassword")).sendKeys("Pune");
	  
	  
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\A06438_P5.Training\\Desktop\\Driver\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  
//	  System.setProperty("webdriver.ie.driver", "C:\\Users\\A06438_P5.Training\\Desktop\\Driver\\IEDriverServer_Win32_3.12.0\\IEDriverServer.exe");
//	  driver = new InternetExplorerDriver();
//	  
//	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\A06438_P5.Training\\Desktop\\Driver\\geckodriver-v0.20.1-win64\\geckodriver.exe");
//	  driver = new FirefoxDriver();
	  
	  driver.get("http://newtours.demoaut.com/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
  }

  @AfterTest
  public void afterTest() {
	  
	  System.out.println("Information has been filled properly");
	  driver.close();
	  driver.quit();
  }

}
