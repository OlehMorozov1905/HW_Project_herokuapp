package com.herokuapp.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AlertsPage extends BasePage{
    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@onclick='jsAlert()']")
    WebElement alertSimpleButton;
    public AlertsPage alertSimple() {
        click(alertSimpleButton);

        driver.switchTo().alert().accept();

        return this;
    }

    @FindBy(xpath = "//p[text()='You successfully clicked an alert']")
    WebElement alertSimpleResult;
    public AlertsPage verifyResultAlertSimple() {
        Assert.assertTrue(alertSimpleResult.isDisplayed());
        return this;
    }

    @FindBy(xpath = "//button[@onclick='jsConfirm()']")
    WebElement alertConfirmButton;
    public AlertsPage selectResult(String confirm) {
        click(alertConfirmButton);

        if (confirm != null && confirm.equals("OK")) {
            driver.switchTo().alert().accept();
        } else if (confirm != null && confirm.equals("Cancel")) {
            driver.switchTo().alert().dismiss();
        }
        return this;
    }
    @FindBy(xpath = "//p[contains(text(), 'You clicked')]")
    WebElement alertConfirmResult;
    public AlertsPage verifyResult(String text) {
        Assert.assertTrue(alertConfirmResult.getText().contains(text));
        return this;
    }

    @FindBy(xpath = "//button[@onclick='jsPrompt()']")
    WebElement alertPromptButton;
    public AlertsPage alertSendMessageToAlert(String message) {
        click(alertPromptButton);

        if (message != null) {
            driver.switchTo().alert().sendKeys(message);
            driver.switchTo().alert().accept();
        }
        return this;
    }

    @FindBy(xpath = "//p[contains(text(), 'You entered')]")
    WebElement alertPromptResult;
    public AlertsPage verifyMessage(String text) {
        Assert.assertTrue(alertPromptResult.getText().contains(text));
        return this;
    }


}
