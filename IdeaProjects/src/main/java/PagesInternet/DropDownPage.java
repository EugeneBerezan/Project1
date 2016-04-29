package PagesInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by EugeneBerezan on 3/22/16.
 */
public class DropDownPage extends MainHomePage {

    private static final By DROP_DOWN_TEXT_LOCATOR = By.xpath("//h3[text()='Dropdown List']");
    private static final By SELECT_LOCATOR = By.xpath("//select[@id='dropdown']");

    public String getAssertText(){
        return driver.findElement(DROP_DOWN_TEXT_LOCATOR).getText();
    }

    public DropDownPage selectOption1() {
        log.info("Selecting Option 1 from dropdown");

        selectFromDropDown(driver.findElement(SELECT_LOCATOR), "Option 1");

        return this;
    }

    public DropDownPage selectOption2() {
        log.info("Selecting Option 2 from dropdown");

        selectFromDropDown(driver.findElement(SELECT_LOCATOR), "Option 2");

        return this;
    }

    public boolean isOption1Selected() {
        Select select = new Select(driver.findElement(SELECT_LOCATOR));
        WebElement selectedOption = select.getFirstSelectedOption();
        String option1 = selectedOption.getText();
        if (option1.equals("Option 1")) {
            return true;
        } else return false;
    }

    public boolean isOption2Selected() {
        Select select = new Select(driver.findElement(SELECT_LOCATOR));
        WebElement selectedOption = select.getFirstSelectedOption();
        String option1 = selectedOption.getText();
        if (option1.equals("Option 2")) {
            return true;
        } else return false;
    }

}
