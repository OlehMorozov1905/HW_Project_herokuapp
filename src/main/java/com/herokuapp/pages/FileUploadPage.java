package com.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class FileUploadPage extends BasePage{
    public FileUploadPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='file-upload']")
    WebElement uploadPicture;
    @FindBy(xpath = "//input[@id='file-submit']")
    WebElement uploadButton;
    public FileUploadPage fileUpload(String path) {
        uploadPicture.sendKeys(path);
        click(uploadButton);
        return this;
    }

    @FindBy(xpath = "//h3[contains(text(),'File Uploaded!')]")
    WebElement successTitle;
    public void verifySuccessTitle(String title) {
        Assert.assertTrue(shouldHaveText(successTitle, title, 10));
    }
}
