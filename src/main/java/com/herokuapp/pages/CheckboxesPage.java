package com.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CheckboxesPage extends BasePage{
    public CheckboxesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#checkboxes :nth-child(1)")
    WebElement firstCheckbox;
    @FindBy(css = "#checkboxes :nth-child(3)")
    WebElement secondCheckbox;
    public CheckboxesPage changeCheckboxes(String[] checkboxes) {
        for (int i = 0; i < checkboxes.length; i++) {
            if (checkboxes[i].equals(" checkbox 1")) {
                click(firstCheckbox);
            }
            if (checkboxes[i].equals(" checkbox 2 ")) {
                click(secondCheckbox);
            }

        }
        return this;
    }
    public void checkingCheckboxChanges() {
        CheckboxesPage checkboxesPage = new CheckboxesPage(driver);
        Assert.assertTrue(checkboxesPage.firstCheckbox.isSelected(), "Checkbox 1 should be selected");
        Assert.assertFalse(checkboxesPage.secondCheckbox.isSelected(), "Checkbox 2 should not be selected");
    }
}
