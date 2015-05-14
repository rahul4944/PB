package com.digitaslbi.PB;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class BrandStory {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeMethod
  public void setUp() throws Exception {
	  
	// TESTING ON SAFARI BROWSER
	  
	driver = new SafariDriver();
    //System.out.println("Opening Safari Browser");
	
	// TESTING ON FIREFOX BROWSER
	
	//driver = new FirefoxDriver();
	//System.out.println("Opening FF Browser");
	
	driver.manage().window().maximize(); //This is for FF and Safari Browser
	
	// TESTING ON CHROME BROWSER
	
	//System.setProperty("webdriver.chrome.driver", "//Users//rpatel2//Downloads/chromedriver");
	//driver = new ChromeDriver(); 
	//driver.manage().window().setSize(new Dimension(1366 , 786)); //This is for Chrome browser only
	
	// TESTING ENVIRONMENT

	baseUrl = "http://www.pitneybowes.com/";
	//baseUrl = "http://stg.pitneybowes.com";
	
    driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
    
    // INVOKE URL
    
    driver.get(baseUrl + "/us");
    
  }

  @Test
  public void TC1_testBrandStory() throws Exception {
	  
	 // Validate all tool-tip

    driver.findElement(By.linkText("SEE HOW")).click();
    System.out.println("Opening FF Browser");
    Thread.sleep(3000);
    driver.findElement(By.cssSelector("#nav-2 > div.dot")).click();
    Thread.sleep(2000);
    driver.findElement(By.cssSelector("#nav-3 > div.dot")).click();
    Thread.sleep(2000);
    driver.findElement(By.cssSelector("#nav-4 > div.dot")).click();
    Thread.sleep(2000);
    driver.findElement(By.cssSelector("#nav-5 > div.dot")).click();
    Thread.sleep(2000);
    driver.findElement(By.cssSelector("#nav-6 > div.dot")).click();
    Thread.sleep(2000);
    driver.findElement(By.cssSelector("#nav-7 > div.dot")).click();
    Thread.sleep(2000);
    driver.findElement(By.cssSelector("#nav-8 > div.dot")).click();
    Thread.sleep(2000);
    driver.findElement(By.cssSelector("#nav-9 > div.dot")).click();
    Thread.sleep(2000);
    driver.findElement(By.cssSelector("#nav-10 > div.dot")).click();
    Thread.sleep(2000);
    try {
        assertTrue(isElementPresent(By.linkText("GET IN TOUCH")));
      } catch (Error e) {
        verificationErrors.append(e.toString());
      }
  }

  @AfterMethod
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}



