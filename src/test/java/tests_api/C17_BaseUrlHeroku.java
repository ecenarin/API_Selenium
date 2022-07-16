package tests_api;

import baseUrl.BaseUrlHerokuApp;
import baseUrl.BaseUrlspecJsonHolder;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C17_BaseUrlHeroku extends BaseUrlHerokuApp {
    @Test
    public void name() {

        /*
        1-  https://restful-booker.herokuapp.com/booking endpointine
         bir GET request gonderdigimizde donen responseâ€™un
         status codeâ€™unun 200 oldugunu ve Responseâ€™ta 12 booking oldugunu test edin
         */

        // 1 - request url ve body'sini hazirlamak
        specHeroku.pathParam("pp1","booking");
        Response response=given()
                .spec(specHeroku)
                .when()
                .get("/{pp1}");
        // 2- Expected Data'yi hazirla
        // 3- Response'u kaydet
        // 4- Assertion'lari yap
        int totalSize=response.jsonPath().getList("bookingid").size();
        response.then()
                .assertThat()
                .statusCode(200)
                .body("bookingid", Matchers.hasSize(totalSize));


    }
    @Test
    public void name1() {

        /*
        2- https://restful-booker.herokuapp.com/booking endpointine
        gerekli Query parametrelerini yazarak
        â€œfirstnameâ€ degeri â€œEricâ€ olan rezervasyon oldugunu test edecek
        bir GET request gonderdigimizde, donen responseâ€™un
        status codeâ€™unun 200 oldugunu ve â€œEricâ€ ismine sahip en az bir booking oldugunu test edin
         */
        // 1 - request url ve body'sini hazirlamak
        // 2- Expected Data'yi hazirla
        // 3- Response'u kaydet
        // 4- Assertion'lari yap

    }
    @Test
    public void name2() {

        /*
            3- https://restful-booker.herokuapp.com/booking endpointine
            gerekli Query parametrelerini yazarak â€œfirstnameâ€ degeri â€œEricâ€
            ve â€œlastnameâ€ degeri â€œJonesâ€ olan rezervasyon
            oldugunu test edecek bir GET request gonderdigimizde,
            donen responseâ€™un status codeâ€™unun 200 oldugunu
            ve â€œEric Jonesâ€ ismine sahip en az bir booking oldugunu test edin
         */
        // 1 - request url ve body'sini hazirlamak
        // 2- Expected Data'yi hazirla
        // 3- Response'u kaydet
        // 4- Assertion'lari yap

    }
}
