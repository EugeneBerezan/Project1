package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by EugeneBerezan on 3/22/16.
 */
public class CheckboxesPage extends MainHomePage {

    private static final By CHECKBOXES_TEXT_LOCATOR = By.xpath("//h3[text()='Checkboxes']");
    private static final By CHECKBOX_1_LOCATOR = By.xpath("//form[@id='checkboxes']/input[1]");
    private static final By CHECKBOX_2_LOCATOR = By.xpath("//form[@id='checkboxes']/input[2]");
    private static final By CHECKBOXES_LOCATOR = By.xpath("//form[@id='checkboxes']/input");

    public CheckboxesPage selectCheckbox1() {

        try {
            if (!(driver.findElement(CHECKBOX_1_LOCATOR).getAttribute("checked") == null)) {

                driver.findElement(CHECKBOX_1_LOCATOR).click();
            } else

                return this;
        } catch (NullPointerException e) {
            e.getMessage();
        }
        return this;
    }

    public CheckboxesPage selectCheckbox2() {

        try {
            if (!(driver.findElement(CHECKBOX_2_LOCATOR).getAttribute("checked") == null)) {

                driver.findElement(CHECKBOX_2_LOCATOR).click();
            } else

                return this;
        } catch (NullPointerException e) {
            e.getMessage();
        }
        return this;
    }

    public CheckboxesPage selectAllCheckboxes() {

        try {
            List<WebElement> checkboxes = driver.findElements(CHECKBOXES_LOCATOR);
            for (WebElement checkboxe : checkboxes) {
                if (!(checkboxe.getAttribute("checked") == null)) {
                    checkboxe.click();
                }
            }
            return new CheckboxesPage();

        } catch (NullPointerException e) {
            e.getMessage();
        }
        return new CheckboxesPage();
    }

    public String getCheckboxText() {

        return driver.findElement(CHECKBOXES_TEXT_LOCATOR).getText();

    }
}
