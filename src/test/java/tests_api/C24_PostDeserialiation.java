package tests_api;

import baseUrl.BaseUrlHerokuApp;
import dataStorage.RestApiStorage;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C24_PostDeserialiation extends BaseUrlHerokuApp {
    @Test
    public void name() {
         /*
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response’un asagidaki gibi oldugunu test edin.
    	                Request body


    	            	Response Body // expected data
    	            {
                    "bookingid":24,
                    "booking":{
                        "firstname":"Ahmet",
                        "lastname":"Bulut",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                        ,
                        "additionalneeds":"wi-fi"
                    }
     */
        specHeroku.pathParam("pp1","booking");
        Response response=given()
                .spec(specHeroku)
                .contentType(ContentType.JSON)
                .body(new RestApiStorage().createBodyMap())
                .when()
                .post("/{pp1}");

    }
}
