package com.website.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditView extends BasePage {
    public EditView(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "name")
    private WebElement nameTextBox;
    public void inputToNameTextBox(String text) {
        nameTextBox.sendKeys(text);
    }
    public void clearNameTextBox() {
        nameTextBox.clear();
    }

    @FindBy(css = "input.btn.danger[value=\"Delete this computer\"]")
    private WebElement deleteButton;
    public void clickDeleteButton() {
        deleteButton.click();
    }

    @FindBy(css = "input.btn.primary[value=\"Save this computer\"]")
    private WebElement saveButton;
    public void clickSaveButton() {
        saveButton.click();
    }
}
