package com.testng.demos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMTests {
	//private static WebDriver driver;
	
	private WebDriver driver=null;
	
	@Parameters("browserName")
	@BeforeTest
	public void InitalizeDriver(int browserName)
	{// 1 = Chrome  2 = Edge  3 = FireFox
		switch(browserName)
		{
		case 1:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case 2:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case 3:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		}
		driver.manage().window().maximize();
		System.out.println("Before Test");
	}
	
	
	@Test
	public void LaunchApp() throws Exception
	{
		//driver = new ChromeDriver();
		//WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
		driver.get("file:///C:/WeekendDesigningSessions/Ex5.html");
		//driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys("Admin");
		//driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("admin123");
		//driver.findElement(By.name("Login")).submit();
		
		Thread.sleep(5000);
		driver.quit();
	}

	@Test
	public void ViewMyInfo() throws Exception
	{
		//driver = new ChromeDriver();
		//WebDriverManager.chromedriver().setup();
		//driver.manage().window().maximize();
		driver.get("file:///C:/WeekendDesigningSessions/Ex4.html");
		Thread.sleep(5000);
		driver.quit();
	}
	
	/*
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("This is before method annoation");
	}
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("This is after method annoation");
	}
	
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("This is before class annotation");
	}
	@AfterClass
	public void afterClass()
	{
		System.out.println("This is after class annotation");
	}
	
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("This is before test annotation");
	}
	
	@AfterTest
	public void afterTest()
	{
		System.out.println("This is after test annotation");
	}
	
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("This is before suite annotation");
	}
	
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("This is after suite annotation");
	}
	*/
}
