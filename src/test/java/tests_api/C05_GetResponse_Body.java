package tests_api;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C05_GetResponse_Body {
    @Test
    public void name() {

        /*
        https://jsonplaceholder.typicode.com/posts/44 url'ine bir GET request yolladigimizda
        donen Responseâ€™in
        status code'unun 200,
        ve content type'inin Aplication.JSON,
        		ve response body'sinde bulunan userId'nin 5,
        		ve response body'sinde bulunan title'in "optio dolor molestias sit"
        			oldugunu test edin.
         */
                    // 1 - request url ve body'sini hazirlamak
        Response response=given()
                .when()
                .get("https://jsonplaceholder.typicode.com/posts/44");
                    // 2- Expected Data'yi hazirla
                    // 3- Response'u kaydet
             response.prettyPrint();
             /*
             {
    "userId": 5,
    "id": 44,
    "title": "optio dolor molestias sit",
    "body": "temporibus est consectetur dolore\net libero debitis vel
    velit laboriosam quia\nipsum quibusdam qui itaque fuga rem aut\nea et iure quam sed maxime ut distinctio quae"
        }

              */
                    // 4- Assertion'lari yap
        response
                .then()
                .assertThat()
                .body("userId", Matchers.equalTo(5)
                ,"title",Matchers.equalTo("optio dolor molestias sit"));
    }
}
