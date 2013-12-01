package tasks;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import testbase.BaseClass;

public class DeleteCustomer extends BaseClass {
  @Test
  public void testdeleteCustomer() {
	  String custname = xllib.getExcelData("DeleteCustomer", 1, 0);
	  System.out.println("Start delete customer");
	  plib.navigateToProjectsCustomers();
	  driver.findElement(By.linkText(custname)).click();
	  driver.findElement(By.cssSelector("input[value='Delete This Customer']")).click();
	  driver.findElement(By.id("deleteButton")).click();
	  System.out.println("End delete customer");
  }
}
