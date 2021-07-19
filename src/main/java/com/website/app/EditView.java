package com.website.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Collection of web elements on edit view page
 */
public class EditView extends BasePage {
    public EditView(WebDriver driver) {
        super(driver);
    }

    /**
     * Text box for computer name
     */
    @FindBy(id = "name")
    private WebElement nameTextBox;
    public void inputToNameTextBox(String text) {
        nameTextBox.sendKeys(text);
    }
    public void clearNameTextBox() {
        nameTextBox.clear();
    }

    /**
     * Delete this computer button
     */
    @FindBy(css = "input.btn.danger[value=\"Delete this computer\"]")
    private WebElement deleteButton;
    public void clickDeleteButton() {
        deleteButton.click();
    }

    /**
     * Save this computer button
     */
    @FindBy(css = "input.btn.primary[value=\"Save this computer\"]")
    private WebElement saveButton;
    public void clickSaveButton() {
        saveButton.click();
    }
}
