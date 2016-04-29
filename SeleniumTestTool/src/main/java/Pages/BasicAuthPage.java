package Pages;

import org.openqa.selenium.By;

/**
 * Created by EugeneBerezan on 3/22/16.
 */
public class BasicAuthPage extends MainHomePage {

    private static final By BASIC_AUTH_TEXT_LOCATOR = By.xpath("//h3[text()='Basic Auth']");

    public String getBasicText(){

       return driver.findElement(BASIC_AUTH_TEXT_LOCATOR).getText();

    }

}
