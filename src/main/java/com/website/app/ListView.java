package com.website.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ListView extends BasePage {
    public ListView(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "searchbox")
    private WebElement filterTextBox;
    public void inputToFilterTextBox(String text) {
        filterTextBox.sendKeys(text);
    }

    @FindBy(id = "searchsubmit")
    private WebElement filterButton;
    public void clickFilterButton() {
        filterButton.click();
    }

    @FindBy(id="add")
    @CacheLookup
    private WebElement addButton;
    public void clickAddButton() {
        addButton.click();
    }

    @FindBy(css = "#main > h1")
    private WebElement h1;
    public boolean noElementFound() {
        String h1Text = h1.getText();
        System.out.println("h1Text is " + h1Text);
        return h1Text.equals("No computers found");
    }
}
