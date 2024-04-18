package com.herokuapp.tests;

import com.herokuapp.pages.BrokenImagesPage;
import com.herokuapp.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenImagesTest extends TestBase{
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getBrokenImagesPage();
    }
    @Test
    public void checkBrokenImages() {
        new BrokenImagesPage(driver).checkBrokenImages();
    }
}
