package REST;

import com.jayway.restassured.response.Response;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;

import static com.jayway.restassured.RestAssured.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.jayway.restassured.RestAssured.get;

public class RestTests {

    @BeforeTest
    public void setUp(){

        RestAssured.baseURI = "http://jsonplaceholder.typicode.com";
    }


    private static Response response;
    private static JSONArray jsonResponse;

    Logger log = LogManager.getLogger(getClass());

    @Test
    public void getPostsCount() throws JSONException {
        log.info("make get request to fetch all posts");

        response = get("http://jsonplaceholder.typicode.com/posts");
        if (response.getStatusCode() != 200) {
            Assert.fail("Status code returned - " + response.getStatusCode());
        }
        log.info("Fetching response in JSON");

        jsonResponse = new JSONArray(response.asString());

        int count = 0;
        log.info("Fetching count of IDs");
        for (int i = 0; i < jsonResponse.length(); i++) {
            count++;
        }

        Assert.assertTrue(count == 100);

    }

    @Test
    public void getCommentsCount() throws JSONException {
        log.info("make get request to fetch all comments");

        response = get("http://jsonplaceholder.typicode.com/comments");

        if (response.getStatusCode() != 200) {
            Assert.fail("Status code returned - " + response.getStatusCode());
        }

        log.info("Fetching response in JSON");
        jsonResponse = new JSONArray(response.asString());

        int count = 0;
        for (int i = 0; i < jsonResponse.length(); i++) {
            if (jsonResponse.getJSONObject(i).getString("body").isEmpty()) {
                count++;
            }
        }

        Assert.assertTrue(500 == count);

    }

    @Test
    public void getEmailByPostIdAndId() throws JSONException {
        String postId = "1";
        String Id = "4";

        log.info("make get request to fetch comment with Post id = 1 and Id = 4");
        response = get("http://jsonplaceholder.typicode.com/comments?postId=" + postId + "&id=" + Id + "");

        if (response.getStatusCode() != 200) {
            Assert.fail("Status code returned - " + response.getStatusCode());
        }

        log.info("Fetching response in JSON");
        jsonResponse = new JSONArray(response.asString());
        String email = jsonResponse.getJSONObject(0).getString("email");
        System.out.println(email);

        Assert.assertEquals(email, "Lew@alysha.tv");
    }

    @Test
    public void getCreatedMessage() throws JSONException {
        String postId = "1";
        String Id = "4";

        log.info("make get request to fetch comment with Post id = 1 and Id = 4");
        response = get("http://jsonplaceholder.typicode.com/comments?postId=" + postId + "&id=" + Id + "");

        if (response.getStatusCode() != 200) {
            Assert.fail("Status code returned - " + response.getStatusCode());
        }

        log.info("Fetching response in JSON");
        jsonResponse = new JSONArray(response.asString());
        String email = jsonResponse.getJSONObject(0).getString("email");

        Assert.assertEquals(email, "Lew@alysha.tv");
    }

    @Test
    public void createData() throws IOException {

        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("http://jsonplaceholder.typicode.com/posts");
        StringEntity input = new StringEntity("{\"userId\":\"1\",\"id\":\"1\",\"title\":\"testTitle\",\"body\":\"This is a test of post message\"}");
        input.setContentType("application/json");
        post.setEntity(input);
        HttpResponse response = client.execute(post);
        System.out.println(response.getStatusLine());
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
        }
    }

    @Test
    public void getUsingHTTPClient() throws IOException {

        HttpGet get = new HttpGet("http://jsonplaceholder.typicode.com/comments");
        HttpClient client = HttpClientBuilder.create().build();
        HttpResponse response = client.execute(get);

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        System.out.println(response.getStatusLine());
        StringBuilder result = new StringBuilder();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

    }

    @Test
    public void postExample() {
        String myJson = "{\"userId\":\"1\",\"id\":\"1\",\"title\":\"testTitle\",\"body\":\"This is a test of post message\"}";

        RestAssured.baseURI = "http://jsonplaceholder.typicode.com/posts";

        Response r = given()
                .contentType("application/json").
                        body(myJson).
                        when().
                        post("");

        String body = r.getBody().asString();
        System.out.println(r.getStatusCode());
        System.out.println(body);

    }

}
