package org.SeleniumMaven;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class NewTest1 {
  @Test
  public void Test2_1() {
	  System.out.println("Test2_1 begins");
  }
  
  @Test
  public void Test2_2() {
	  System.out.println("Test2_2 begins");
  }
  
  @Test
  public void Test2_3() {
	  System.out.println("Test2_3 begins");
  }
  
  @BeforeTest
  public void beforeTest() {
	  System.out.println("Test2: Before test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Test2: After test");
  }
  
  @BeforeMethod
  public void beforeMethod()
  {
	  System.out.println("Before Method");
  }
  
  @AfterMethod
  public void AfterMethod()
  {
	  System.out.println("After Method");
  }

}
