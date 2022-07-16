package tests_api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C06_PostRequestBodyTest {
    @Test
    public void name() {

        /*
        https://jsonplaceholder.typicode.com/posts  urlâ€™ine asagidaki body ile bir POST request gonderdigimizde
         { "title":"API",
         "body":"API ogrenmek ne guzel",
         "userId":10,
         }
         donen Responseâ€™un,
         status codeâ€™unun 201,
        ve content typeâ€™inin application/json
         ve Response Body'sindeki,
         "title"'in "API" oldugunu
         "userId" degerinin 100'den kucuk oldugunu
         "body" nin "API" kelimesi icerdigini
         test edin.
         */
        // 1 - request url ve body'sini hazirlamak
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("title","API");
        jsonObject.put("body","API ogrenmek ne guzel");
        jsonObject.put("userId",10);
        Response response=
                given()
                        .contentType(ContentType.JSON)
                        .when()
                        .body(jsonObject.toString())
                        .post("https://jsonplaceholder.typicode.com/posts");
        // 2- Expected Data'yi hazirla
        // 3- Response'u kaydet
        // 4- Assertion'lari yap
        response
                .then()
                .assertThat()
                .statusCode(201)
                .body("title", Matchers.equalTo("API")
                ,"userId",Matchers.lessThan(100)
               ,"body",Matchers.containsString("API"));

    }
}
