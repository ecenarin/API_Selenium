package tests_api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C04_Put_Response_Assertions {
    @Test
    public void name() {

        /*
        https://jsonplaceholder.typicode.com/posts/70 urlâ€™ine asagidaki
        Json formatindaki body ile bir PUT request gonderdigimizde
                {
                "title":"Ahmet",
                "body":"Merhaba",
                "userId":10,
                "id":70
                }
        donen Responseâ€™un,
            status codeâ€™unun 200,
            ve content typeâ€™inin application/json; charset=utf-8,
            ve Server isimli Headerâ€™in degerinin cloudflare,
            ve status Lineâ€™in HTTP/1.1 200 OK
                 */

        //First must create request body as jsonObject
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("title","Ahmet");
        jsonObject.put("body","Merhaba");
        jsonObject.put("userId",10);
        jsonObject.put("id",70);
                    // 1 - request url ve body'sini hazirlamak
        Response response=given()
                .contentType(ContentType.JSON)
                .when()
                .body(jsonObject.toString())
                .put("https://jsonplaceholder.typicode.com/posts/70");
                    // 2- Expected Data'yi hazirla
                    // 3- Response'u kaydet
            response.prettyPrint();
            /*
            {
    "id": 70,
    "title": "Ahmet",
    "body": "Merhaba",
    "userId": 10
        }
             */

                    // 4- Assertion'lari yap
             response.then()
                     .assertThat()
                     .statusCode(200)
                     .contentType(ContentType.JSON)
                     .header("Server","cloudflare")
                     .statusLine("HTTP/1.1 200 OK");

    }
}
