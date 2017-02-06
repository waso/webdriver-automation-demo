package com.wsojka.demo.pages;

import com.wsojka.demo.Page;
import com.wsojka.demo.PageBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * @author Waldemar Sojka
 */
public class SearchResultsPage extends PageBase implements Page {

    private Logger log = Logger.getLogger(SearchResultsPage.class);

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void waitForPage() {

    }
}
