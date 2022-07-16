package tests_api;

import baseUrl.BaseUrlHerokuApp;
import org.junit.Test;

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
    	            }

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
     */
specHeroku.pathParam("pp1","booking");

    }
}
