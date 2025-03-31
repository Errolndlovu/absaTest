package API;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class APITest {
    static {
        FileInputStream fis;
        Properties properties;
        String apiBase;
        try {
            fis = new FileInputStream("src/test/resources/config.properties");
             properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        apiBase = properties.getProperty("apiBaseUrl");
        RestAssured.baseURI = apiBase;
    }

    public void testAllBreeds() {
        given()
                .get("/breeds/list/all")
                .then()
                .log().body()
                .statusCode(200)
                .body("status", equalTo("success"));
    }


    public void verifyRetrieverIsWithinTheList(String breed) {
        Response response = RestAssured.given()
                .get("/breeds/list/all")
                .then()
                .statusCode(200)
                .extract()
                .response();

        JsonPath jsonPath = response.jsonPath();
        boolean retrieverExists = jsonPath.getMap("message").containsKey(breed);
        if (retrieverExists) {
            System.out.println(true + " Verify - retriever is within the list");
        } else {
            System.out.println(false + " Verify - retriever is not within the list");
        }
    }

    public void listOfSubBreeds() {
        given()
                .get("/breed/retriever/list")
                .then()
                .log().body()
                .statusCode(200)
                .body("status", equalTo("success"));
    }

    public void randomImages(String subType) {
        given()
                .pathParam("subType", subType)
                .get("breed/retriever/{subType}/images/random")
                .then()
                .statusCode(200)
                .body("status", equalTo("success"))
                .log().body();

    }
}
