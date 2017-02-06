package com.wsojka.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Waldemar Sojka
 */
public abstract class PageBase {

    protected final WebDriver driver;

    protected final int TIMEOUT = 10;

    protected final WebDriverWait wait;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, TIMEOUT);
    }

    public void sleep(int ms) {
        try {
            Thread.sleep(ms);
        }
        catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
