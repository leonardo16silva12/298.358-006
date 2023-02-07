package tests;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import junit.framework.Assert;

@Epic("Test Automatizado")
@Feature("Test Automatizado")
public class AppTest {
	
	  private AndroidDriver<MobileElement> driver;


  @Before
  public void setUp() throws MalformedURLException {
    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    desiredCapabilities.setCapability("platformName", "Android");
    desiredCapabilities.setCapability("appium:platformVersion", "10.0");
    desiredCapabilities.setCapability("appium:automationName", "UIAutomator2");
    desiredCapabilities.setCapability("appium:appPackage", "com.google.android.calculator");
    desiredCapabilities.setCapability("appium:appActivity", "com.android.calculator2.Calculator");

    URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

    driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
  }
  
  @After
  public void tearDown() {
    driver.quit();
  }
  

  @SuppressWarnings("deprecation")
@Test
  @Story("TesteProjetoAutomacaoMobile")
  public void testeGeral() throws InterruptedException, AWTException {
    MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("2");
    el1.click();
    MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("plus");
    el2.click();
    MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("5");
    el3.click();
    MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("equals");
    el4.click();
    
    MobileElement el5 = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_final");
    Assert.assertEquals("7", el5.getText());

  }


}
