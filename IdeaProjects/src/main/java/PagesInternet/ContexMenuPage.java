package PagesInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by EugeneBerezan on 3/22/16.
 */
public class ContexMenuPage extends MainHomePage {

    private static final By CONTEXT_MENU_AREA_LOCATOR = By.xpath("//*[@id='hot-spot']");
    private static final By CONTEXT_MENU_TEXT_LOCATOR = By.xpath("//*[text()='Context Menu']");

    public String getAssertText(){
        return driver.findElement(CONTEXT_MENU_TEXT_LOCATOR).getText();
    }

    public String contexClickOnArea() {
        log.info("Requesting right click menu on Area");

        WebElement contexElement = driver.findElement(CONTEXT_MENU_AREA_LOCATOR);
        contextMenuClick(contexElement);
        Actions action = new Actions(driver);
        action.contextClick(contexElement).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();

        return getAlertText();
    }

}
