package tasks;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import testbase.BaseClass;

public class CreateCustomer extends BaseClass {
  @Test
  public void testcreateCustomer() {
	  String custname = xllib.getExcelData("CreateCustomer", 1, 0);
	  String custdesc = xllib.getExcelData("CreateCustomer", 1, 1);  
	  System.out.println("Start create customer");
	  plib.navigateToProjectsCustomers();
	  driver.findElement(By.cssSelector("input[value='Create New Customer']")).click();
	  driver.findElement(By.name("name")).sendKeys(custname);
	  driver.findElement(By.name("description")).sendKeys(custdesc);
	  driver.findElement(By.name("createCustomerSubmit")).click();
	  System.out.println("End create customer");
  }
}
