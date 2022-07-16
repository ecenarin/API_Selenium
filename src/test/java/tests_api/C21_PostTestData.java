package tests_api;

import baseUrl.BaseUrlHerokuApp;
import dataStorage.HerOkuStorage;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C21_PostTestData extends BaseUrlHerokuApp {
    @Test
    public void name() {

     /*
    https://restful-booker.herokuapp.com/booking urlâ€™ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen responseâ€™un id haric asagidaki gibi oldugunu test edin.
    	                Request body
    	           {
    	                "firstname" : "Ahmet",
    	                "lastname" : â€œBulut",
    	                "totalprice" : 500,
    	                "depositpaid" : false,
    	                "bookingdates" : {
    	                         "checkin" : "2021-06-01",
    	                         "checkout" : "2021-06-10"
    	                                  },
    	                "additionalneeds" : "wi-fi"
    	                	Response Body
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
    	            }
     */
        HerOkuStorage her=new HerOkuStorage();
specHeroku.pathParam("pp1","booking");
        // 1 -Request url ve body'sini hazirlamak
        Response response=given()
                .spec(specHeroku)
                .contentType(ContentType.JSON)
                .when()
                .body(her.createBody().toString()).post("/{pp1}");
        response.prettyPrint();
        // 2- Expected Data'yi hazirla
        JSONObject expData=her.expData();
        // 3- Response'u kaydet
        /*
        {
    "bookingid": 5418,
    "booking": {
        "firstname": "Ahmet",
        "lastname": "Bulut",
        "totalprice": 500,
        "depositpaid": false,
        "bookingdates": {
            "checkin": "2021-06-01",
            "checkout": "2021-06-10"
        },
        "additionalneeds": "wi-fi"
    }
         */
        // 4- Assertion'lari yap
        JsonPath jp=response.jsonPath();
        assertEquals(expData.getJSONObject("booking").get("firstname"),jp.get("booking.firstname"));
        assertEquals(expData.getJSONObject("booking").get("lastname"),jp.get("booking.lastname"));
        assertEquals(expData.getJSONObject("booking").get("totalprice"),jp.get("booking.totalprice"));
        assertEquals(expData.getJSONObject("booking").get("depositpaid"),jp.get("booking.depositpaid"));
        assertEquals(expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),jp.get("booking.bookingdates.checkin"));
        assertEquals(expData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),jp.get("booking.bookingdates.checkout"));
        assertEquals(expData.getJSONObject("booking").get("additionalneeds"),jp.get("booking.additionalneeds"));


    }
}
