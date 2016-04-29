package Pages;

import org.openqa.selenium.By;

/**
 * Created by EugeneBerezan on 3/28/16.
 */
public class HoversPage extends MainHomePage {

    private static final By HOVERS_TEXT_LOCATOR = By.linkText("Hovers");
    private static final By USER_AVATAR_1_IMAGE_LOCATOR = By.xpath("(//img[@alt='User Avatar'])[1]");
    private static final By USER_AVATAR_2_IMAGE_LOCAtOR = By.xpath("(//img[@alt='User Avatar'])[2]");
    private static final By USER_AVATAR_3_IMAGE_LOCATOR = By.xpath("(//img[@alt='User Avatar'])[3]");
    private static final By USER_1_TEXT_LOCATOR = By.xpath("(//div[@class='figure'])[1]//h5");
    private static final By USER_2_TEXT_LOCATOR = By.xpath("(//div[@class='figure'])[2]//h5");
    private static final By USER_3_TEXT_LOCATOR = By.xpath("(//div[@class='figure'])[3]//h5");
    private static final By VIEW_PROFILE_USER_1_LINK_LOCATOR = By.xpath("(//div[@class='figure'])[1]//a");
    private static final By VIEW_PROFILE_USER_2_LINK_LOCATOR = By.xpath("(//div[@class='figure'])[2]//a");
    private static final By VIEW_PROFILE_USER_3_LINK_LOCATOR = By.xpath("(//div[@class='figure'])[3]//a");

    public String getHoversText() {
        return driver.findElement(HOVERS_TEXT_LOCATOR).getText();
    }

    public UserProfilePage1 clickOnViewProfileuser1() {

        mouserOverOnElement(USER_AVATAR_1_IMAGE_LOCATOR);
        driver.findElement(VIEW_PROFILE_USER_1_LINK_LOCATOR).click();

        return new UserProfilePage1();
    }

    public UserProfilePage2 clickOnViewProfileuser2() {

        mouserOverOnElement(USER_AVATAR_2_IMAGE_LOCAtOR);
        driver.findElement(VIEW_PROFILE_USER_2_LINK_LOCATOR).click();

        return new UserProfilePage2();
    }

    public UserProfilePage3 clickOnViewProfileuser3() {

        mouserOverOnElement(USER_AVATAR_3_IMAGE_LOCATOR);
        driver.findElement(VIEW_PROFILE_USER_3_LINK_LOCATOR).click();

        return new UserProfilePage3();
    }


}
