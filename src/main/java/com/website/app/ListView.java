package com.website.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Collection of web elements on list view page
 */
public class ListView extends BasePage {
    public ListView(WebDriver driver) {
        super(driver);
    }

    /**
     * Text box for filter
     */
    @FindBy(id = "searchbox")
    private WebElement filterTextBox;
    public void inputToFilterTextBox(String text) {
        filterTextBox.sendKeys(text);
    }

    /**
     * Filter button
     */
    @FindBy(id = "searchsubmit")
    private WebElement filterButton;
    public void clickFilterButton() {
        filterButton.click();
    }

    /**
     * Add a new computer button
     */
    @FindBy(id="add")
    @CacheLookup
    private WebElement addButton;
    public void clickAddButton() {
        addButton.click();
    }

    /**
     * Text to display how many computers are found.
     * When there is no computer found, "No computers found" will be displayed.
     */
    @FindBy(css = "#main > h1")
    private WebElement h1;

    /**
     * Find out if No computers found
     * @return true when no computers found, false otherwise.
     */
    public boolean noElementFound() {
        String h1Text = h1.getText();
        System.out.println("h1Text is " + h1Text);
        return h1Text.equals("No computers found");
    }
}
