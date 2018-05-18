package org.SeleniumMaven;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest extends DataProviderEX{
	
  @BeforeTest
	  public void beforeTest() {
		  System.out.println("Test1: Before Test");
	  }
	
	
  @Test
  public void test1_1() {
	  System.out.println("Test1_1 begins");
	  try {
		   int a, b=5,c=0;
		   a=b/c;
		   System.out.println(a);
		  }catch(Exception e) {
	  throw e;
	  }
  }
  
  
  @Test
  public void test1_2() {
	  System.out.println("Test1_2 begins");
	  
  }
   
  @Test(dataProvider = "Data1")
  public void test1_3(String n, String s) {
	  System.out.println("User: " +n+ " password: " +s);
	  
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Test1: After Test");
  }

}
