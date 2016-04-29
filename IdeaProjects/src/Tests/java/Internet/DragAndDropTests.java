package Internet;

import PagesInternet.DragAndDropPage;
import PagesInternet.MainHomePage;
import com.google.common.base.Verify;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.FileNotFoundException;

/**
 * Created by EugeneBerezan on 4/1/16.
 */
public class DragAndDropTests extends InternetBaseTest {

    @Test
    public void checkDragAndDropText(){

        new MainHomePage()
                .clickOnDragAndDropElements();

        Assert.assertTrue(new DragAndDropPage().getAssertText().equals("Drag and Drop"));

    }

    @Test
    public void dragAndDropOneTime() throws InterruptedException, AWTException, FileNotFoundException {

        new MainHomePage()
                .clickOnDragAndDropElements();
        new DragAndDropPage()
                .dragAndDrop();

//        Verify.verify(new DragAndDropPage().getColumnAValue().equals("B"));
    }

    @Test
    public void dragAndDropTwoTimes() throws InterruptedException, AWTException, FileNotFoundException {

        new MainHomePage()
                .clickOnDragAndDropElements();
        new DragAndDropPage()
              .dragAndDrop()
                .dragAndDrop();

//        Verify.verify(new DragAndDropPage().getColumnBValue().equals("B"));
    }

}
