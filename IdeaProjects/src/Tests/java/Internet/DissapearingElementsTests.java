package Internet;

import PagesInternet.*;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by EugeneBerezan on 4/1/16.
 */
public class DissapearingElementsTests extends InternetBaseTest {

    @Test
    public void checkDynamicElementsTitle(){

        new MainHomePage()
                .clickOnDissapearingElements();
        Assert.assertTrue(new DissapearingElementsPage().getDissaperingElementsText().equals("Disappearing Elements"));
    }

    @Test
    public void clickOnHomeButton(){

        new MainHomePage()
                .clickOnDissapearingElements();

        new DissapearingElementsPage()
                .clickOnHomeButton();

        Assert.assertTrue(new MainHomePage().getWelcomeText().equals("Welcome to the Internet"));
    }

    @Test
    public void clickOnAboutButton(){

        new MainHomePage()
                .clickOnDissapearingElements();

        new DissapearingElementsPage()
                .clickOnAboutButton();

        Assert.assertTrue(new AboutSubPage().getAssertText().equals("Not Found"));
    }


    @Test
    public void clickOnContatUsButton(){

        new MainHomePage()
                .clickOnDissapearingElements();

        new DissapearingElementsPage()
                .clickOnContactUsButton();

        Assert.assertTrue(new ContactUsPage().getAssertText().equals("Not Found"));
    }


    @Test
    public void clickOnPortfolioButton(){

        new MainHomePage()
                .clickOnDissapearingElements();

        new DissapearingElementsPage()
                .clickOnPortfolioButton();

        Assert.assertTrue(new PortfolioPage().getAssertText().equals("Not Found"));
    }


}
