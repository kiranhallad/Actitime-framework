package testbase;

import java.util.concurrent.TimeUnit;

import libraries.ExcelLibrary;
import libraries.ProjectSpecificLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	public WebDriver driver;
	public ExcelLibrary xllib;
	public ProjectSpecificLibrary plib;
 @BeforeClass
 public void launchBrowser(){
	 xllib =new ExcelLibrary();
	 System.out.println("Launching Browser and opening application url");
	 driver = new FirefoxDriver();
	 driver.get("http://client-pc/login.do");
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 plib = new ProjectSpecificLibrary();
	 plib.driver=this.driver;
 }
 
 @BeforeMethod
 public void login(){
	 String un= xllib.getExcelData("Login", 1, 0);
	 String pw= xllib.getExcelData("Login", 1, 1);
	 
	 System.out.println("Login to the Application");
	 driver.findElement(By.name("username")).sendKeys(un);
	 driver.findElement(By.name("pwd")).sendKeys(pw);
	 driver.findElement(By.id("loginButton")).click();
 }
 
 @AfterMethod
 public void logout(){
	 System.out.println("Logout from the application");
	 driver.findElement(By.linkText("Logout")).click();
 }
 
 @AfterClass
 public void quit(){
	 System.out.println("Quit the Browser");
	 driver.quit();
 }
}
