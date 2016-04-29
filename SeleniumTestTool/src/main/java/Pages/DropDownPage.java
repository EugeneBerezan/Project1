package Pages;

import org.openqa.selenium.By;

/**
 * Created by EugeneBerezan on 3/22/16.
 */
public class DropDownPage extends MainHomePage {

    private static final By DROP_DOWN_TEXT_LOCATOR = By.xpath("//h3[text()='Dropdown List']");
    private static final By SELECT_LOCATOR = By.xpath("//select[@id='dropdown']");

    public DropDownPage selectValue(String option) {

        selectFromDropDown(driver.findElement(SELECT_LOCATOR), option);

        return this;
    }

}
