package tests_api;

import baseUrl.BaseUrlHerokuApp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C16_BaseUrlHerOku extends BaseUrlHerokuApp {
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
        response.prettyPrint();
        // 2- Expected Data'yi hazirla
        // 3- Response'u kaydet
        // 4- Assertion'lari yap
       int totalResponseSize= response.jsonPath().getList("bookingid").size();
        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("bookingid", Matchers.hasSize(totalResponseSize));


    }

    @Test
    public void name2() {

         /*
        2- https://restful-booker.herokuapp.com/booking endpointine
        asagidaki bodyâ€™ye sahip bir POST request gonderdigimizde
        donen responseâ€™un status codeâ€™unun 200 oldugunu ve â€œfirstnameâ€ degerinin â€œAhmetâ€ oldugunu test edin

            {
            "firstname" : "Ahmet",
            "lastname" : â€œBulut",
            "totalprice" : 500,
            "depositpaid" : false,
            "bookingdates" : {
                   "checkin" : "2021-06-01",
                   "checkout" : "2021-06-10"
                      },
            "additionalneeds" : "wi-fi" }
         */
        // 1 - request url ve body'sini hazirlamak
        specHeroku.pathParam("pp1","booking");
        JSONObject requestBody=new JSONObject();
        JSONObject bkdates=new JSONObject();
        bkdates.put("checkin" , "2021-06-01");
        bkdates.put("checkout" , "2021-06-10");
        requestBody.put("firstname" , "Ahmet");
        requestBody.put("lastname" , "Bulut");
        requestBody.put("totalprice" , 500);
        requestBody.put("depositpaid" , false);
        requestBody.put("bookingdates",bkdates);
        requestBody.put("additionalneeds" , "wi-fi");
        Response response=given()
                .spec(specHeroku)
                .when()
                .get("/{pp1}");
        // 2- Expected Data'yi hazirla
        // 3- Response'u kaydet
        // 4- Assertion'lari yap
        response
                .then()
                .assertThat()
                .contentType(ContentType.JSON)
                .body("booking.firstaname",Matchers.equalTo("Ahmet"));
    }
}
