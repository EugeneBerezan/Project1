package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by EugeneBerezan on 3/22/16.
 */
public class DragAndDropPage extends MainHomePage {

    private static final By DRAG_AND_DROP_TEXT_LOCATOR = By.xpath("//h3[text()='Drag and Drop']");
    private static final By DRAG_AND_DROP_FROM_LOCATION_LOCATOR = By.xpath("//*[@id='column-a']");
    private static final By DRAG_AND_DROP_TO_LOCATION_LOCATOR = By.xpath("//*[@id='column-b']");

    public String getText(){

        return driver.findElement(DRAG_AND_DROP_TEXT_LOCATOR).getText();
    }

    public DragAndDropPage dragAndDrop(){

        WebElement from = driver.findElement(DRAG_AND_DROP_FROM_LOCATION_LOCATOR);
        WebElement to = driver.findElement(DRAG_AND_DROP_TO_LOCATION_LOCATOR);

        dragAndDrop(from, to);

        return new DragAndDropPage();
    }

}
