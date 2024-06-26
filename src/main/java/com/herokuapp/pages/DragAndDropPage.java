package com.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DragAndDropPage extends BasePage{
    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="column-a")
    WebElement dragMe;
    @FindBy(id="column-b")
    WebElement dropHere;
    public DragAndDropPage actionDragMe() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragMe, dropHere).perform();

        String text = dropHere.getText();
        if (text.equals("Dropped!")) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        return this;
    }

    public DragAndDropPage actionDragMeBy() {
        Actions actions = new Actions(driver);
        int xOffset1 = dragMe.getLocation().getX();
        int yOffset1 = dragMe.getLocation().getY();
        System.out.println("xOffset1 --> " + xOffset1 + " yOffset1 --> " + yOffset1);

        int xOffset = dropHere.getLocation().getX();
        int yOffset = dropHere.getLocation().getY();
        System.out.println("xOffset --> " + xOffset + " yOffset --> " + yOffset);

        xOffset = (xOffset - xOffset1);
        yOffset = (yOffset - yOffset1);
        actions.dragAndDropBy(dragMe, xOffset, yOffset).perform();

        String text = dropHere.getText();
        if (text.equals("Dropped!")) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        return this;
    }

    public DragAndDropPage verifyNewLetterInColumnB(String letter) {
        Assert.assertTrue(shouldHaveText(dropHere, letter, 1));
        return this;
    }

    public DragAndDropPage verifyNewLetterInColumnA(String letter) {
        Assert.assertTrue(shouldHaveText(dragMe, letter, 1));
        return this;
    }
}