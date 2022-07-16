package tests_api;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C08_JsonPathSamples {
    @Test
    public void name() {


        /*
        {
        "firstName":"Ahmet",
        "lastName":"Bulut",
        "address":{
            "streetAddress":"Yenimahalle kurtulus cad",
            "city":"Ankara",
            "postalCode":"06100"},
        "age":49,
        "phoneNumbers":[
            {
            "number":"555-123-4567",
            "type":"Cep Telefonu"},
            {
            "number":"312-123-4567",
            "type":"Ev telefonu"}
            ]
        }

         */
        JSONArray phoneNumbers=new JSONArray();
        JSONObject homenumbers=new JSONObject();
        JSONObject cellNumbers=new JSONObject();
        JSONObject address=new JSONObject();
        JSONObject request=new JSONObject();
        cellNumbers.put("number","555-123-4567");
        cellNumbers.put("type","Cep Telefonu");
        homenumbers.put("number","312-123-4567");
        homenumbers.put("type","Ev telefonu");
        address.put("streetAddress","Yenimahalle kurtulus cad");
        address.put("city","Ankara");
        address.put("postalCode","06100");
        phoneNumbers.put(0,cellNumbers);
        phoneNumbers.put(1,homenumbers);
        request.put("firstName","Ahmet");
        request.put("lastName","Bulut");
        request.put("address",address);
        request.put("age",49);
        request.put("phoneNumbers",phoneNumbers);
        // OLusturdugumuz komplex JSON objesindeki degerlere NASIL ULASABILIRIM ?
        System.out.println(request);
        System.out.println("FirstName : " +request.get("firstName"));
        System.out.println("Last name : " + request.get("lastName"));
        System.out.println("StreetAdress : " + request.getJSONObject("address").get("streetAddress"));
        System.out.println("City : " + request.getJSONObject("address").get("city"));
        System.out.println("Postal code : " + request.getJSONObject("address").get("postalCode"));
        System.out.println("Age : " + request.get("age"));
        System.out.println("Phone numbers Type : " + request.getJSONArray("phoneNumbers").getJSONObject(0).get("type"));
        System.out.println("Phone number : " + request.getJSONArray("phoneNumbers").getJSONObject(0).get("number"));
        System.out.println("Home numbers Type : " + request.getJSONArray("phoneNumbers").getJSONObject(1).get("type"));
        System.out.println("Home number : " + request.getJSONArray("phoneNumbers").getJSONObject(1).get("number"));

    }
}
