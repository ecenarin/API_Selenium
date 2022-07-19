package tests_api;

import baseUrl.BaseUrlHerokuApp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojo.BookingBody;
import pojo.Bookingdates;

import java.lang.module.ResolutionException;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;

public class C28_Pojo_Post extends BaseUrlHerokuApp {
    @Test
    public void name() {
         /*
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response’un asagidaki gibi oldugunu test edin.
    	                Request body
    	           {
    	                "firstname" : "Ahmet",
    	                "lastname" : “Bulut",
    	                "totalprice" : 500,
    	                "depositpaid" : false,
    	                "bookingdates" : {
    	                         "checkin" : "2021-06-01",
    	                         "checkout" : "2021-06-10"
    	                                  },
    	                "additionalneeds" : "wi-fi"
    	            }

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
        Bookingdates bookingdates=new Bookingdates("2021-06-01","2021-06-10");
        BookingBody bookingBody=new BookingBody("Ahmet","Bulut",500,false,bookingdates,"wi-fi");
        Response response=given()
                .spec(specHeroku)
                .contentType(ContentType.JSON)
                .body(bookingBody)
                .when()
                .post("/{pp1}");
        // 2- Expected Data'yi hazirla
        Bookingdates expbookingdates=new Bookingdates("2021-06-01","2021-06-10");
        BookingBody expData=new BookingBody("Ahmet","Bulut",500,false,bookingdates,"wi-fi");
        // 3- Response'u kaydet
        BookingBody actualData=response.as(BookingBody.class);
        // 4- Assertion'lari yap
        response
                .then()
                .assertThat()
                .statusCode(200);

        Assert.assertEquals(expData.getFirstname(),actualData.getFirstname());
        Assert.assertEquals(expData.getLastname(),actualData.getLastname());
        Assert.assertEquals(expData.getAdditionalneeds(),actualData.getAdditionalneeds());
        Assert.assertEquals(expData.getDepositpaid(),actualData.getDepositpaid());
        Assert.assertEquals(expData.getTotalprice(),actualData.getTotalprice());

    }
}
