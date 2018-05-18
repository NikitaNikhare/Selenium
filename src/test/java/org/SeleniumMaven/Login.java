package org.SeleniumMaven;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;

public class Login {
	private WebDriver driver;
	
  @Test
  public void GoToLogin() {
	  
	  LoginPageObject.uname.sendKeys("Nikita");
	  LoginPageObject.password.sendKeys("password");
	  LoginPageObject.Login.click();
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
	  PageFactory.initElements(driver, LoginPageObject.class);
  }

  @AfterTest
  public void afterTest() {
	  
	  driver.close();
	  driver.quit();

  }

}
