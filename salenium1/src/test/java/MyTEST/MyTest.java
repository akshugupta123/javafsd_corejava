package MyTEST;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.WebDriver;
public class MyTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set up WebDriver - Replace the path with the actual path to your browser driver executable
       System.setProperty("webdriver.chrome.driver", "F:chromedriverjar\\chromedriver.exe");
        driver = new ChromeDriver();
        //System.setProperty("webdriver.edge.driver", "F:\\edgedriver\\msedgedriver.exe");
        //WebDriver driver = new EdgeDriver();
        
    }

    @Test
    public void testExample() throws InterruptedException {
        // Open the web application
        driver.get("https://www.flipkart.com/");
        Thread.sleep(80000);

//        // Find elements and perform actions
//        driver.findElement(By.id("username")).sendKeys("abc@gmail.com");
//        driver.findElement(By.id("password")).sendKeys("abc@123");
//        driver.findElement(By.id("login-button")).click();
//
//        // Perform assertions (for example, check if login was successful)
//        boolean isLoggedIn = driver.findElement(By.cssSelector(".user-profile")).isDisplayed();
//        Assert.assertTrue(isLoggedIn, "Login was not successful!");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser after the test
        driver.quit();
    }
}
