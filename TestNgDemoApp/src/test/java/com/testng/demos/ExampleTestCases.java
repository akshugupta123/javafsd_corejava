package com.testng.demos;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExampleTestCases {

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
	/*
	@AfterTest
	public void CloseDriver()
	{
		driver = null;
		System.out.println("After method");
	}
	*/
	@Parameters({"sleeptime", "url"})
	@Test
	public void TestGoogle(int sleeptime, String url) throws Exception
	{
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get(url);
		driver.findElement(By.name("q")).sendKeys("java tutorial", Keys.ENTER);
		//driver.findElement(By.name("q")).submit();
		System.out.println("Page Title is : " + driver.getTitle());
		String expected = "java tutorial - Google Search";
		String actual = driver.getTitle();
		Assert.assertEquals(actual, expected, "Both are Mismatched...");
		Thread.sleep(sleeptime);
		driver.quit();
	}
	
	@Parameters("sleeptime")
	@Test
	public void TestFaceBook(int sleeptime) throws Exception
	{
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get("http://www.facebook.com/");
		driver.findElement(By.name("email")).sendKeys("venugopal@gmail.com", Keys.ENTER);
		System.out.println("Page Title is : " + driver.getTitle());
		
		SoftAssert  soft = new SoftAssert();  
		// Title Assertion
		String expected="Log in to Facebooks";
		String actual = driver.getTitle();
		//soft.assertEquals(actual, expected, "Title Mismatch");
		soft.assertTrue(actual.equals(expected), "Title Mismatch");
		
		//URL Assertion
		String expectedUrl="http://www.facebook.com/";
		String actualUrl = driver.getCurrentUrl();
		soft.assertEquals(actualUrl, expectedUrl, "URL Mismatch");
		
		// Text Assertion :- textbox is empty or not
		String actualText = driver.findElement(By.name("email")).getAttribute("value");
		String expectedText = "venugopal@gmail.com";
		soft.assertEquals(actualText, expectedText, "Text is Mismatch");
		
		// Border assertion
		//1px solid #f02849  = hexa decimal color
		//1px solid rgb(240, 40, 73) = rgb color
		String actualBorder = driver.findElement(By.name("email")).getCssValue("border");
		String expectedBorder = "1px solid rgb(221, 223, 226)";
		System.out.println(actualBorder);
		soft.assertEquals(actualBorder, expectedBorder, "Border color mismatch");
		
		Thread.sleep(sleeptime);
		driver.quit();
		soft.assertAll();  // it will provide error report.
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
