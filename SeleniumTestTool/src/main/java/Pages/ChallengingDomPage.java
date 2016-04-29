package Pages;

import org.openqa.selenium.By;

/**
 * Created by EugeneBerezan on 3/22/16.
 */
public class ChallengingDomPage extends MainHomePage {

    private static final By BAR_BUTTON_LOCATOR = By.xpath("//a[contains(@class, 'button') and text()='bar']");
    private static final By BAZ_BUTTON_LOCATOR = By.xpath("//a[contains(@class, 'button') and text()='baz']");
    private static final By QUX_BUTTON_LOCATOR = By.xpath("//a[contains(@class, 'button') and text()='qux']");

    public ChallengingDomPage clickOnBarButton(){

        driver.findElement(BAR_BUTTON_LOCATOR).click();

        return new ChallengingDomPage();

    }

    public ChallengingDomPage clickOnBazButton(){

        driver.findElement(BAZ_BUTTON_LOCATOR).click();

        return new ChallengingDomPage();

    }

    public ChallengingDomPage clickOnQuxButton(){

        driver.findElement(QUX_BUTTON_LOCATOR).click();

        return new ChallengingDomPage();

    }

}
