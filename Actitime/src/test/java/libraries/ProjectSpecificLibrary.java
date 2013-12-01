package libraries;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectSpecificLibrary {
	public WebDriver driver;
	public void navigateToProjectsCustomers(){
		driver.findElement(By.xpath("//a[@href='/tasks/otasklist.do']")).click();
		driver.findElement(By.linkText("Projects & Customers")).click();
	}

}
