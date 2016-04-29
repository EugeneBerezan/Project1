package Pages;

import org.openqa.selenium.By;

/**
 * Created by EugeneBerezan on 3/22/16.
 */
public class BrokenImagesPage extends MainHomePage{

    private static final By BROKEN_IMAGES_LOCATOR = By.xpath("//img[not(contains(@src,'img'))]");

    public int getBrokenImagesCount(){

        return driver.findElements(BROKEN_IMAGES_LOCATOR).size();

    }

}
