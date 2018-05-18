package org.SeleniumMaven;

import org.testng.annotations.Test;

import utility.ExcelUtility;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;


public class ExcelReadExample1 {

	private WebDriver driver;
	private static int rownum = 0;
	private int colnum= 2;

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\A06438_P5.Training\\Desktop\\Driver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

		//	  System.setProperty("webdriver.ie.driver", "C:\\Users\\A06438_P5.Training\\Desktop\\Driver\\IEDriverServer_Win32_3.12.0\\IEDriverServer.exe");
		//	  driver = new InternetExplorerDriver();
		//	  
		//	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\A06438_P5.Training\\Desktop\\Driver\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		//    driver = new FirefoxDriver();

		driver.get("http://localhost:8083/TestMeApp/login.htm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(driver, LoginPageObject.class);
	}
	
	
	@Test(dataProvider = "Credential", priority=1)
	public void ExcelRead1_Login(String uname, String pass) throws Exception {
		try 
		{
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
			ExcelUtility.setExcelCell(rownum,colnum, "Pass");
			Thread.sleep(5000);
		} catch (AssertionError e)
		{
			ExcelUtility.setExcelCell(rownum,colnum, "Fail");
		}
		//}finally
		//{
			//rownum++;
			//driver.navigate().to("http://localhost:8083/TestMeApp/login.htm");
		//}
	}
	
	@Test(priority =2)
	public void select_category ()
	{
		try
		{
		WebElement category = driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[2]/a/span"));
		Actions act = new Actions(driver);
		act.moveToElement(category).click().build().perform();
		
		WebElement Electronics = driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[2]/ul/li[1]/a/span"));
		Actions act1 = new Actions(driver);
		act1.moveToElement(Electronics).click().build().perform();
		
		WebElement HeadPhones = driver.findElement(By.xpath("//*[@id=\"submenuul11290\"]/li[1]/a/span"));
		Actions act2 = new Actions(driver);
		act2.moveToElement(HeadPhones).click().build().perform();
		
		String title = driver.getTitle();
		Assert.assertEquals(title,"Search");
		System.out.println("Successfully Selected Category");
	    } catch (AssertionError e)
	    {
		System.out.println("Category not been selected");
	    }
		
   }
	
	@Test(priority =3)
	public void AddToCart()
	{
		try
		{
		WebElement AddCart = driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a"));
		AddCart.click();
		
		String title = driver.getTitle();
		Assert.assertEquals(title,"Search");
		System.out.println("Add To Cart Selected");
	    } catch (AssertionError e)
	    {
		System.out.println("Add To Cart not been Selected");
	    }
	}
	
	@Test(priority =4)
	public void cart()
	{
	    try
	    {
		WebElement cart1 = driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/a[2]"));
		cart1.click();
		
		String title = driver.getTitle();
		Assert.assertEquals(title,"View Cart");
		System.out.println("Display the shopping cart");
	    } catch (AssertionError e)
	    {
		System.out.println("Shopping cart not been displayed");
	    }
	}
	
	
	
	@Test(priority=5)
	public void checkout()
	{
		try
		{
		WebElement checkout1 = driver.findElement(By.xpath("//*[@id=\"cart\"]/tfoot/tr[2]/td[5]/a"));
		checkout1.click();
		
		String title = driver.getTitle();
		Assert.assertEquals(title,"Cart Checkout");
		System.out.println("You are on Review and Payment");
	    } catch (AssertionError e)
	    {
		System.out.println("No page for review and Payment");
	    }
		
	}
	
	
	@Test(priority=6)
	public void payment()
	{
		try
		{
		WebElement proceedToPay = driver.findElement(By.xpath("/html/body/b/div/div/div[1]/div/div[2]/div[3]/div/form[2]/input"));
		proceedToPay.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String title = driver.getTitle();
		Assert.assertEquals(title,"Payment Gateway");
		System.out.println("Successfully Selected Category");
	    } catch (AssertionError e)
	    {
		System.out.println("Category not been selected");
	    }
	}
	
	
	@Test(priority=7)
	public void BankDetails() throws Exception
	{
		try
		{
		WebElement bankname = driver.findElement(By.xpath("//*[@id=\"swit\"]/div[1]/div/label"));
		bankname.click();
				
		WebElement continue1 =driver.findElement(By.xpath("//*[@id=\"btn\"]"));
		continue1.click();
		
		String title = driver.getTitle();
		Assert.assertEquals(title,"Payment Gateway");
		System.out.println("Bank Details selected");
	    } catch (AssertionError e)
	    {
		System.out.println("Can not select bak details");
	    }
		
	}
	

	
	@Test(priority=8)
	public void bankcredential()
	{
		try
		{
		driver.findElement(By.xpath("//*[@id=\"myForm\"]/input[1]")).sendKeys("Andhra Bank");
		driver.findElement(By.xpath("//*[@id=\"myForm\"]/input[2]")).sendKeys("Trans@456");
		WebElement login1 =driver.findElement(By.xpath("//*[@id=\"myForm\"]/div[1]/div[3]/input"));
		login1.click();
		
		String title = driver.getTitle();
		Assert.assertEquals(title,"Apache Tomcat/7.0.68 - Error report");
		System.out.println("Bank Credential Added");
	    } catch (AssertionError e)
	    {
		System.out.println("Not accepting bank credential");
	    }
		
	}
	

	@DataProvider(name="Credential")
	public String[][] login_data() throws Exception{
		ExcelUtility.setExcelPath("Sheet1", "C:\\Users\\A06438_P5.Training\\Desktop\\Driver\\testdata.xlsx");
		String[][] tabledata = ExcelUtility.getExcelTable();
		return tabledata;

	}



	@AfterTest
	public void afterTest() {

		driver.close();
		driver.quit();

	}

}

