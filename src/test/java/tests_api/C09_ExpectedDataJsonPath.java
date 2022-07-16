package tests_api;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C09_ExpectedDataJsonPath {
    @Test
    public void name() {

        /*
        https://restful-booker.herokuapp.com/booking urlâ€™ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen responseâ€™un id disinda asagidaki gibi oldugunu test edin.
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

    	            	Response Body//expected data
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
                    // 1 - request url ve body'sini hazirlamak
        JSONObject requestBody=new JSONObject();
        JSONObject inner=new JSONObject();
        inner.put("checkin" , "2021-06-01");
        inner.put("checkout" , "2021-06-10");
            requestBody.put("firstname" , "Ahmet");
            requestBody.put("lastname" , "Bulut");
            requestBody.put("totalprice" , 500);
            requestBody.put("depositpaid" , false);
            requestBody.put("bookingdates",inner);
            requestBody.put("additionalneeds" , "wi-fi");
        Response response=
                given()
                        .contentType(ContentType.JSON)
                        .when()
                        .body(requestBody.toString())
                        .post("https://restful-booker.herokuapp.com/booking");
        response.prettyPrint();

                    // 2- Expected Data'yi hazirla
        /*
        	Response Body//expected data
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
        JSONObject expectedData=new JSONObject();
        JSONObject booking=new JSONObject();
        JSONObject bookingDates=new JSONObject();
        bookingDates.put("checkin","2021-06-01");
        bookingDates.put("checkout","2021-06-10");
        booking.put("firstname","Ahmet");
        booking.put("lastname","Bulut");
        booking.put("totalprice",500);
        booking.put("bookingdates",bookingDates);
        booking.put("depositpaid",false);
        booking.put("additionalneeds","wi-fi");
        expectedData.put("booking",booking);
        //expectedData.put("bookingdates",bookingDates);

                    // 3- Response'u kaydet
                    // 4- Assertion'lari yap
        JsonPath jsonPath=response.jsonPath();
       assertEquals(expectedData.getJSONObject("booking").get("firstname"),jsonPath.get("booking.firstname"));
       assertEquals(expectedData.getJSONObject("booking").get("lastname"),jsonPath.get("booking.lastname"));
       assertEquals(expectedData.getJSONObject("booking").get("totalprice"),jsonPath.get("booking.totalprice"));
       assertEquals(expectedData.getJSONObject("booking").get("depositpaid"),jsonPath.get("booking.depositpaid"));
       assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),jsonPath.get("booking.bookingdates.checkin"));
       assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),jsonPath.get("booking.bookingdates.checkout"));
       assertEquals(expectedData.getJSONObject("booking").get("additionalneeds"),jsonPath.get("booking.additionalneeds"));


    }
}
