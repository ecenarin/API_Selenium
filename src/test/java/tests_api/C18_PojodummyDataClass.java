package tests_api;

import baseUrl.BaseUrlspecJsonHolder;
import dataStorage.JsonPlaceHolder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C18_PojodummyDataClass extends BaseUrlspecJsonHolder {
    /*
        https://jsonplaceholder.typicode.com/posts/22 url'ine
        bir GET request yolladigimizda donen response’in status kodunun 200
        ve response body’sinin asagida verilen ile ayni oldugunutest ediniz

        Response body :
        {
            "userId":3,
            "id":22,
            "title":"dolor sint quo a velit explicabo quia nam",
            "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
                         um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
        }
     */

    @Test
    public void name() {
        // 1 - request url ve body'sini hazirlamak
        specJsonPlace.pathParams("pp1","posts","pp2",22);
        Response response=given()
                .spec(specJsonPlace)
                .when()
                .get("{pp1}/{pp2}");
        response.prettyPrint();
        // 2- Expected Data'yi hazirla
        JsonPlaceHolder js=new JsonPlaceHolder();
        JSONObject expected=js.putRequestBody();
        // 3- Response'u kaydet
        // 4- Assertion'lari yap
        JsonPath jsonPath=response.jsonPath();
        assertEquals(expected.get("userId"),jsonPath.get("userId"));
        assertEquals(expected.get("id"),jsonPath.get("id"));
        assertEquals(expected.get("title"),jsonPath.get("title"));
        assertEquals(expected.get("body"),jsonPath.get("body"));
    }
}
