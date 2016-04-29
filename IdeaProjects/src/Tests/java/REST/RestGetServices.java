package REST;

import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.expect;
import static org.hamcrest.Matchers.hasItem;

/**
 * Created by EugeneBerezan on 4/15/16.
 */
public class RestGetServices extends RestTests {

    @Test
    public void getPosts() {

        expect()
                .body("title", hasItem("ea molestias quasi exercitationem repellat qui ipsa sit aut"))
                .when()
                .get("/posts?userId=1&id=3");
    }

}
