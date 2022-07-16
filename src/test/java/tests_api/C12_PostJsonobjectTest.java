package tests_api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C12_PostJsonobjectTest {
    @Test
    public void name() {

    /*
            https://restful-booker.herokuapp.com/booking
             urlâ€™ine asagidaki body'ye sahip
            bir POST request gonderdigimizde
                       {
                            "firstname" : "Ahmet",
                            "lastname" : "Bulut",
                            "totalprice" : 500,
                            "depositpaid" : false,
                            "bookingdates" : {
                                "checkin" : "2021-06-01",
                                "checkout" : "2021-06-10"
                            },
                            "additionalneeds" : "wi-fi"
                        }

     */

                    // 1 - request url ve body'sini hazirlamak
        //oncelikle json object icersine request olarak gonderecegimiz post'u hazırlıyoruz
        JSONObject request=new JSONObject();
        JSONObject inner=new JSONObject();
        inner.put("checkin" , "2021-06-01");
        inner.put("checkout" , "2021-06-10");
        request.put("firstname" , "Ahmet");
        request.put("lastname" , "Bulut");
        request.put("totalprice" , 500);
        request.put("depositpaid" , false);
        request.put("bookingdates",inner);
        request.put("additionalneeds" , "wi-fi");
        //repsonse objesiyle bilgileri belirli url'e post edcegiz
        Response response=
                given()
                        .contentType(ContentType.JSON)
                        .when()
                        .body(request.toString())
                        .post("https://restful-booker.herokuapp.com/booking");
        response.prettyPrint();
                    // 2- Expected Data'yi hazirla
                    // 3- Response'u kaydet

        /*
          donen Responseâ€™un,
            status codeâ€™unun 200,
            ve content typeâ€™inin application-json,
            ve response bodyâ€™sindeki
                "firstnameâ€œin,"Ahmet",
                ve "lastnameâ€œin, "Bulut",
                ve "totalpriceâ€œin,500,
                ve "depositpaidâ€œin,false,
                ve "checkin" tarihinin 2021-06-01
                ve "checkout" tarihinin 2021-06-10
                ve "additionalneedsâ€œin,"wi-fi"
            oldugunu test edin
             /*
        {
    "bookingid": 5578,
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
}

         */
        // 4- Assertion'lari yap
             response
                .then()
                .assertThat()
                .body("booking.firstname", equalTo("Ahmet")
                        ,"booking.lastname",equalTo("Bulut")
                ,"booking.totalprice",equalTo(500)
                ,"booking.depositpaid",equalTo(false)
                ,"booking.bookingdates.checkin",equalTo("2021-06-01")
                ,"booking.bookingdates.checkout",equalTo("2021-06-10")
                ,"booking.additionalneeds",equalTo("wi-fi"));




    }
}
