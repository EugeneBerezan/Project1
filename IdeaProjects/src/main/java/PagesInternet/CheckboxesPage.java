package PagesInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EugeneBerezan on 3/22/16.
 */
public class CheckboxesPage extends MainHomePage {

    private static final By CHECKBOXES_TEXT_LOCATOR = By.xpath("//h3[text()='Checkboxes']");
    private static final By CHECKBOX_1_LOCATOR = By.xpath("//form[@id='checkboxes']/input[1]");
    private static final By CHECKBOX_2_LOCATOR = By.xpath("//form[@id='checkboxes']/input[2]");
    private static final By CHECKBOXES_LOCATOR = By.xpath("//input[@type='checkbox']");


    public CheckboxesPage selectCheckbox1() {
        log.info("Selecting checkbox 1");

        for (int i = 0; i < 4; i++) {
            if (!driver.findElement(CHECKBOX_1_LOCATOR).isSelected()) {
                driver.findElement(CHECKBOX_1_LOCATOR).click();
            }
        }
        return this;
    }

    public CheckboxesPage selectCheckbox2() {
        log.info("Selecting checkbox 2");

        for (int i = 0; i < 4; i++) {
            if (!driver.findElement(CHECKBOX_2_LOCATOR).isSelected()) {
                driver.findElement(CHECKBOX_2_LOCATOR).click();
            }
        }
        return this;
    }

    public CheckboxesPage deselectCheckbox1() {
        log.info("Deselecting checkbox 1");

        for (int i = 0; i < 4; i++) {
            if (driver.findElement(CHECKBOX_1_LOCATOR).isSelected()) {
                driver.findElement(CHECKBOX_1_LOCATOR).click();
            }
        }
        return this;
    }

    public CheckboxesPage deselectCheckbox2() {
        log.info("Deselecting checkbox 2");

        for (int i = 0; i < 4; i++) {
            if (driver.findElement(CHECKBOX_2_LOCATOR).isSelected()) {
                driver.findElement(CHECKBOX_2_LOCATOR).click();
            }
        }
        return this;
    }

    public CheckboxesPage selectAllCheckboxes() {
        log.info("Selecting all checkboxes");

        try {
            List<WebElement> checkboxes = driver.findElements(CHECKBOXES_LOCATOR);
            for (WebElement checkboxe : checkboxes) {
                if (!checkboxe.isSelected()) {
                    checkboxe.click();
                }
            }
            return new CheckboxesPage();

        } catch (NullPointerException e) {
            e.getMessage();
        }
        return new CheckboxesPage();
    }

    public CheckboxesPage deSelectAllCheckboxes() {
        log.info("Selecting all checkboxes");

        try {
            List<WebElement> checkboxes = driver.findElements(CHECKBOXES_LOCATOR);
            for (WebElement checkboxe : checkboxes) {
                if (checkboxe.isSelected()) {
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
        log.info("Getting assert text");

        return driver.findElement(CHECKBOXES_TEXT_LOCATOR).getText();

    }

    public boolean isCheckbox1Selected() {
        return driver.findElement(CHECKBOX_1_LOCATOR).isSelected();
    }

    public boolean isCheckbox2Selected() {
        return driver.findElement(CHECKBOX_2_LOCATOR).isSelected();
    }

    public boolean areAllCheckboxesSelected() {
        List<WebElement> list = driver.findElements(CHECKBOXES_LOCATOR);
        for (WebElement checkbox : list) {
            if (checkbox.isSelected()) {
                return true;
            } else return false;

        }
        return false;
    }

    public int howManyCheckboxesSelected() {
        int enabledCheckboxesCount = 0;
        List<WebElement> list = driver.findElements(CHECKBOXES_LOCATOR);
        for (WebElement checkbox : list) {
            if (checkbox.isSelected()) {
                enabledCheckboxesCount++;
            }
        }
        return enabledCheckboxesCount;
    }

}
