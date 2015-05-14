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

public class Homepage {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  
  public String currentURL;


  @BeforeMethod
  public void setUp() throws Exception {
	  
	  	// TESTING ON SAFARI BROWSER
	  
	  	//driver = new SafariDriver();
		
		// TESTING ON FIREFOX BROWSER
		
		driver = new FirefoxDriver();
		
		driver.manage().window().maximize(); //This is for FF and Safari Browser
		
		// TESTING ON CHROME BROWSER
		
		//System.setProperty("webdriver.chrome.driver", "//Users//rpatel2//Downloads/chromedriver");
		//driver = new ChromeDriver(); 
		//driver.manage().window().setSize(new Dimension(1366 , 786)); //This is for Chrome browser only
		
		//TESTING ENVIRONMENT
		
		baseUrl = "http://www.pitneybowes.com";
		//baseUrl = "http://stg.pitneybowes.com";
		
	    driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	    
	    // Invoke URL
	    
	    driver.get(baseUrl + "/us");
	    
  }

  @Test
  public void TC1_testPBlogo() throws Exception {
	  
	 // Validate PB Logo and capture navigated URL
    
    driver.findElement(By.cssSelector("a")).click();
    driver.getCurrentUrl();
    System.out.println( driver.getCurrentUrl());
  }
  
  @Test
  public void TC2_testHeaderNavigationOptions() throws Exception {
    
    // Validate Header Navigation Options
    
    driver.findElement(By.linkText("SHOP")).click();
    driver.findElement(By.linkText("PB Home")).click();
    driver.findElement(By.linkText("MY ACCOUNT")).click();
    driver.findElement(By.cssSelector("img[alt=\"Pitney Bowes Logo\"]")).click();
    driver.findElement(By.linkText("SUPPORT")).click();
    driver.findElement(By.cssSelector("img")).click();
    driver.findElement(By.cssSelector("a.icn-search")).click();
    driver.findElement(By.cssSelector("a[title=\"Pitney Bowes logo\"]")).click();
    driver.findElement(By.xpath("//i")).click();
    driver.findElement(By.cssSelector("img[alt=\"Pitney Bowes Logo\"]")).click();
    
  }
  
  @Test
  public void TC3_testMenuIcon() throws Exception {
    
    // Validate Menu Functionality and displayed links
    
    driver.findElement(By.cssSelector("div.patty")).click();
    try {
      assertEquals("Customer Information Management", driver.findElement(By.linkText("Customer Information Management")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Location Intelligence", driver.findElement(By.linkText("Location Intelligence")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Customer Engagement", driver.findElement(By.linkText("Customer Engagement")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Shipping & Mailing", driver.findElement(By.linkText("Shipping & Mailing")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Global eCommerce", driver.findElement(By.linkText("Global eCommerce")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("Our Story", driver.findElement(By.linkText("Our Story")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.cssSelector("div.patty")).click();
    
  }
  
  @Test
  public void TC4_testBrandStoryCTA() throws Exception {
	  
	// Validate BrandStory CTA and capture navigated URL
    
    driver.findElement(By.linkText("SEE HOW")).click();
    driver.getCurrentUrl();
    System.out.println( driver.getCurrentUrl());
  }
  
  @Test
  public void TC5_testHomepageCategoryNavigation() throws Exception {
	  
	// Validate Categories CTA and capture navigated URL
    
    // Verify Customer Information Management Category Link
    
    driver.findElement(By.cssSelector("h2")).click();
    driver.getCurrentUrl();
    System.out.println( driver.getCurrentUrl());
    driver.findElement(By.cssSelector("a")).click();
    
    // Verify Location Intelligence Category Link
    
    driver.findElement(By.xpath("//div[@id='wrapper']/article/div/div/div[3]/a/h2")).click();
    driver.getCurrentUrl();
    System.out.println( driver.getCurrentUrl());
    driver.findElement(By.cssSelector("a")).click();
    
    // Verify Customer Engagement Category Link
    
    driver.findElement(By.xpath("//div[@id='wrapper']/article/div/div/div[4]/a/h2")).click();
    driver.getCurrentUrl();
    System.out.println( driver.getCurrentUrl());
    driver.findElement(By.cssSelector("a")).click();
    
    // Verify Shipping & Mailing Category Link
    
    driver.findElement(By.xpath("//div[@id='wrapper']/article/div/div/div[5]/a/h2")).click();
    driver.getCurrentUrl();
    System.out.println( driver.getCurrentUrl());
    driver.findElement(By.cssSelector("a")).click();
    
    // Verify Global eCommerce Category Link
    
    driver.findElement(By.xpath("//div[@id='wrapper']/article/div/div/div[6]/a/h2")).click();
    driver.getCurrentUrl();
    System.out.println( driver.getCurrentUrl());
    driver.findElement(By.cssSelector("a")).click();
      
  }


@AfterMethod
public void tearDown() throws Exception {
	
// Close Browser after Test Run
	
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


