package tests_api;

import baseUrl.BaseUrlspecJsonHolder;
import dataStorage.JsonPlaceHolder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C22_HashMapDeserialization extends BaseUrlspecJsonHolder {
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

        Response body :

            {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
            }
     */
        // 1 -Request url ve body'sini hazirlamak
        specJsonPlace.pathParams("pp1","posts","pp2",70);
        JsonPlaceHolder js=new JsonPlaceHolder();
        HashMap<String,Object> body=js.createBody("Ahmet","Merhaba",10.0,70.0);
        Response response=given()
                .contentType(ContentType.JSON)
                .spec(specJsonPlace)
                .body(body)
                .put("/{pp1}/{pp2}");
        response.prettyPrint();
        // 2- Expected Data'yi hazirla
        HashMap<String,Object> expData=new HashMap<>();
        expData=js.createBody("Ahmet","Merhaba",10.0,70.0);
        // 3- Response'u kaydet
        HashMap<String,Object> responseMap = response.as(HashMap.class);
      /*
      {
    "id": 70,
    "title": "Ahmet",
    "body": "Merhaba",
    "userId": 10
}
       */
        // 4- Assertion'lari yap
        assertEquals(expData.get("id"),responseMap.get("id"));
        assertEquals(expData.get("title"),responseMap.get("title"));
        assertEquals(expData.get("body"),responseMap.get("body"));
        assertEquals(expData.get("userId"),responseMap.get("userId"));



    }
}
