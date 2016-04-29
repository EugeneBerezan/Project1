package Internet;

import PagesInternet.CheckboxesPage;
import PagesInternet.MainHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by EugeneBerezan on 3/31/16.
 */
public class CheckboxesTests extends InternetBaseTest {

    @Test
    public void getCheckboxesTitle(){

        new MainHomePage()
                .clickOnCheckboxesLink();

        Assert.assertTrue(new CheckboxesPage().getCheckboxText().equals("Checkboxes"));


    }

    @Test
    public void selectFirstCheckbox(){

        new MainHomePage()
                .clickOnCheckboxesLink();
        new CheckboxesPage()
                .selectCheckbox1();

        Assert.assertTrue(new CheckboxesPage().isCheckbox1Selected());

    }

    @Test
    public void selectSecondCheckbox(){

        new MainHomePage()
                .clickOnCheckboxesLink();
        new CheckboxesPage()
                .selectCheckbox2();

        Assert.assertTrue(new CheckboxesPage().isCheckbox2Selected());

    }

    @Test
    public void selectAllCheckbox(){

        new MainHomePage()
                .clickOnCheckboxesLink();
        new CheckboxesPage()
                .selectAllCheckboxes();

        Assert.assertTrue(new CheckboxesPage().areAllCheckboxesSelected());

    }

    @Test
    public void deSelectCheckbox1(){

        new MainHomePage()
                .clickOnCheckboxesLink();
        new CheckboxesPage()
                .selectCheckbox1()
                .deselectCheckbox1();

        Assert.assertFalse(new CheckboxesPage().isCheckbox1Selected());

    }

    @Test
    public void deSelectCheckbox2(){

        new MainHomePage()
                .clickOnCheckboxesLink();
        new CheckboxesPage()
                .selectCheckbox2()
                .deselectCheckbox2();

        Assert.assertFalse(new CheckboxesPage().isCheckbox2Selected());

    }

    @Test
    public void deSelectAllCheckboxes(){

        new MainHomePage()
                .clickOnCheckboxesLink();
        new CheckboxesPage()
                .selectAllCheckboxes()
                .deSelectAllCheckboxes();

        Assert.assertFalse(new CheckboxesPage().areAllCheckboxesSelected());

    }

    @Test
    public void oneCheckboxSelected(){

        new MainHomePage()
                .clickOnCheckboxesLink();
        new CheckboxesPage()
                .selectAllCheckboxes()
                .deselectCheckbox1();

        Assert.assertEquals(new CheckboxesPage().howManyCheckboxesSelected(), 1);

    }

}
