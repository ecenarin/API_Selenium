package tests_api;

import baseUrl.BaseUrlspecJsonHolder;
import dataStorage.RestApiStorage;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C25_PutDeserialazation extends BaseUrlspecJsonHolder {

    @Test
    public void name() {
         /*
        https://jsonplaceholder.typicode.com/posts/70 url'ine
        asagidaki body’e sahip bir PUT request yolladigimizda donen response’in
        status kodunun 200,
        content type’inin “application/json; charset=utf-8”,
        Connection header degerinin “keep-alive”
        ve response body’sinin asagida verilen ile ayni oldugunu test ediniz

         Request Body

            {
            "title":"Hasan",
            "body":"Hoscakal",
            "userId":10.0,
            "id":70.0
            }

        Response body : // expected data

            {
            "title":"Hasan",
            "body":"Hoscakal",
            "userId":10.0,
            "id":70.0
            }
     */
        // 1 -Request url ve body'sini hazirlamak
        specJsonPlace.pathParams("pp1","posts","pp2",70);
        RestApiStorage rest=new RestApiStorage();
        HashMap<String,Object> requestBody= rest.createBodyMap("Hasan","Hoscakal",10.0,70.0);
        Response response=given()
                .spec(specJsonPlace)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .put("/{pp1}/{pp2}");
        // 2- Expected Data'yi hazirla
        HashMap<String,Object> expData=rest.createBodyMap("Hasan","Hoscakal",10.0,70.0);
        // 3- Response'u kaydet
        HashMap<String,Object> actualMap=response.as(HashMap.class);
        // 4- Assertion'lari yap
        response.then()
                .assertThat()
                .statusCode(200);
        assertEquals(expData.get("title"),actualMap.get("title"));
        assertEquals(expData.get("body"),actualMap.get("body"));
        assertEquals(expData.get("userId"),actualMap.get("userId"));
        assertEquals(expData.get("id"),actualMap.get("id"));

    }
}
