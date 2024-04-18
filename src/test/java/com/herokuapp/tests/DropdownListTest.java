package com.herokuapp.tests;

import com.herokuapp.pages.DropdownListPage;
import com.herokuapp.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropdownListTest extends TestBase{
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getDropdownListPage();
    }
    @Test
    public void selectOptionOne() {
        new DropdownListPage(driver).selectOptionOne("Option 1")
                .verifyIsOptionOneSelected("Option 1");
    }
}
