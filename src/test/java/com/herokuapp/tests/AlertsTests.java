package com.herokuapp.tests;

import com.herokuapp.pages.AlertsPage;
import com.herokuapp.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getAlertsPage();
    }
    @Test
    public void alertSimpleTest() {
        new AlertsPage(driver).alertSimple().verifyResultAlertSimple();
    }
    @Test
    public void alertConfirmSelectTest() {
        new AlertsPage(driver).selectResult("Cancel").verifyResult("Cancel");
    }
    @Test
    public void alertSendMessageToAlertTest() {
        new AlertsPage(driver).alertSendMessageToAlert("Vincent Vega").verifyMessage("Vincent Vega");
    }
}
