package com.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class BrowserWindowsPage extends BasePage{
    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'Click Here')]")
    WebElement clickHereButton;
    public BrowserWindowsPage switchToNextWindow(int index) {
        click(clickHereButton);

        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(index));
        return this;
    }

    @FindBy(xpath = "//h3[text()='New Window']")
    WebElement newWindow;
    public BasePage verifyNewPageMessage(String text) {
        Assert.assertTrue(shouldHaveText(newWindow, text, 10));
        return this;
    }
}
