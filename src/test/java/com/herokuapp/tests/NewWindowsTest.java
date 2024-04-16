package com.herokuapp.tests;

import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.BrowserWindowsPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewWindowsTest extends TestBase{
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getMultipleWindowsPage();
    }
    @Test
    public void openNewWindowsTest() {
        new BrowserWindowsPage(driver).switchToNextWindow(1).verifyNewPageMessage("New Window");
    }
    @AfterMethod
    public void postcondition() {
        driver.close();
    }
}
