package tests_api;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get_API_Questioning {

    @Test
    public void name() {

        /*
        https://restful-booker.herokuapp.com/booking/10 urline bir GET request gonderdigimizde donen Response'un,
        status code'unun 200,
        ve content type'inin application/json; charset=utf-8,
        ve Server isimli Header'in degerinin Cowboy,
        ve status Line'in HTTP/1.1 200 OK
        ve response suresinin 5 sn'den kisa oldugunu manuel olarak test ediniz.
         */

                    // 1 - request url ve body'sini hazirlamak
        Response response=given()
                            .when()
                            .get("https://restful-booker.herokuapp.com/booking");
                            // 2- Expected Data'yi hazirla
                            // 3- Response'u kaydet
        System.out.println("Content type : " + response.getContentType());
        System.out.println("Header degeri : " + response.getHeader("Server"));
        System.out.println("Status Line : " + response.getStatusLine());
        System.out.println("Response time : " + response.getTime());
                            // 4- Assertion'lari yap
    }
}
