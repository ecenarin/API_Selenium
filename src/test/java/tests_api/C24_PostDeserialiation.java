package tests_api;

import baseUrl.BaseUrlHerokuApp;
import dataStorage.HerOkuStorage;
import dataStorage.RestApiStorage;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

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
        // 1 -Request url ve body'sini hazirlamak
        specHeroku.pathParam("pp1","booking");
        Response response=given()
                .spec(specHeroku)
                .contentType(ContentType.JSON)
                .body(new HerOkuStorage().createMap())
                .when()
                .post("/{pp1}");

        // 2- Expected Data'yi hazirla
        HashMap<String,Object> expdata= new HerOkuStorage().createMap();
        // 3- Response'u kaydet
        HashMap<String,Object> respone=response.as(HashMap.class);
        // 4- Assertion'lari yap
        response
                .then()
                .assertThat()
                .statusCode(200);
        assertEquals( ((Map)expdata.get("booking")).get("firstname"), ((Map)respone.get("booking")).get("firstname"));
        assertEquals( ((Map)expdata.get("booking")).get("lastname"), ((Map)respone.get("booking")).get("lastname"));
        assertEquals( ((Map)expdata.get("booking")).get("totalprice"), ((Map)respone.get("booking")).get("totalprice"));
        assertEquals( ((Map)expdata.get("booking")).get("depositpaid"), ((Map)respone.get("booking")).get("depositpaid"));
        assertEquals( ((Map)expdata.get("booking")).get("additionalneeds"), ((Map)respone.get("booking")).get("additionalneeds"));
        assertEquals( ((Map)((Map) expdata.get("booking")).get("bookingdates")).get("checkin"),
        ((Map)((Map) respone.get("booking")).get("bookingdates")).get("checkin"));
        assertEquals( ((Map)((Map) expdata.get("booking")).get("bookingdates")).get("checkout"),
                ((Map)((Map) respone.get("booking")).get("bookingdates")).get("checkout"));

    }
}
