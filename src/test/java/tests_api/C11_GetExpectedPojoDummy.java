package tests_api;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C11_GetExpectedPojoDummy {
    @Test
    public void name() {

        /*
        https://jsonplaceholder.typicode.com/posts/22 url'ine
        bir GET request yolladigimizda
        donen response bodyâ€™sinin asagida verilen ile ayni oldugunutest ediniz

        {
            "userId":3,
            "id":22,
            "title":"dolor sint quo a velit explicabo quia nam",
            "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
        }
         */
                    // 1 - request url ve body'sini hazirlamak
        Response response=
                given()
                        .when()
                        .get("https://jsonplaceholder.typicode.com/posts/22");
                    // 2- Expected Data'yi hazirla
        JSONObject expectedData=new JSONObject();
        expectedData.put("userId",3);
        expectedData.put("id",22);
        expectedData.put("title","dolor sint quo a velit explicabo quia nam");
        expectedData.put("body","eos qui et ipsum ipsam suscipit aut sed omnis non odio expedita ear um mollitia molestiae aut atque rem suscipit" +
                " nam impedit esse");

                    // 3- Response'u kaydet
        JsonPath jsonPath=response.jsonPath();
                    // 4- Assertion'lari yap
        assertEquals(expectedData.get("userId"),jsonPath.get("userId"));
        assertEquals(expectedData.get("id"),jsonPath.get("id"));
        assertEquals(expectedData.get("title"),jsonPath.get("title"));
        //assertEquals(expectedData.get("body"),jsonPath.get("body"));
    }
}
