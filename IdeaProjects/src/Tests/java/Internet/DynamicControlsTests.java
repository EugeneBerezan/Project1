package Internet;

import PagesInternet.DynamicControlPage;
import PagesInternet.MainHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by EugeneBerezan on 4/4/16.
 */
public class DynamicControlsTests extends InternetBaseTest {

    @Test
    public void checkDynamicControlsText(){

        new MainHomePage()
                .clickOnDynamicControlsLink();

        Assert.assertEquals(new DynamicControlPage().getDynamicControlsText(), "Dynamic Controls");

    }

    @Test
    public void removeCheckbox1(){

        new MainHomePage()
                .clickOnDynamicControlsLink();
        new DynamicControlPage()
                .clickOnRemoveButton();

        Assert.assertFalse(new DynamicControlPage().isCheckboxPresent());

    }

    @Test
    public void removeCheckbox2(){

        new MainHomePage()
                .clickOnDynamicControlsLink();
        new DynamicControlPage()
                .clickOnRemoveButton();

        Assert.assertTrue(new DynamicControlPage().isItIsGoneMessagePresent());

    }

    @Test
    public void addCheckbox(){

        new MainHomePage()
                .clickOnDynamicControlsLink();
        new DynamicControlPage()
                .clickOnRemoveButton()
                .clickOnAddButton();


        Assert.assertTrue(new DynamicControlPage().isItIsBackMessagePresent());

    }

    @Test
    public void addCheckbox2(){

        new MainHomePage()
                .clickOnDynamicControlsLink();
        new DynamicControlPage()
                .clickOnRemoveButton()
                .clickOnAddButton();


        Assert.assertTrue(new DynamicControlPage().isCheckboxPresent());

    }



}
