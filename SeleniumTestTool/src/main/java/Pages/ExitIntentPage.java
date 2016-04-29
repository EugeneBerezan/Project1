package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

/**
 * Created by EugeneBerezan on 3/24/16.
 */
public class ExitIntentPage extends MainHomePage {

    private static final By EXIT_INTENT_TEXT_LOCATOR = By.xpath("//*[text()='Exit Intent']");
    private static final By FLASH_MESSAGE_AREA_LOCATOR = By.xpath("//div[@id='flash-messages']");
    private static final By MODAL_WINDOW_ASSERT_LOCATOR = By.xpath("//div[@id='ouibounce-modal']");
    private static final By MODAL_WINDOW_CLOSE_BUTTON_LOCATOR = By.xpath("//div[@class='modal']//*[text()='Close']");

    public String getExitIntentText() {

        return driver.findElement(EXIT_INTENT_TEXT_LOCATOR).getText();

    }

    public ExitIntentPage mouserOverToFlashMessage() {

        mouserOverOnElement(FLASH_MESSAGE_AREA_LOCATOR);

        return new ExitIntentPage();
    }

    public boolean checkIfModalWindowIsPresent() {

        for (int i = 0; i < 5; i++) {
            try {
                String style = driver.findElement(MODAL_WINDOW_ASSERT_LOCATOR).getAttribute("style");
                {
                    if (!style.contains("none")) {
                        return true;
                    }
                }

            } catch (NoSuchElementException | NullPointerException e) {
                e.getMessage();
            }
        }
        return false;

    }

    public ExitIntentPage closeModalWindow() {

        driver.findElement(MODAL_WINDOW_CLOSE_BUTTON_LOCATOR).click();

        return new ExitIntentPage();

    }

}
