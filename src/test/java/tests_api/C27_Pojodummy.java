package tests_api;

import baseUrl.BaseUrlHerokuApp;
import baseUrl.BaseUrlspecJsonHolder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojo.PojoHerOkuBody;


import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;



public class C27_Pojodummy extends BaseUrlspecJsonHolder {
    @Test
    public void pojo() {
          /*
        https://jsonplaceholder.typicode.com/posts/70 url'ine
        asagidaki body’e sahip bir PUT request yolladigimizda donen response’in
        status kodunun 200,
        content type’inin “application/json; charset=utf-8”,
        Connection header degerinin “keep-alive”
        ve response body’sinin asagida verilen ile ayni oldugunu test ediniz

         Request Body

            {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
            }

        Response body : // expected data

            {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
            }
     */
        // 1 -Request url ve body'sini hazirlamak
   specJsonPlace.pathParams("pp1","posts","pp2",70);
        PojoHerOkuBody requestBody=new PojoHerOkuBody("Ahmet","Merhaba",10,70);
        Response response=given()
                .contentType(ContentType.JSON)
                .spec(specJsonPlace)
                .body(requestBody)
                .when()
                .put("/{pp1}/{pp2}");


        // 2- Expected Data'yi hazirla
        PojoHerOkuBody expData=new PojoHerOkuBody("Ahmet","Merhaba",10,70);
        // 3- Response'u kaydet
        PojoHerOkuBody actual=response.as(PojoHerOkuBody.class);
        // 4- Assertion'lari yap
        response
                .then()
                .assertThat()
                .statusCode(200);
        assertEquals(expData.getTitle(),actual.getTitle() );
        assertEquals(expData.getBody(),actual.getBody());
        assertEquals(expData.getId(),actual.getId());
        assertEquals(expData.getUserId(),actual.getUserId());

    }
}
