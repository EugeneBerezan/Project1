package Internet;

import PagesInternet.DropDownPage;
import PagesInternet.MainHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by EugeneBerezan on 4/1/16.
 */
public class DropDownTests extends InternetBaseTest {

    @Test
    public void checkDropDownTitle(){

        new MainHomePage()
                .clickOnDropDownLink();

        Assert.assertTrue(new DropDownPage().getAssertText().equals("Dropdown List"));

    }

    @Test
    public void selectOption1(){

        new MainHomePage()
                .clickOnDropDownLink();

        new DropDownPage()
                .selectOption1();

        Assert.assertTrue(new DropDownPage().isOption1Selected());

    }

    @Test
    public void selectOption2(){

        new MainHomePage()
                .clickOnDropDownLink();

        new DropDownPage()
                .selectOption2();

        Assert.assertTrue(new DropDownPage().isOption2Selected());

    }
}
