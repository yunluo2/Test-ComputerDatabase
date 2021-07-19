package com.website.app.testing;


import com.website.app.CreateView;
import com.website.app.EditView;
import com.website.app.ListView;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * UI end to end test
 */
public class UIEndToEndTest {
    private WebDriver driver;
    private ListView listView;
    private CreateView createView;
    private EditView editView;

    /**
     * Helper function to pause for 1 second. Mainly for demo purpose.
     * Comment out line 32 if pause is not desired.
     * @throws InterruptedException for Thread.sleep
     */
    private void pause() throws InterruptedException {
        Thread.sleep(1000);
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1024, 768));
        listView = new ListView(driver);
        createView = new CreateView(driver);
        editView = new EditView(driver);

        driver.get("http://computer-database.herokuapp.com/computers");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    /**
     * End to end test to create a new item, update it and delete it
     * @throws InterruptedException for Thread.sleep
     */
    @Test
    public void testCRUD() throws InterruptedException {
        String computerName = "******mycomp1";
        String updatedName = "******mycomp11111";

        //Create a new item
        listView.clickAddButton();
        pause();
        createView.inputToNameTextBox(computerName);
        createView.inputToIntroducedTextBox("1999-09-09");
        createView.inputToDiscontinuedTextBox("2009-09-09");
        createView.chooseCompanyDropDownList("IBM");
        createView.clickCreateButton();

        //Verify the new item has been created by filtering on it
        listView.inputToFilterTextBox(computerName);
        listView.clickFilterButton();
        pause();

        //Click the item link, go to edit view, then update the item
        WebElement nameLink = driver.findElement(By.linkText(computerName));
        nameLink.click();
        pause();
        editView.clearNameTextBox();
        editView.inputToNameTextBox(updatedName);
        pause();
        editView.clickSaveButton();

        //Use filter to find the updated item then delete it
        listView.inputToFilterTextBox(updatedName);
        listView.clickFilterButton();
        pause();
        WebElement updatedLink = driver.findElement(By.linkText(updatedName));
        updatedLink.click();
        editView.clickDeleteButton();
        pause();

        //verify item has been deleted
        listView.inputToFilterTextBox(updatedName);
        listView.clickFilterButton();
        Assert.assertTrue(listView.noElementFound());
    }
}