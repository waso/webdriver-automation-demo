package com.wsojka.demo;

import com.wsojka.demo.pages.AolMainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Waldemar Sojka
 */
public class SimpleTest extends BaseTest {

    @Test
    public void test() {
        AolMainPage mainPage = PageFactory.load(AolMainPage.class, driver, AOL_URL);
        Assert.assertTrue(mainPage.verifyMenuLinksAvailable());
    }
}
