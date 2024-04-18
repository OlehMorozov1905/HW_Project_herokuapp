package com.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='JavaScript Alerts']")
    WebElement alerts;

    public AlertsPage getAlertsPage() {
        click(alerts);
        return new AlertsPage(driver);
    }


    @FindBy(xpath = "//a[contains(text(),'Checkboxes')]")
    WebElement checkboxesPage;

    public CheckboxesPage getCheckboxesPage() {
        click(checkboxesPage);
        return new CheckboxesPage(driver);
    }

    @FindBy(css = "a[href='/dropdown']")
    WebElement dropdownListPage;

    public DropdownListPage getDropdownListPage() {
        click(dropdownListPage);
        return new DropdownListPage(driver);
    }

    @FindBy(css = "a[href='/upload']")
    WebElement fileUploadPage;

    public FileUploadPage getFileUploadPage() {
        click(fileUploadPage);
        return new FileUploadPage(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'Broken Images')]")
    WebElement brokenImagesPage;

    public BrokenImagesPage getBrokenImagesPage() {
        click(brokenImagesPage);
        return new BrokenImagesPage(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'Drag and Drop')]")
    WebElement dragAndDropPage;

    public DragAndDropPage getDragAndDropPage() {
        click(dragAndDropPage);
        return new DragAndDropPage(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'Multiple Windows')]")
    WebElement windowsPage;

    public BrowserWindowPage getMultipleWindowsPage() {
        click(windowsPage);
        return new BrowserWindowPage(driver);
    }
}
