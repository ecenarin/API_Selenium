package tests_api;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C14_PutSoftAssertEXpectedData {
    @Test
    public void name() {
         /*
    http://dummy.restapiexample.com/api/v1/update/21 url’ine
    asagidaki body’ye sahip bir PUT request gonderdigimizde
    donen response’un asagidaki gibi oldugunu test edin.

    Request Body
            {
            "status": "success",
            "data": {
                "name": "Ahmet",
                "salary": "1230",
                "age": "44",
                "id": 40
                    }
           }
     */
        // 1 - request url ve body'sini hazirlamak
        JSONObject requestBody=new JSONObject();
        JSONObject data=new JSONObject();
        data.put("name","Ahmet");
        data.put("salary", "1230");
        data.put("age", "44");
        data.put("id", 40);
        requestBody.put("status", "success");
        requestBody.put("data",data);
        requestBody.put("message", "Successfully! Record has been updated.");

        // 2- Expected Data'yi hazirla

        /*
        esponse Body

            {
            "status": "success",
            "data": {
                "status": "success",
                "data": {
                    "name": "Ahmet",
                    "salary": "1230",
                    "age": "44",
                    "id": 40
                }
            },
            "message": "Successfully! Record has been updated."
        }

         */
        JSONObject expectedData=new JSONObject();
        JSONObject dataOuter=new JSONObject();
        JSONObject dataInner=new JSONObject();
        dataInner.put("name", "Ahmet");
        dataInner.put("salary", "1230");
        dataInner.put("age", "44");
        dataInner.put("id", 40);
        dataOuter.put("status", "success");
        dataOuter.put("data",dataInner);
        expectedData.put("status","success");
        expectedData.put("data",dataOuter);
        expectedData.put("message", "Successfully! Record has been updated.");

        // 3- Response'u kaydet
        /*
        {
    "status": "success",
    "data": {
        "data": {
            "name": "Ahmet",
            "id": 40,
            "salary": "1230",
            "age": "44"
        },
        "message": "Successfully! Record has been updated.",
        "status": "success"
    },
    "message": "Successfully! Record has been updated."
}

         */
        // 4- Assertion'lari yap
        Response response=
                given()
                        .contentType(ContentType.JSON)
                        .when()
                        .body(requestBody.toString())
                        .put("http://dummy.restapiexample.com/api/v1/update/21");
        response.prettyPrint();

        JsonPath jsonPath=response.jsonPath();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(jsonPath.get("status"),expectedData.get("status"));
        softAssert.assertEquals(jsonPath.get("data.data.name"),expectedData.getJSONObject("data").getJSONObject("data").get("name"));
        softAssert.assertEquals(jsonPath.get("data.data.id"),expectedData.getJSONObject("data").getJSONObject("data").get("id"));
        softAssert.assertEquals(jsonPath.get("data.data.salary"),expectedData.getJSONObject("data").getJSONObject("data").get("salary"));
        softAssert.assertEquals(jsonPath.get("data.data.age"),expectedData.getJSONObject("data").getJSONObject("data").get("age"));
        //softAssert.assertEquals(jsonPath.get("data.message"),expectedData.getJSONObject("data").get("message"));
        softAssert.assertEquals(jsonPath.get("data.status"),expectedData.getJSONObject("data").get("status"));
        softAssert.assertEquals(jsonPath.get("message"),expectedData.get("message"));
    }
}
