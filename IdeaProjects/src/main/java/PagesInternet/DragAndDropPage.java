package PagesInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.event.InputEvent;
import java.io.FileNotFoundException;

/**
 * Created by EugeneBerezan on 3/22/16.
 */
public class DragAndDropPage extends MainHomePage {

    private static final By DRAG_AND_DROP_TEXT_LOCATOR = By.xpath("//h3[text()='Drag and Drop']");
    private static final By DRAG_AND_DROP_FROM_LOCATION_LOCATOR = By.xpath("//*[@id='column-a']");
    private static final By DRAG_AND_DROP_TO_LOCATION_LOCATOR = By.xpath("//*[@id='column-b']");
    private static final By COLUMN_A_HEADER_VALUE_LOCATOR = By.xpath("//div[@id='column-a']/header");
    private static final By COLUMN_B_HEADER_VALUE_LOCATOR = By.xpath("//div[@id='column-b']/header");

    public String getAssertText() {
        log.info("Getting assert text");
        return driver.findElement(DRAG_AND_DROP_TEXT_LOCATOR).getText();
    }

    public String getColumnAValue() {
        return driver.findElement(COLUMN_A_HEADER_VALUE_LOCATOR).getText();
    }

    public String getColumnBValue() {
        return driver.findElement(COLUMN_B_HEADER_VALUE_LOCATOR).getText();
    }

    public DragAndDropPage dragAndDrop() throws InterruptedException, AWTException, FileNotFoundException {
        log.info("Drag and Drop on A and B elements");
        WebElement from = driver.findElement(DRAG_AND_DROP_FROM_LOCATION_LOCATOR);
        WebElement to = driver.findElement(DRAG_AND_DROP_TO_LOCATION_LOCATOR);
        int sourceX = from.getLocation().getX()+ 10;
        int sourceY = from.getLocation().getY() + from.getLocation().getY() + 30;
        int targetX = to.getLocation().getX();
        int targetY = to.getLocation().getY() + to.getLocation().getY() + 30;

        Robot robot = new Robot();
        robot.delay(100);
        robot.mouseMove(sourceX, sourceY);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        for (int i = 0; i <= targetX + 10; i += 10) {
            robot.mouseMove(sourceX + i, sourceY);
            Thread.sleep(100);
        }
        robot.mouseMove(targetX, targetY);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);

        return new DragAndDropPage();
    }

}
