package PagesInternet;

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
        log.info("Getting assert text");

        return driver.findElement(DISAPPEARING_ELEMENTS_TEXT_LOCATOR).getText();

    }

    public MainHomePage clickOnHomeButton(){
        log.info("Clicking on Home button");
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(HOME_BUTTON_LOCATOR)).click();

        return new MainHomePage();
    }

    public AboutSubPage clickOnAboutButton(){
        log.info("Clicking on About");
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(ABOUT_BUTTON_LOCATOR)).click();

        return new AboutSubPage();
    }

    public ContactUsPage clickOnContactUsButton(){
        log.info("Clicking on Contact Us");
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(CONTACT_US_BUTTON_LOCATOR)).click();

        return new ContactUsPage();
    }


    public PortfolioPage clickOnPortfolioButton(){
        log.info("Clicking on Portfolio");
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(PORTFOLIO_BUTTON_LOCATOR)).click();

        return new PortfolioPage();
    }

    public GalleryPage clickOnGalleryButton(){
        log.info("Clicking on Gallery");
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(GALLERY_BUTTON_LOCATOR)).click();

        return new GalleryPage();
    }

}
