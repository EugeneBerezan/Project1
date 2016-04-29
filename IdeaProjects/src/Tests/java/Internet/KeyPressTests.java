package Internet;

import PagesInternet.KeyPressPage;
import PagesInternet.MainHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

/**
 * Created by EugeneBerezan on 4/11/16.
 */
public class KeyPressTests extends InternetBaseTest {

    @Test
    public void assertKeyPressText(){

        new MainHomePage()
                .clickOnKeyPressLink();

        Assert.assertTrue(new KeyPressPage().getKeyPressText().equals("Key Presses"));

    }

    @Test
    public void pressZButton() throws AWTException {

        new MainHomePage()
                .clickOnKeyPressLink();
        new KeyPressPage()
                .sendKeys();

// TODO: 4/11/16 Something wrong with Robot, no action from keyboard on browser
//        Assert.assertEquals(new KeyPressPage().getResult(), "Z");

    }

}
