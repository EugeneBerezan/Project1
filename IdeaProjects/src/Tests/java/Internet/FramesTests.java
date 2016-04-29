package Internet;

import Driver.WebDriverManager;
import PagesInternet.FramesPage;
import PagesInternet.FramesPageChecker;
import PagesInternet.IFramePage;
import PagesInternet.MainHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by EugeneBerezan on 4/6/16.
 */
public class FramesTests extends InternetBaseTest {

    @Test
    public void getFramesText() {

        new MainHomePage()
                .clickOnFramesLink();

        Assert.assertEquals(new FramesPage().getFramesText(), "Frames");

    }

    @Test
    public void verifyURL() {

        new MainHomePage()
                .clickOnFramesLink();

        Assert.assertTrue(WebDriverManager.getCurrentURL().contains("frames"));

    }

    @Test
    public void getNestedLeftFrameText(){

        new MainHomePage()
                .clickOnFramesLink();
        new FramesPageChecker()
                .clickOnNestedFramesLink();

        Assert.assertEquals(new FramesPageChecker().getTextFromLeftFrame(), "LEFT");

    }

    @Test
    public void getNestedRightFrameText(){

        new MainHomePage()
                .clickOnFramesLink();
        new FramesPageChecker()
                .clickOnNestedFramesLink();

        Assert.assertEquals(new FramesPageChecker().getTextFromRightFrame(), "RIGHT");

    }

    @Test
    public void getNestedBottomFrameText(){

        new MainHomePage()
                .clickOnFramesLink();
        new FramesPageChecker()
                .clickOnNestedFramesLink();

        Assert.assertEquals(new FramesPageChecker().getTextFromBottomFrame(), "BOTTOM");

    }

    @Test
    public void getNestedMiddleFrameText(){

        new MainHomePage()
                .clickOnFramesLink();
        new FramesPageChecker()
                .clickOnNestedFramesLink();

        Assert.assertEquals(new FramesPageChecker().getTextFromMiddleFrame(), "MIDDLE");

    }

    @Test
    public void newDocumentAction(){

        new MainHomePage()
                .clickOnFramesLink();
        new FramesPageChecker()
                .clickOnIFrameLink();
        new IFramePage()
                .startNewDocument();

        Assert.assertEquals(new IFramePage().getTextFromEditor(), "");

    }

}
