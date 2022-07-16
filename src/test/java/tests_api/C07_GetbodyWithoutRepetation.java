package tests_api;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C07_GetbodyWithoutRepetation {
    @Test
    public void name() {

        /*
                https://restful-booker.herokuapp.com/booking/91 urlâ€™ine

                bir GET request gonderdigimizde donen Responseâ€™un,
                status codeâ€™unun 200,
                ve content typeâ€™inin application-json,
                ve response bodyâ€™sindeki
                    "firstnameâ€œin,"Susan",
                    ve "lastnameâ€œin, "Jackson",
                    ve "totalpriceâ€œin,612,
                    ve "depositpaidâ€œin,false,
                    ve "additionalneedsâ€œin,"Breakfast"
                oldugunu test edin
         */

        // 1 - request url ve body'sini hazirlamak
        Response response=
                given()
                        .when()
                        .get(" https://restful-booker.herokuapp.com/booking/91");
        response.prettyPrint();
        // 2- Expected Data'yi hazirla
        // 3- Response'u kaydet
        /*
        {
    "firstname": "James",
    "lastname": "Brown",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "Breakfast"
}

         */
        // 4- Assertion'lari yap
        response
                .then()
                .assertThat()
                .body("firstname", equalTo("James")
                ,"lastname",equalTo("Brown")
                ,"totalprice",equalTo(111)
                ,"depositpaid",equalTo(true)
                ,"additionalneeds",equalTo("Breakfast"));
    }
}
