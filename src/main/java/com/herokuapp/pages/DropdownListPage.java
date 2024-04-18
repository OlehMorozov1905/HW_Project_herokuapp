package com.herokuapp.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class DropdownListPage extends BasePage{
    public DropdownListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//select[@id='dropdown']")
    WebElement optionsInput;
    public DropdownListPage selectOptionOne(String option) {
        Select select = new Select(optionsInput);
        select.selectByVisibleText(option);
        List<WebElement> options = select.getOptions();
        System.out.println(select.getFirstSelectedOption().getText() + " is first");
        System.out.println("======================================================");
        for (int i = 0; i < options.size(); i++) {
            System.out.println(options.get(i).getText());
        }
//        ============================================
//        click(optionsInput);
//        optionsInput.sendKeys(option);
//        optionsInput.sendKeys(Keys.ENTER);
//        ===============================================
        return this;
    }
    @FindBy(xpath = "//select[@id='dropdown']/option[text()='Option 1']")
    WebElement optionOneElement;
    public void verifyIsOptionOneSelected(String result) {
        Assert.assertTrue(shouldHaveText(optionOneElement, result, 1));
    }
}