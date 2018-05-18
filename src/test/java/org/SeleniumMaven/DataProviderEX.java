package org.SeleniumMaven;

import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class DataProviderEX {
	
  @BeforeTest
  public void beforeTest3()
  {
	  System.out.println("Data provider Test Starts");
  }
  
  @Test(dataProvider = "Data1")
  public void Test3(String n, String s) {
	  
	  System.out.println("User: " +n+ " password: " +s);
	  
  }

  @DataProvider(name="Data1")
  public String[][] dp() {
    return new String[][] {
      new String[] { "User1", "Pass1" },
      new String[] { "User1", "Pass1" },
      new String[] { "User1", "Pass1" },
      new String[] { "User1", "Pass1" },
       };
  }
  
  
  @AfterTest
  public void afterTest3()
  {
	  System.out.println("Data provider Test End");
  }
}
