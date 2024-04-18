package com.herokuapp.tests;

import com.herokuapp.pages.DragAndDropPage;
import com.herokuapp.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragAndDropTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getDragAndDropPage();
    }
    @Test
    public void actionDragMeTest() {
        new DragAndDropPage(driver).actionDragMe().verifyNewLetterInColumnA("B");
    }
    @Test
    public void actionDragMeByTest() {
        new DragAndDropPage(driver).actionDragMeBy().verifyNewLetterInColumnB("A");
    }
}
