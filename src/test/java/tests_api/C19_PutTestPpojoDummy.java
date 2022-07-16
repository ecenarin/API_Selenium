package tests_api;

import baseUrl.BaseUrlspecJsonHolder;
import dataStorage.JsonPlaceHolder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class C19_PutTestPpojoDummy extends BaseUrlspecJsonHolder {
    @Test
    public void name() {

    /*
        https://jsonplaceholder.typicode.com/posts/70 url'ine
        asagidaki bodyâ€™e sahip bir PUT request yolladigimizda donen responseâ€™in
        status kodunun 200,
        content typeâ€™inin â€œapplication/json; charset=utf-8â€,
        Connection header degerinin â€œkeep-aliveâ€
        ve response bodyâ€™sinin asagida verilen ile ayni oldugunu test ediniz

         Request Body

            {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
            }


     */
        // 1 -Request url ve body'sini hazirlamak
        specJsonPlace.pathParams("pp1","posts","pp2","70");
        JsonPlaceHolder js=new JsonPlaceHolder();
        JSONObject body=js.createJsonObject("Ahmet","Merhaba",10,70);
        Response response=given()
                .spec(specJsonPlace)
                .contentType(ContentType.JSON)
                .when()
                .body(body.toString())
                .put("/{pp1}/{pp2}");
        response.prettyPrint();
        // 2- Expected Data'yi hazirla
        /*
         Response body (Expected Data) :

            {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
            }
         */
        JSONObject expectedData=js.createJsonObject("Ahmet","Merhaba",10,70);
        // 3- Response'u kaydet
        /*
        {
    "id": 70,
    "title": "Ahmet",
    "body": "Merhaba",
    "userId": 10
}

         */
        // 4- Assertion'lari yap
       JsonPath jpath= response.jsonPath();
       assertEquals(expectedData.get("id"),jpath.get("id"));
       assertEquals(expectedData.get("title"),jpath.get("title"));
       assertEquals(expectedData.get("body"),jpath.get("body"));
       assertEquals(expectedData.get("userId"),jpath.get("userId"));
    }
}
