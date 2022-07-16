package tests_api;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C02_Get_Response_Assertions {

    @Test
    public void name() {
          /*
        https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request gonderdigimizde donen Response’un,
        status code’unun 200,
        ve content type’inin application/json; charset=utf-8,
        ve Server isimli Header’in degerinin Cowboy,
        ve status Line’in HTTP/1.1 200 OK
         */
        // 1 - request url ve body'sini hazirlamak
        Response response=
                given()
                        .when()
                        .get("https://restful-booker.herokuapp.com/booking/6405");
        response.prettyPrint();
        // 2- Expected Data'yi hazirla
        // 3- Response'u kaydet
        // 4- Assertion'lari yap
        assertEquals(200,response.getStatusCode());
        assertEquals("application/json; charset=utf-8",response.getContentType());
        assertEquals("Cowboy",response.getHeader("Server"));
        assertEquals("HTTP/1.1 200 OK",response.getStatusLine());



    }
}
