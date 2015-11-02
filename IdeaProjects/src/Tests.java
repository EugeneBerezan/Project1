import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Tests {

    public String url = "http://tickets.ua";


    @AfterTest
    public static void tearDawn(){

        WebDriverManager.getInstance().close();

    }

    @Test
    public void firstTest() {
        WebDriverManager.getUrl();


    }

}
