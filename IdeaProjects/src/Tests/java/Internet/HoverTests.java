package Internet;

import Driver.WebDriverManager;
import PagesInternet.HoversPage;
import PagesInternet.MainHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by EugeneBerezan on 4/8/16.
 */
public class HoverTests extends InternetBaseTest {

    @Test
    public void checkHovertext() {

        new MainHomePage()
                .clickOnHoversLink();

        Assert.assertTrue(new HoversPage().getHoversText().equals("Hovers"));

    }

    @Test
    public void getUser1Text() {

        new MainHomePage()
                .clickOnHoversLink();
        String userName = new HoversPage()
                .mouseHoverOnUser1()
                .getUser1Name();

        Assert.assertEquals(userName, "user1");

    }

    @Test
    public void getUser2Text() {

        new MainHomePage()
                .clickOnHoversLink();
        String userName = new HoversPage()
                .mouseHoverOnUser2()
                .getUser2Name();

        Assert.assertEquals(userName, "user2");

    }

    @Test
    public void getUser3Text() {

        new MainHomePage()
                .clickOnHoversLink();
        String userName = new HoversPage()
                .mouseHoverOnUser3()
                .getUser3Name();

        Assert.assertEquals(userName, "user3");

    }

    @Test
    public void user1Profile() {

        new MainHomePage()
                .clickOnHoversLink();
        String userProfile1Text =
                new HoversPage()
                        .clickOnViewProfileuser1()
                        .getNotFoundText();

        Assert.assertEquals(userProfile1Text, "Not Found");

    }

    @Test
    public void user2Profile() {

        new MainHomePage()
                .clickOnHoversLink();
        String userProfile2Text =
                new HoversPage()
                        .clickOnViewProfileuser2()
                        .getNotFoundText();

        Assert.assertEquals(userProfile2Text, "Not Found");

    }

    @Test
    public void user3Profile() {

        new MainHomePage()
                .clickOnHoversLink();
        String userProfile3Text =
                new HoversPage()
                        .clickOnViewProfileuser3()
                        .getNotFoundText();

        Assert.assertEquals(userProfile3Text, "Not Found");

    }

    @Test
    public void user1URL() {

        new MainHomePage()
                .clickOnHoversLink();
        new HoversPage()
                .clickOnViewProfileuser1();

        Assert.assertTrue(WebDriverManager.getCurrentURL().contains("users/1"));

    }

    @Test
    public void user2URL() {

        new MainHomePage()
                .clickOnHoversLink();
        new HoversPage()
                .clickOnViewProfileuser2();

        Assert.assertTrue(WebDriverManager.getCurrentURL().contains("users/2"));

    }

    @Test
    public void user3URL() {

        new MainHomePage()
                .clickOnHoversLink();
        new HoversPage()
                .clickOnViewProfileuser3();

        Assert.assertTrue(WebDriverManager.getCurrentURL().contains("users/3"));

    }

}
