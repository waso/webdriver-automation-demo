package com.wsojka.demo;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * @author Waldemar Sojka
 */
public class BaseTest {
    protected Logger log = Logger.getLogger(BaseTest.class);

    protected static final String AOL_URL = "http://www.aol.com/";

    public WebDriver driver = null;

    @BeforeMethod
    public void setUp() throws Exception {
        if (System.getProperty("webdriver.chrome.driver") == null) {
            System.setProperty("webdriver.chrome.driver", "/home/waldek/chromedriver/chromedriver");
        }

        log.info("Starting WebDriver test");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://www.google.com");
    }

    @AfterMethod
    public void tearDown() {
        log.info("Stopping WebDriver test");
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            driver.close();
        }
    }
}
