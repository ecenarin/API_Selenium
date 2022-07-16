package tests_api;
import org.json.JSONObject;
import org.junit.Test;

public class C03_CreateJsonObject {
    @Test
    public void  jSonObject01() {
        /*
        {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":1
            }
         */
        JSONObject object=new JSONObject();
        object.put("title","Ahmet");
        object.put("body","Merhaba");
        object.put("userId",1);
        System.out.println(object);

    }

    @Test
    public void jSonObject02() {
        /*
                {
                 "firstname":"Jim",
                 "additionalneeds":"Breakfast",
                 "bookingdates":{
                         "checkin":"2018-01-01",
                         "checkout":"2019-01-01"
                    },
                  "totalprice":111,
                  "depositpaid":true,
                  "lastname":"Brown"
                    }

         */
        JSONObject object=new JSONObject();
        JSONObject innerObject=new JSONObject();
        innerObject.put("checkin","2018-01-01");
        innerObject.put("checkout","2019-01-01");
        object.put("firstname","Jim");
        object.put("additionalneeds","Breakfast");
        object.put("bookingdates",innerObject);
        object.put("totalprice",111);
        object.put("depositpaid",true);
        object.put("lastname","Brown");
        System.out.println(object);



    }

}
