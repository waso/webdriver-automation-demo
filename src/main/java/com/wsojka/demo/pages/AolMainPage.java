package com.wsojka.demo.pages;

import com.wsojka.demo.Page;
import com.wsojka.demo.PageBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;

/**
 * @author Waldemar Sojka
 */
public class AolMainPage extends PageBase implements Page {

    private Logger log = Logger.getLogger(AolMainPage.class);

    @FindBy(xpath = "//img[@alt = 'Click here to refresh']")
    private WebElement logo;

    @FindBy(linkText = "News")
    private WebElement newsLink;

    @FindBy(xpath = "//a[@id = 'ghnav-sports' and (. = 'Sports')]")
    private WebElement sportsLink;

    @FindBy(xpath = "//a[@id = 'ghnav-entertainment' and (. = 'Entertainment')]")
    private WebElement entertainmentLink;

    @FindBy(id = "aol-header-query")
    private WebElement searchInput;

    @FindBy(id = "aol-header-search-button")
    private WebElement searchButton;

    public AolMainPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyMenuLinksAvailable() {
        boolean found = true;
        for (WebElement link : Arrays.asList(newsLink, sportsLink, entertainmentLink)) {
            try {
                log.info("Checking if link exists");
                wait.until(ExpectedConditions.visibilityOf(link));
            } catch (NoSuchElementException e) {
                found = false;
            }
        }
        return found;
    }

    public void setSearchText(String text) {
        searchInput.sendKeys(text);
    }

    public void waitForPage() {
        log.info("Opening AolMainPage");
        wait.until(ExpectedConditions.visibilityOf(logo));
    }
}
