package com.website.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * Base class of all the web pages.
 */
abstract public class BasePage {
    /**
     * Constructor of BasePage
     * @param driver Web driver
     */
    BasePage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }
}
