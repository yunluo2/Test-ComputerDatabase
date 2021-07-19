package com.website.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.FindBy;

public class CreateView extends BasePage {
    public CreateView(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "name")
    private WebElement nameTextBox;
    public void inputToNameTextBox(String text) {
        nameTextBox.sendKeys(text);
    }

    @FindBy(id = "introduced")
    private WebElement introducedTextBox;
    public void inputToIntroducedTextBox(String text) {
        introducedTextBox.sendKeys(text);
    }

    @FindBy(id = "discontinued")
    private WebElement discontinuedTextBox;
    public void inputToDiscontinuedTextBox(String text) {
        discontinuedTextBox.sendKeys(text);
    }

    @FindBy(id = "company")
    private WebElement companyDropDownList;
    public void chooseCompanyDropDownList(String text) {
        Select companySelect = new Select(companyDropDownList);
        companySelect.selectByVisibleText(text);
    }

    @FindBy(css = "input.btn.primary[value=\"Create this computer\"]")
    private WebElement createButton;
    public void clickCreateButton() {
        createButton.click();
    }

    @FindBy(css = "a.btn[Value=\"Cancel\"]")
    private WebElement cancelButton;
    public void clickCancelButton() {
        cancelButton.click();
    }
}
