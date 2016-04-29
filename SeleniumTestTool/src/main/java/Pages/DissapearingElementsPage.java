package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by EugeneBerezan on 3/22/16.
 */
public class DissapearingElementsPage extends MainHomePage {

    private static final By DISAPPEARING_ELEMENTS_TEXT_LOCATOR = By.xpath("//h3[text()='Disappearing Elements']");
    private static final By HOME_BUTTON_LOCATOR = By.xpath("//a[text()='Home']");
    private static final By ABOUT_BUTTON_LOCATOR = By.xpath("//a[text()='About']");
    private static final By CONTACT_US_BUTTON_LOCATOR = By.xpath("//a[text()='Contact Us']");
    private static final By PORTFOLIO_BUTTON_LOCATOR = By.xpath("//a[text()='Portfolio']");
    private static final By GALLERY_BUTTON_LOCATOR = By.xpath("//a[text()='Gallery']");

    public String getDissaperingElementsText() {

        return driver.findElement(DISAPPEARING_ELEMENTS_TEXT_LOCATOR).getText();

    }

    public MainHomePage clickOnHomeButton(){

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(HOME_BUTTON_LOCATOR)).click();

        return new MainHomePage();
    }

    public AboutSubPage clickOnAboutButton(){

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(ABOUT_BUTTON_LOCATOR)).click();

        return new AboutSubPage();
    }

    public ContactUsPage clickOnContactUsButton(){

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(CONTACT_US_BUTTON_LOCATOR)).click();

        return new ContactUsPage();
    }


    public PortfolioPage clickOnPortfolioButton(){

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(PORTFOLIO_BUTTON_LOCATOR)).click();

        return new PortfolioPage();
    }

    public GalleryPage clickOnGalleryButton(){

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(GALLERY_BUTTON_LOCATOR)).click();

        return new GalleryPage();
    }

}
