package com.testng.demos;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoAnnotations {

	@Test
	public void TestMethod1()
	{
		System.out.println("this is test case method-1");
	}

	@Test
	public void TestMethod2()
	{
		System.out.println("this is test case method-2");
	}

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
}
