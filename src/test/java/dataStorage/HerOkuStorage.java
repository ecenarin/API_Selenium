package dataStorage;

import netscape.javascript.JSObject;
import org.json.JSONObject;

public class HerOkuStorage {

    public JSONObject  createBody(){
        /*
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
         */
        JSONObject big=new JSONObject();
        JSONObject lit=new JSONObject();
        lit.put("checkin" , "2021-06-01");
        lit.put("checkout" , "2021-06-10");
        big.put("totalprice" , 500);
        big.put("depositpaid" , false);
        big.put( "firstname" , "Ahmet");
        big.put("lastname" ,"Bulut");
        big.put("bookingdates",lit);
        big.put("additionalneeds" , "wi-fi");

        return big;
    }
    public JSONObject  expData(){
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
      JSONObject bigger=new JSONObject();
      JSONObject big=new JSONObject();
      JSONObject lit=new JSONObject();
      lit.put("checkin","2021-06-01");
      lit.put("checkout","2021-06-10");
      big.put("firstname", "Ahmet");
      big.put("lastname", "Bulut");
      big.put("totalprice", 500);
      big.put("bookingdates",lit);
      big.put("depositpaid", false);
      bigger.put("booking",big);
      big.put("additionalneeds", "wi-fi");

      return bigger;
    }

}
