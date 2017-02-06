package com.wsojka.demo;

import org.openqa.selenium.WebDriver;

/**
 * @author Waldemar Sojka
 */
public class PageFactory {
    private PageFactory() {
    }

    public static <T extends Page> T load(Class<T> claz, WebDriver driver) {
        T page = org.openqa.selenium.support.PageFactory.initElements(driver, claz);
        page.waitForPage();
        return page;
    }

    public static <T extends Page> T load(Class<T> claz, WebDriver driver, String url) {
        driver.get(url);
        T page = org.openqa.selenium.support.PageFactory.initElements(driver, claz);
        page.waitForPage();
        return page;
    }

}