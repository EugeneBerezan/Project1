package Internet;

import PagesInternet.ExitIntentPage;
import PagesInternet.MainHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

/**
 * Created by EugeneBerezan on 4/4/16.
 */
public class ExitIntentTests extends InternetBaseTest {

    @Test
    public void checkExitIntentText(){

        new MainHomePage()
                .clickOnExitIntentLink();

        Assert.assertTrue(new ExitIntentPage().getExitIntentText().equals("Exit Intent"));
    }

    @Test
    public void checkOpenModalWindow() throws InterruptedException, AWTException {

        new MainHomePage()
                .clickOnExitIntentLink();
        new ExitIntentPage()
                .mouserOverToFlashMessage();

        Assert.assertTrue(new ExitIntentPage().checkIfModalWindowIsPresent());
    }

    @Test
    public void closeModalWindow() throws InterruptedException, AWTException {

        new MainHomePage()
                .clickOnExitIntentLink();
        new ExitIntentPage()
                .mouserOverToFlashMessage()
                .closeModalWindow();

        Assert.assertFalse(new ExitIntentPage().checkIfModalWindowIsPresent());
    }

}
